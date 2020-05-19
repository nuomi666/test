package com.xjy.autotest.shelluser;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.ShellInitDataBase;
import com.xjy.autotest.testbase.ShellmerchantTestBase;
import com.xjy.autotest.testbase.ShelluserTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.yc.shell.user.api.enums.BindStatus;
import com.xyb.yc.shell.user.api.enums.Sex;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.shellmerchant.GasMerchantDO;
import dal.model.shelluser.*;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.yc.shell.user.api.result.RegisterUserResult;
import com.xyb.yc.shell.user.api.UserService;
import com.xyb.yc.shell.user.api.order.RegisterOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.String;

/**
 * @ClassName UserServiceRegisterTest
 * @Author noodles
 * @Date 2019/5/14 12:52
 * @Version 1.0
 *
 * 【ADK执行顺序】：------------------------------------------------------------------------------------------------------
 * 1.before->invoke->after->end(ActivityExecutorContainer)
 *
 * 【服务应用场景】：------------------------------------------------------------------------------------------------------
 * 1.用户在被引导至微信公众号进入会员中心进行第一次注册，可传入手机号、短信验证码、openid、微信昵称、性别、生日、头像地址。
 * 2.老用户从微信公众号进入会员中心重新激活已注册会员的场景，可传入手机号、短信验证码、openid、微信昵称、性别、生日、头像地址。
 * 3.服务使用入口：POS机注册会员、会员公众号会员中心注册/激活会员、BOSS后台导入会员。
 *
 * 【业务逻辑】：---------------------------------------------------------------------------------------------------------
 * 1.信息是否完善判断属性：user表（性别&&生日&&真实名&&证件号）&& user_car_info表(车牌号)。
 * 2.传入短信验证码可以注册（会员自主注册），不传入也可以注册（BOSS后台导入）。 3.目前只有微信可以注册或绑定，支付宝未实现（业务口子已经关闭）
 *
 * 【开发实现逻辑】：-----------------------------------------------------------------------------------------------------
 * 1.入参校验=>短信验证码验证=>手机号+商户号查询是否已注册=>不存在就注册，存在就更新。
 * 2.a.注册流程与逻辑：=>注册时检查商户是否存在和运行状态=>调用清结算创建账户=>持久化壳牌业务会员数据=>持久化车辆信息(可多辆但实际业务没有，车辆会判重）
 * =>调用神马付设置支付密码接口（目前调用的是神马付更新接口不合理）=>如果是推荐注册，则会进入持久化壳牌推荐关系数据。
 * b.更新流程与逻辑：=>会员基本信息（真实名、等级、生日、昵称、头像地址、性别）会更新，引入来源和支付密码不更新，其中如果被更新会员的没有生日且请求对象中有传入生日，则更新生日和生日月日值
 * =>再更新会员车辆信息,如果存在且相同就不更新，如果存在不同就删除后再添加=>最后更新神马付账户信息（真实名）。
 * 3.=>与微信绑定关系，前置条件是openid不为空（一个微信号只能绑定一个会员，一个会员只能被一个微信号绑定）（但是在极端情况下（幂等），会根据openid直接更新会员ID和状态）
 * =>创建“注册/更新”会员通知任务（分析通知任务和营销通知任务），存储在系统数据库表notify_task
 * =>执行发送任务。(发送给MQ失败会保留数据否则不，不管营销和分析是否接收）。
 * 神马付内部逻辑（检查partnerId是对应的会员否存在且会员状态正常=>创建会员和账号）
 *
 * 【服务设计问题】：------------------------------------------------------------------------------------------------------
 * 1.用户在注册/激活时不会填写多个车辆信息，至多单个，设计冗余。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
 * 2.注册和激活当分离。
 * 3.注册接口当根据不同注册来源分别队待，分BOSS后台EXCLE导入（不传入短信验证码）和用户自主注册接口（要传入短信验证码）。。。。。。。。。
 * 4.与微信绑定节点问题： 问a：目前把"用户已绑定过微信"与“微信号已绑定过用户”两种情况笼统校验一并处理，应当区分校验处理返回。
 * 问b：新增绑定关系为啥要更新不知道，请说出场景来。如果是为了防止幂等，那当处理返回当前绑定成功。
 * 问c：如需一个微信号只绑定一个会员，且一个会员绑定一个微信号，且防止极端并发情况，需把PartnerId+openid唯一索引修改为PartnerId+openid+状态，
 * 并增加索引userId+状态+类型的唯一索引。
 * 5.user表设计问题：register_from注释为注册来源，应该修改为注册方式。import_source该字段意义不大，可以合并至register_from字段去表达。
 * 6.神马付USER表的设计了platPartnerId（后期在api1.0.5版本之后增加的），但壳牌之后未曾升级api依赖，所以至今壳牌所调用的神马付的注册会员接口对象中却没有该属性成员，进而注册也不存在值。
 * 7.memberType会员类型（普通用户和专车用户），名字与用意不符合，当叫做userType 8.昵称目前没有同步给神马付
 *
 * 【涉及系统表名】：------------------------------------------------------------------------------------------------------
 * yc-shell-user系统：{user(会员基本信息)、user_car_info（车辆信息）、user_card_info（会员卡信息--神马付账号）、
 * user_pay_tool_info（微信/支付宝会员绑定）、user_invite_log（会员推荐信息）、notify_task（分析&营销通知信息）}
 * yc-shell-merchant系统：{gas_merchant(商户信息表-业务判断数据)、gas_merchant_source_data（商户来源信息表-业务判断数据）}
 * xyb-user系统：{user(会员信息)、account（账户信息）}
 *
 * 【用例整体设计】：------------------------------------------------------------------------------------------------------
 * 1.整体用例的预置数据商户信息采用初始化数据插入（初始数据放在代码中）。
 * 2.用例清除和校验壳牌产品层的表的数据采用不带条件的清除和查询断言校验，神马付底层考虑到有先前所写用例采用基础数据与用例分离设计，所以保留带条件清除和查询断言。
 **/
public class UserServiceRegisterTest extends SpringBootTestBase {
	@Reference(version = DUBBO_VERSION_1)
	UserService userService;
	@Autowired
	ShelluserTestBase shellUserTestBase;
	@Autowired
	ShellInitDataBase shellInitDataBase;
	@Autowired
	UserTestBase userTestBase;
	@Autowired
	ShellmerchantTestBase shellmerchantTestBase;
	@Autowired
	Gas_silverboltTestBase gasSilverboltTestBase;
	
	/**
	 * TODO 数据流至营销和分析系统还未做校验
	 * 注册业务：--------------------------------------------------------------------------------------------------------
	 * 1001、所有必填项注册（mobile、partnerId、type、importSource）（从BOSS入口导入会员场景）
	 * 1002、所有参数传入，且最大值。（带验证码注册属于用户自主注册场景）（包含输入两次错误验证码，第三次输入正确成功注册。。。。。。。。。
	 * 1003-1005、剩余业务属性（会员等级）枚举值测试
	 * 1000、在加好油业务场景存在该会员已存在于其它油站商户下，在新的油站商户下注册的场景，需要有次干扰注册场景
	 * 激活业务：--------------------------------------------------------------------------------------------------------
	 * 1006、与原微信号解绑后，再通过激活接口来绑定场景。(更新基本信息、更新车辆信息）
	 * 1007、从pos注册的会员，无其它信息（更新基本信息、更新添加车辆、添加微信绑定关系）
	 * 1008、单纯激活，不设置支付密码和其它基本信息（只更新昵称、头像地址、等级），不添加车辆，添加微信绑定关系。
	 */
	@AutoTest(file = "shelluser/userServiceRegisterTestSuccess.csv")
	@DisplayName("自主注册/激活--成功用例")
	public void userServiceRegisterTestSuccess(// 基本参数
												int testId, Status status, String code, String message,
												String description,
												// 业务参数
												RegisterOrder registerOrder, String carNo, String carNo2, String carNo3,
												//校验参数
												Sex sex2, String grade2, String importSource2, String identifier,
												String accountTag, String bindStatus) {
		
		// 清除数据
		shellUserTestBase.cleanUser();
		shellUserTestBase.cleanUserCarInfo();
		shellUserTestBase.cleanUserCardInfo();
		shellUserTestBase.cleanUserPayToolInfo();
		shellUserTestBase.cleanUserInviteLog();
		shellUserTestBase.cleanNotifyTask();
		userTestBase.cleanUserByMobile(registerOrder.getMobile());
		gasSilverboltTestBase.cleanGasUser();
		// 准备数据
		//		定义获取初始化数据变量
		String partnerId = null;
		String openId = null;
		String userId = null;
		String importSource = null;
		Date rawAddTime = DateUtil.now();
		Date birthday = DateUtil.now();
		String payPassword = null;
		String sex = null;
		String realName = null;
		//		准备商户信息
		Map<String, Object> param = shellInitDataBase.initPartnerUser();
		partnerId = param.get("partnerId").toString();
		
		//		准备被更新会员信息
		Map<String, Object> param2 = new HashMap<String, Object>();
		if (testId == 1006 || testId == 1007 || testId == 1008) {
			param2 = shellInitDataBase.initShellUser();
			openId = param2.get("openId").toString();
			userId = param2.get("userId").toString();
			importSource = param2.get("importSource").toString();
			rawAddTime = (Date) param2.get("rawAddTime");
			birthday = (Date) param2.get("birthday");
			payPassword = param2.get("payPassword").toString();
			sex = param2.get("sex").toString();
			realName = param2.get("realName").toString();
		}
		//		更新绑定信息为已解绑，为激活制造场景
		if (testId == 1006) {
			UserPayToolInfoDO userPayToolInfoDO = shellUserTestBase.findUserPayToolInfoByOpenId(openId).get(0);
			userPayToolInfoDO.setBindStatus(BindStatus.UNBIND.code());
			userPayToolInfoDO.setUserId(null);
			shellUserTestBase.updateUserPayToolInfoByOpenId(openId, userPayToolInfoDO);
		}
		if (testId == 1007 || testId == 1008) {
			//清除与微信绑定信息
			shellUserTestBase.cleanUserPayToolInfoByUserId(userId);
			//清除车辆信息
			shellUserTestBase.cleanUserCarInfoByUserId(userId);
		}
		
		//		模拟插入短信验证码进入redis被被测对象读取
		if (testId != 1001) {
			shellInitDataBase.insertRedisVerificationCode(registerOrder.getPartnerId(), registerOrder.getMobile(),
				registerOrder.getSmsValidateCode());
		}
		// 测试过程
		List<String> carNumber = new ArrayList<String>();
		if (testId == 1002 || testId == 1007) {
			carNumber.add(carNo);
			carNumber.add(carNo2);
			carNumber.add(carNo3);
		}
		if (testId == 1003 || testId == 1004 || testId == 1005 || testId == 1006) {
			carNumber.add(carNo);
		}
		//		激活场景：装入被激活会员已存在的手机号和openId，覆盖读取CSV中的值
		if (testId == 1006 || testId == 1007 || testId == 1008) {
			registerOrder.setOpenId(openId);
		}
		if (testId == 1002) {
			//输入两次错误的
			registerOrder.setSmsValidateCode("5555");
			userService.register(registerOrder);
			registerOrder.setSmsValidateCode("5555");
			userService.register(registerOrder);
			//输入正确的
			registerOrder.setSmsValidateCode("1234");
		}
		//		重新赋值覆盖从csv的读取结果
		registerOrder.setPartnerId(partnerId);
		registerOrder.setCarNumber(carNumber);
		// 调用接口
		RegisterUserResult result = userService.register(registerOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertEquals(message, result.getMessage());
		assertEquals(description, result.getDescription());
		assertNotNull(result.getUserId());
		// 数据验证
		//	xyb_user数据库
		String accountNo = userTestBase.findAccountByUserIdAndTag(result.getUserId(), accountTag).get(0).getAccountNo();
		if (testId == 1001) {
			//	shell_user数据库-----------------------------------------------------------------------------------------
			//	 	user表断言
			userAssert(1, 1, registerOrder.getMobile(), result.getUserId(), registerOrder.getPartnerId(),
				registerOrder.getBirthday(), registerOrder.getNickName(), registerOrder.getRealName(),
				registerOrder.getHeadImgUrl(), sex2.getCode(), grade2, DateUtil.now(), identifier, importSource2);
			//		user_car_info表断言
			userCarInfoAssert(0, 0, null, null);
			//		user_card_info表断言
			userCardInfoAssert(1, 1, result.getUserId(), registerOrder.getPartnerId(), accountNo, accountTag,
				accountNo);
			//		user_pay_tool_info表断言
			userPayToolInfoAssert(0, 0, null, null, null, null, null);
			//	神马付xyb_user数据库--------------------------------------------------------------------------------------
			//		神马付user表断言
			xybUserByPartnerIdAndMobileAssert(registerOrder.getPartnerId(), registerOrder.getMobile(), 1, 1,
				result.getUserId(), null, registerOrder.getRealName());
			//		神马付account表断言
			accountByUserIdAssert(result.getUserId(), 1, 1, null, registerOrder.getPartnerId(), accountNo, accountTag);
			
			//	shell_marketpc数据库-------------------------------------------------------------------------------------
			
			//	silverbolt数据库-----------------------------------------------------------------------------------------
		}
		if (testId == 1002 || testId == 1003 || testId == 1004 || testId == 1005) {
			//	shell_user数据库-----------------------------------------------------------------------------------------
			//	 	user表断言
			userAssert(1, 1, registerOrder.getMobile(), result.getUserId(), registerOrder.getPartnerId(),
				registerOrder.getBirthday(), registerOrder.getNickName(), registerOrder.getRealName(),
				registerOrder.getHeadImgUrl(), registerOrder.getSex().getCode(), registerOrder.getGrade().getCode(),
				registerOrder.getRawAddTime(), identifier, registerOrder.getImportSource());
			//		user_car_info表断言
			if (testId == 1002) {
				userCarInfoAssert(3, 1, result.getUserId(), carNo);
				userCarInfoAssert(3, 2, result.getUserId(), carNo2);
				userCarInfoAssert(3, 3, result.getUserId(), carNo3);
			}
			if (testId == 1003 || testId == 1004 || testId == 1005) {
				userCarInfoAssert(1, 1, result.getUserId(), carNo);
			}
			//		user_card_info表断言
			userCardInfoAssert(1, 1, result.getUserId(), registerOrder.getPartnerId(), accountNo, accountTag,
				accountNo);
			//		user_pay_tool_info表断言
			userPayToolInfoAssert(1, 1, registerOrder.getPartnerId(), registerOrder.getOpenId(), result.getUserId(),
				bindStatus, registerOrder.getType().code());
			//	神马付xyb_user数据库--------------------------------------------------------------------------------------
			//		神马付user表断言
			xybUserByPartnerIdAndMobileAssert(registerOrder.getPartnerId(), registerOrder.getMobile(), 1, 1,
				result.getUserId(), registerOrder.getPayPwd(), registerOrder.getRealName());
			//		神马付account表断言
			accountByUserIdAssert(result.getUserId(), 1, 1, null, registerOrder.getPartnerId(), accountNo, accountTag);
			
			//	shell_marketpc数据库-------------------------------------------------------------------------------------
			
			//	silverbolt数据库-----------------------------------------------------------------------------------------
		}
		if (testId == 1006 || testId == 1007) {
			assertEquals(userId, result.getUserId());
			//	shell_user数据库-----------------------------------------------------------------------------------------
			//	 	user表断言
			userAssert(1, 1, registerOrder.getMobile(), result.getUserId(), registerOrder.getPartnerId(), birthday,
				registerOrder.getNickName(), registerOrder.getRealName(), registerOrder.getHeadImgUrl(),
				registerOrder.getSex().getCode(), registerOrder.getGrade().getCode(), rawAddTime, identifier,
				importSource);
			//		user_car_info表断言
			if (testId == 1007) {
				userCarInfoAssert(3, 1, result.getUserId(), carNo);
				userCarInfoAssert(3, 2, result.getUserId(), carNo2);
				userCarInfoAssert(3, 3, result.getUserId(), carNo3);
			}
			if (testId == 1006) {
				userCarInfoAssert(1, 1, result.getUserId(), carNo);
			}
			//		user_card_info表断言
			userCardInfoAssert(1, 1, result.getUserId(), registerOrder.getPartnerId(), accountNo, accountTag,
				accountNo);
			//		user_pay_tool_info表断言
			userPayToolInfoAssert(1, 1, registerOrder.getPartnerId(), registerOrder.getOpenId(), result.getUserId(),
				bindStatus, registerOrder.getType().code());
			//	神马付xyb_user数据库--------------------------------------------------------------------------------------
			//		神马付user表断言(激活业务，即便传入支付密码也会设置）
			xybUserByPartnerIdAndMobileAssert(registerOrder.getPartnerId(), registerOrder.getMobile(), 1, 1,
				result.getUserId(), payPassword, registerOrder.getRealName());
			//		神马付account表断言
			accountByUserIdAssert(result.getUserId(), 1, 1, null, registerOrder.getPartnerId(), accountNo, accountTag);
			
			//	shell_marketpc数据库-------------------------------------------------------------------------------------
			
			//	silverbolt数据库-----------------------------------------------------------------------------------------
		}
		
		if (testId == 1008) {
			assertEquals(userId, result.getUserId());
			//	shell_user数据库-----------------------------------------------------------------------------------------
			//	 	user表断言
			userAssert(1, 1, registerOrder.getMobile(), result.getUserId(), registerOrder.getPartnerId(), birthday,
				registerOrder.getNickName(), realName, registerOrder.getHeadImgUrl(), sex,
				registerOrder.getGrade().getCode(), rawAddTime, identifier, importSource);
			//		user_car_info表断言
			userCarInfoAssert(0, 1, null, null);
			//		user_card_info表断言
			userCardInfoAssert(1, 1, result.getUserId(), registerOrder.getPartnerId(), accountNo, accountTag,
				accountNo);
			//		user_pay_tool_info表断言
			userPayToolInfoAssert(1, 1, registerOrder.getPartnerId(), registerOrder.getOpenId(), result.getUserId(),
				bindStatus, registerOrder.getType().code());
			//	神马付xyb_user数据库--------------------------------------------------------------------------------------
			//		神马付user表断言(激活业务，即便传入支付密码也会设置）
			xybUserByPartnerIdAndMobileAssert(registerOrder.getPartnerId(), registerOrder.getMobile(), 1, 1,
				result.getUserId(), payPassword, realName);
			//		神马付account表断言
			accountByUserIdAssert(result.getUserId(), 1, 1, null, registerOrder.getPartnerId(), accountNo, accountTag);
			
			//	shell_marketpc数据库-------------------------------------------------------------------------------------
			
			//	silverbolt数据库-----------------------------------------------------------------------------------------
		}
		//	TODO	notify_task表断言(发送给MQ失败会保留数据，不管营销和分析是否接收），后续需打开校验
		//		try {
		//			Thread.sleep(200);
		//			notifyTaskAssert(0, 0, registerOrder.getGid(), null, null, null, null, null);
		//		}catch (Exception e){
		//			e.toString();
		//		}
		// 清除数据
	}
	
	/**
	 * 1001、mobile设置为null,预期提示mobile不能为空. 1002、partnerId设置为null,预期提示partnerId不能为空
	 * 1003、type设置为null,预期提示type不能为空 1004、registerOrder设置为null,预期提示registerOrder不能为空
	 * 1005、ImportSource设置为非指定集合(default","huiTaoTakeTicket)中的字符串,预期提示ImportSource输入非法的类似表达
	 * 1006、carNumber设置为4个车牌号,预期提示carNumber个数不能超过3个类似表达
	 * 1008、mobile设置为12个数字,预期提示mobile手机号格式不对的表达
	 * 1009、mobile设置为10个数字,预期提示mobile手机号格式不对的表达
	 * 1010、realName设置为65个字符，预期提示realName不能超过64个字符
	 * 1011、nickName设置为61个字符，预期提示realName不能超过60个字符
	 * 1012、headImgUrl设置为257个字符，预期提示realName不能超过256个字符
	 */
	@AutoTest(file = "shelluser/userServiceRegisterTestFailOne.csv")
	@DisplayName("自主注册/激活--参数检查用例")
	public void userServiceRegisterTestFailOne(// 基本参数
												int testId, Status status, String code, String message,
												String description,
												// 业务参数
												RegisterOrder registerOrder, String carNo, String carNo2, String carNo3,
												String carNo4,
												//校验参数
												Sex sex2, String grade2, String importSource2, String identifier,
												String accountTag, String bindStatus) {
		// 清除数据
		shellUserTestBase.cleanUser();
		shellUserTestBase.cleanUserCarInfo();
		shellUserTestBase.cleanUserCardInfo();
		shellUserTestBase.cleanUserPayToolInfo();
		shellUserTestBase.cleanUserInviteLog();
		shellUserTestBase.cleanNotifyTask();
		userTestBase.cleanUserByMobile(registerOrder.getMobile());
		// 准备数据
		//		准备商户信息
		Map<String, Object> param = shellInitDataBase.initPartnerUser();
		// 测试过程
		registerOrder.setPartnerId(param.get("partnerId").toString());
		List<String> carNumber = new ArrayList<String>();
		if (testId == 1001) {
			registerOrder.setMobile(null);
		}
		if (testId == 1002) {
			registerOrder.setPartnerId(null);
		}
		if (testId == 1003) {
			registerOrder.setType(null);
		}
		if (testId == 1005) {
			registerOrder.setImportSource("随便输入");
		}
		if (testId == 1006) {
			carNumber.add(carNo);
			carNumber.add(carNo2);
			carNumber.add(carNo3);
			carNumber.add(carNo4);
		}
		registerOrder.setCarNumber(carNumber);
		if (testId == 1004) {
			registerOrder = null;
		}
		// 调用接口
		RegisterUserResult result = userService.register(registerOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertEquals(message, result.getMessage());
		assertEquals(description, result.getDescription());
		assertNull(result.getUserId());
		// 数据验证
		//	xyb_user数据库
		//	 	user表断言
		userAssert(0, 0, null, null, null, null, null, null, null, null, null, null, null, null);
		//		user_car_info表断言
		userCarInfoAssert(0, 0, null, null);
		//		user_card_info表断言
		userCardInfoAssert(0, 0, null, null, null, null, null);
		//		user_pay_tool_info表断言
		userPayToolInfoAssert(0, 0, null, null, null, null, null);
	}
	
	//TODO 微信号已绑定用户与用户已绑定微信号不一样.........................................................
	//TODO 重复注册（暂时抹去不校验，重复注册一般没有会员微信绑定关系信息，从pos发起）
	//     对于此场景，在该注册与激活复用的接口，不存在（因为已存在再调用就是激活），如果以后该接口拆分就存在该情况。
	/**
	 * 1001、商户不存在 1002、商户状态被冻结，不可以继续业务。 1003、短信验证码不正确。
	 * 1004、短信验证码验证次数已失效（输错3次，再输对一次，测试设计为3次）。1005、短信验证码时间已失效（测试设计为10秒）
	 *
	 * 注册场景：-----------------------------------------------------------------------------------------------------
	 * 1007、该OPENID的微信号已经被其它会员绑定了。 1008、注册时车辆车牌号列表中有重复车牌号。1009、注册时车牌号格式不对。
	 *
	 * 激活场景：-------------------激活场景一般没有与微信绑定关系数据--------------------------------------------------------
	 * 1010、该会员已经绑定其它的OPENID微信号。1011、更新添加车辆车牌号列表中有重复车牌号。1012、更新时车牌号格式不对。
	 */
	@AutoTest(file = "shelluser/userServiceRegisterTestFailTwo.csv")
	@DisplayName("自主注册/激活--业务失败用例")
	public void userServiceRegisterTestFailTwo(// 基本参数
												int testId, Status status, String code, String message,
												String description,
												// 业务参数
												RegisterOrder registerOrder, String carNo, String carNo2, String carNo3,
												//校验参数
												String identifier, String accountTag, String bindStatus) {
		// 清除数据
		shellUserTestBase.cleanUser();
		shellUserTestBase.cleanUserCarInfo();
		shellUserTestBase.cleanUserCardInfo();
		shellUserTestBase.cleanUserPayToolInfo();
		shellUserTestBase.cleanUserInviteLog();
		shellUserTestBase.cleanNotifyTask();
		userTestBase.cleanUserByMobile(registerOrder.getMobile());
		shellmerchantTestBase.cleanGasMerchantByPartnerId(registerOrder.getPartnerId());
		// 准备数据
		//		定义获取初始化数据变量
		String partnerId = null;
		String openId = null;
		String userId = null;
		String importSource = null;
		Date rawAddTime = DateUtil.now();
		Date birthday = DateUtil.now();
		String payPassword = null;
		String sex = null;
		String realName = null;
		String accountNo = null;
		String carNo5 = null;
		String nickName = null;
		String grade = null;
		String headImgUrl = null;
		String mobile = null;
		//		准备商户信息
		Map<String, Object> param = new HashMap<String, Object>();
		if (testId != 1001) {
			param = shellInitDataBase.initPartnerUser();
			partnerId = param.get("partnerId").toString();
		}
		//		设置商户状态为禁用状态
		if (testId == 1002) {
			GasMerchantDO gasMerchantDO = shellmerchantTestBase.findGasMerchantByPartnerId(partnerId).get(0);
			gasMerchantDO.setStatus("DISABLE");
			shellmerchantTestBase.updateGasMerchantByPartnerId(partnerId, gasMerchantDO);
		}
		//		准备已存在会员信息
		Map<String, Object> param2 = new HashMap<String, Object>();
		if (testId == 1007 || testId == 1010 || testId == 1011 || testId == 1012) {
			param2 = shellInitDataBase.initShellUser();
			openId = param2.get("openId").toString();
			userId = param2.get("userId").toString();
			importSource = param2.get("importSource").toString();
			rawAddTime = (Date) param2.get("rawAddTime");
			birthday = (Date) param2.get("birthday");
			payPassword = param2.get("payPassword").toString();
			sex = param2.get("sex").toString();
			realName = param2.get("realName").toString();
			accountNo = param2.get("accountNo").toString();
			carNo5 = param2.get("carNumber").toString();
			grade = param2.get("grade").toString();
			nickName = param2.get("nickName").toString();
			headImgUrl = param2.get("headImgUrl").toString();
			mobile = param2.get("mobile").toString();
		}
		if (testId == 1011 || testId == 1012) {
			//清除与微信绑定信息
			shellUserTestBase.cleanUserPayToolInfoByUserId(userId);
		}
		//		模拟插入短信验证码进入redis被被测对象读取
		if (testId == 1003) {
			//输入验证码和所发送验证码不一致设计
			shellInitDataBase.insertRedisVerificationCode(registerOrder.getPartnerId(), registerOrder.getMobile(),
				"5555");
		} else {
			shellInitDataBase.insertRedisVerificationCode(registerOrder.getPartnerId(), registerOrder.getMobile(),
				registerOrder.getSmsValidateCode());
		}
		// 测试过程
		//      装入一个不存在的商户
		if (testId != 1001) {
			registerOrder.setPartnerId(partnerId);
		}
		//		激活场景：装入被激活会员已存在的手机号和openId，覆盖读取CSV中的值
		if (testId == 1011 || testId == 1012) {
			registerOrder.setOpenId(openId);
		}
		//		重新赋值覆盖从csv的读取结果
		List<String> carNumber = new ArrayList<String>();
		carNumber.add(carNo);
		carNumber.add(carNo2);
		carNumber.add(carNo3);
		registerOrder.setCarNumber(carNumber);
		if (testId == 1004) {
			//先输入错的
			registerOrder.setSmsValidateCode("1111");
			userService.register(registerOrder);
			//先输入错的
			registerOrder.setSmsValidateCode("1111");
			userService.register(registerOrder);
			//先输入错的
			registerOrder.setSmsValidateCode("1111");
			userService.register(registerOrder);
			//再输正确的
			registerOrder.setSmsValidateCode("1234");
		}
		if (testId == 1005) {
			//让短信验证码过期
			try {
				Thread.sleep(11000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 调用接口
		RegisterUserResult result = userService.register(registerOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertEquals(message, result.getMessage());
		assertEquals(description, result.getDescription());
		assertNull(result.getUserId());
		// 数据验证
		if (testId == 1001 || testId == 1002 || testId == 1003 || testId == 1004 || testId == 1005 || testId == 1008
			|| testId == 1009) {
			//	xyb_user数据库
			//	 	user表断言
			userAssert(0, 0, null, null, null, null, null, null, null, null, null, null, null, null);
			//		user_car_info表断言
			userCarInfoAssert(0, 0, null, null);
			//		user_card_info表断言
			userCardInfoAssert(0, 0, null, null, null, null, null);
			//		user_pay_tool_info表断言
			userPayToolInfoAssert(0, 0, null, null, null, null, null);
		}
		//1007该手机号无法注册成功，但也不会影响其它老数据
		if (testId == 1007) {
			//  shell_user数据库
			//	 	user表断言(对于请求注册的mobile是不会注册成功会员的，只断言该表，偷个懒）
			assertEquals(0, shellUserTestBase.findUserByMobile(registerOrder.getMobile()).size());
			//   ---------------------------老数据校验---------------------------------------------
			//	 	user表断言
			userAssert(1, 1, mobile, userId, registerOrder.getPartnerId(), birthday, nickName, realName, headImgUrl,
				sex, grade, rawAddTime, identifier, importSource);
			//		user_car_info表断言
			userCarInfoAssert(1, 1, userId, carNo5);
			//		user_card_info表断言
			userCardInfoAssert(1, 1, userId, registerOrder.getPartnerId(), accountNo, accountTag, accountNo);
			//		user_pay_tool_info表断言
			userPayToolInfoAssert(1, 1, registerOrder.getPartnerId(), registerOrder.getOpenId(), userId, bindStatus,
				registerOrder.getType().code());
			//	神马付xyb_user数据库--------------------------------------------------------------------------------------
			//		神马付user表断言(激活业务，即便传入支付密码也会设置）
			xybUserByPartnerIdAndMobileAssert(registerOrder.getPartnerId(), mobile, 1, 1, userId, payPassword,
				realName);
			//		神马付account表断言
			accountByUserIdAssert(userId, 1, 1, null, registerOrder.getPartnerId(), accountNo, accountTag);
			
			//	shell_marketpc数据库-------------------------------------------------------------------------------------
			//	silverbolt数据库-----------------------------------------------------------------------------------------
		}
		
		if (testId == 1010) {
			//		user_pay_tool_info表断言
			assertEquals(0, shellUserTestBase.findUserPayToolInfoByOpenId(registerOrder.getOpenId()).size());
		}
		
		//老数据校验（预期保持不变）
		if (testId == 1010 || testId == 1011 || testId == 1012) {
			//	shell_user数据库-----------------------------------------------------------------------------------------
			//	 	user表断言
			userAssert(1, 1, registerOrder.getMobile(), userId, registerOrder.getPartnerId(), birthday, nickName,
				realName, headImgUrl, sex, grade, rawAddTime, identifier, importSource);
			//		user_car_info表断言
			userCarInfoAssert(1, 1, userId, carNo5);
			//		user_card_info表断言
			userCardInfoAssert(1, 1, userId, registerOrder.getPartnerId(), accountNo, accountTag, accountNo);
			//		user_pay_tool_info表断言
			if (testId == 1010) {
				userPayToolInfoAssert(1, 1, registerOrder.getPartnerId(), registerOrder.getOpenId(), userId, bindStatus,
					registerOrder.getType().code());
			} else {
				userPayToolInfoAssert(0, 1, registerOrder.getPartnerId(), registerOrder.getOpenId(), userId, bindStatus,
					registerOrder.getType().code());
			}
			//	神马付xyb_user数据库--------------------------------------------------------------------------------------
			//		神马付user表断言(激活业务，即便传入支付密码也会设置）
			xybUserByPartnerIdAndMobileAssert(registerOrder.getPartnerId(), registerOrder.getMobile(), 1, 1, userId,
				payPassword, realName);
			//		神马付account表断言
			accountByUserIdAssert(userId, 1, 1, null, registerOrder.getPartnerId(), accountNo, accountTag);
			
			//	shell_marketpc数据库-------------------------------------------------------------------------------------
			//	silverbolt数据库-----------------------------------------------------------------------------------------
		}
		
		// 清除数据
	}
	
	/**
	 * 查询断言user表数据
	 * @param total
	 * @param size
	 * @param mobile
	 * @param userId
	 * @param partnerId
	 * @param birthday
	 * @param nickName
	 * @param realName
	 * @param headImgUrl
	 * @param sex
	 * @param grade
	 * @param rawAddTime
	 * @param identifier
	 * @param importSource
	 */
	private void userAssert(int total, int size, String mobile, String userId, String partnerId, Date birthday,
							String nickName, String realName, String headImgUrl, String sex, String grade,
							Date rawAddTime, String identifier, String importSource) {
		List<UserDO> userDOS = shellUserTestBase.findUserAll();
		if (total <= 0) {
			assertEquals(total, userDOS.size());
			return;
		}
		assertEquals(total, userDOS.size());
		UserDO userDO = userDOS.get(size - 1);
		assertEquals(mobile, userDO.getMobile());
		assertEquals(userId, userDO.getUserId());
		assertEquals(partnerId, userDO.getPartnerId());
		//	截取生日固定的月日值
		if (null != birthday) {
			assertEquals(DateUtil.dtSimpleFormat(birthday), DateUtil.dtSimpleFormat(userDO.getBirthday()));
			assertEquals(DateUtil.dtSimpleFormat(birthday).substring(5), userDO.getShortBirthday());
		} else {
			assertEquals(null, userDO.getBirthday());
			assertEquals(null, userDO.getShortBirthday());
		}
		assertEquals(nickName, userDO.getNickName());
		assertEquals(realName, userDO.getRealName());
		assertEquals(headImgUrl, userDO.getHeadImgUrl());
		assertEquals(sex, userDO.getSex());
		assertEquals(grade, userDO.getGrade());
		assertEquals(identifier, userDO.getIdentifier());
		assertEquals(importSource, userDO.getImportSource());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userDO.getId());
		//	注册方式，由接口实现代码给定，其值来源于GeneralizeSource枚举（自主注册AUTONOMY_GENERALIZE，会员推广注册USER_GENERALIZE，员工推广注册STAFF_GENERALIZE）
		assertEquals("AUTONOMY_GENERALIZE", userDO.getRegisterFrom());
		//	证件号目前注册和更新的对象属性没有入口
		assertEquals(null, userDO.getCertNo());
		//	用户类型（普通和专车用户），但目前没有专车用户的业务入口，只存在普通用户
		assertEquals("NORMAL", userDO.getMemberType());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(rawAddTime), DateUtil.dtSimpleFormat(userDO.getRawAddTime()));
	}
	
	/**
	 * 断言user_card_info表数据
	 * @param total
	 * @param size
	 * @param userId
	 * @param partnerId
	 * @param cardNo
	 * @param accountTag
	 * @param accountNo
	 */
	private void userCardInfoAssert(int total, int size, String userId, String partnerId, String cardNo,
									String accountTag, String accountNo) {
		List<UserCardInfoDO> userCardInfoDOS = shellUserTestBase.findUserCardInfoAll();
		if (total <= 0) {
			assertEquals(total, userCardInfoDOS.size());
			return;
		}
		assertEquals(total, userCardInfoDOS.size());
		UserCardInfoDO userCardInfoDO = userCardInfoDOS.get(size - 1);
		assertEquals(userId, userCardInfoDO.getUserId());
		assertEquals(partnerId, userCardInfoDO.getPartnerId());
		assertEquals(cardNo, userCardInfoDO.getCardNo());
		//	神马付账户标签=壳牌系统特有的账户标识+卡类型(实体卡ENTITY和虚拟卡DUMMY）+卡支持的业务类型（默认业务和车队卡业务）
		assertEquals(accountTag, userCardInfoDO.getAccountTag());
		assertEquals(accountNo, userCardInfoDO.getAccountNo());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userCardInfoDO.getId());
		assertEquals(null, userCardInfoDO.getParentCardAccountNo());
		//	壳牌目前没有实体卡，所以没有实体卡内码,加好油存在
		assertEquals(null, userCardInfoDO.getInternalNo());
		//	卡的业务类型标识，默认业务（DEFAULT)和FLEET（车队卡业务）
		assertEquals("DUMMY", userCardInfoDO.getCardType());
		assertEquals("DEFAULT", userCardInfoDO.getTag());
		assertEquals("NORMAL", userCardInfoDO.getStatus());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userCardInfoDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userCardInfoDO.getRawAddTime()));
	}
	
	/**
	 * 断言user_car_info表数据
	 * @param total
	 * @param size
	 * @param userId
	 * @param carNumber
	 */
	private void userCarInfoAssert(int total, int size, String userId, String carNumber) {
		List<UserCarInfoDO> userCarInfoDOS = shellUserTestBase.findUserCarInfoAll();
		if (total <= 0) {
			assertEquals(total, userCarInfoDOS.size());
			return;
		}
		assertEquals(total, userCarInfoDOS.size());
		UserCarInfoDO userCarInfoDO = userCarInfoDOS.get(size - 1);
		assertEquals(userId, userCarInfoDO.getUserId());
		assertEquals(carNumber, userCarInfoDO.getCarNumber());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userCarInfoDO.getId());
		//	目前专车相关没有业务入口，所以值为空
		assertEquals(null, userCarInfoDO.getCarType());
		assertEquals(null, userCarInfoDO.getAuthenticateImg());
		assertEquals(null, userCarInfoDO.getAuditStatus());
		assertEquals(null, userCarInfoDO.getApplyDate());
		assertEquals(null, userCarInfoDO.getAuditDate());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userCarInfoDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userCarInfoDO.getRawAddTime()));
	}
	
	/**
	 * 根据PartnerId和OpenId查询断言user_pay_tool_info表
	 * @param partnerId
	 * @param openId
	 * @param total
	 * @param size
	 * @param userId
	 * @param bindStatus
	 * @param type
	 */
	private void userPayToolInfoAssert(	int total, int size, String partnerId, String openId, String userId,
										String bindStatus, String type) {
		List<UserPayToolInfoDO> userPayToolInfoDOS = shellUserTestBase.findUserPayToolInfoAll();
		if (total <= 0) {
			assertEquals(total, userPayToolInfoDOS.size());
			return;
		}
		assertEquals(total, userPayToolInfoDOS.size());
		UserPayToolInfoDO userPayToolInfoDO = userPayToolInfoDOS.get(size - 1);
		assertEquals(userId, userPayToolInfoDO.getUserId());
		assertEquals(bindStatus, userPayToolInfoDO.getBindStatus());
		assertEquals(type, userPayToolInfoDO.getType());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userPayToolInfoDO.getId());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userPayToolInfoDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userPayToolInfoDO.getRawAddTime()));
	}
	
	/**
	 * 根据userInviteId查询断言user_invite_log表
	 *
	 * @param userInviteId
	 * @param total
	 * @param size
	 * @param userId
	 * @param partnerId
	 * @param nickName
	 * @param userInviteName
	 * @param userInviteMobile
	 */
	private void userInviteLogByUserInviteIdAssert(	String userInviteId, int total, int size, String userId,
													String partnerId, String nickName, String userInviteName,
													String userInviteMobile) {
		List<UserInviteLogDO> userInviteLogDOS = shellUserTestBase.findUserInviteLogByUserInviteId(userInviteId);
		if (total <= 0) {
			assertEquals(total, userInviteLogDOS.size());
			return;
		}
		assertEquals(total, userInviteLogDOS.size());
		UserInviteLogDO userInviteLogDO = userInviteLogDOS.get(size - 1);
		assertEquals(userId, userInviteLogDO.getUserId());
		assertEquals(nickName, userInviteLogDO.getNickName());
		assertEquals(partnerId, userInviteLogDO.getPartnerId());
		assertEquals(userInviteMobile, userInviteLogDO.getUserInviteMobile());
		assertEquals(userInviteName, userInviteLogDO.getUserInviteName());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userInviteLogDO.getId());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userInviteLogDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userInviteLogDO.getRawAddTime()));
	}
	
	/**
	 * 断言notify_task表
	 * @param total
	 * @param size
	 * @param gid
	 * @param notifyType
	 * @param retryCount
	 * @param maxRetryCount
	 * @param status
	 * @param detail
	 */
	private void notifyTaskAssert(	int total, int size, String gid, String notifyType, Integer retryCount,
									Integer maxRetryCount, String status, String detail) {
		List<NotifyTaskDO> notifyTaskDOS = shellUserTestBase.findNotifyTaskAll();
		if (total <= 0) {
			assertEquals(total, notifyTaskDOS.size());
			return;
		}
		assertEquals(total, notifyTaskDOS.size());
		NotifyTaskDO notifyTaskDO = notifyTaskDOS.get(size - 1);
		assertEquals(gid, notifyTaskDO.getGid());
		assertEquals(notifyType, notifyTaskDO.getNotifyType());
		assertEquals(retryCount, notifyTaskDO.getRetryCount());
		assertEquals(maxRetryCount, notifyTaskDO.getMaxRetryCount());
		assertEquals(status, notifyTaskDO.getStatus());
		assertEquals(detail, notifyTaskDO.getDetail());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(notifyTaskDO.getId());
		assertNotNull(notifyTaskDO.getIdentity());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(notifyTaskDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(notifyTaskDO.getRawAddTime()));
	}
	
	/**
	 * 根据partnerId和mobile查询断言xyb-user表
	 * @param partnerId
	 * @param mobile
	 * @param total
	 * @param size
	 * @param userId
	 * @param payPassword
	 * @param realName
	 */
	private void xybUserByPartnerIdAndMobileAssert(	String partnerId, String mobile, int total, int size, String userId,
													String payPassword, String realName) {
		List<dal.model.user.UserDO> userDOS = userTestBase.findUserByPartnerIdAndMobile(partnerId, mobile);
		if (total <= 0) {
			assertEquals(total, userDOS.size());
			return;
		}
		assertEquals(total, userDOS.size());
		dal.model.user.UserDO userDO = userDOS.get(size - 1);
		//		支付密码通过userId加盐过程处理
		if (payPassword != null) {
			assertEquals(payPasswordMD5(userId, payPassword), userDO.getPayPassword());
		} else {
			assertEquals(payPassword, userDO.getPayPassword());
		}
		assertEquals(partnerId, userDO.getPartnerId());
		//	壳牌的partnerId与parentUserId是同一个，都在壳牌的会员系统properties中指定
		assertEquals(partnerId, userDO.getParentUserId());
		assertEquals(realName, userDO.getRealName());
		assertEquals(mobile, userDO.getMobile());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userDO.getId());
		//目前油品系统未使用该属性，如果要传入，当与业务的nickName
		assertEquals(null, userDO.getUserName());
		//该状态是根据父级会员的状态而定，神马付注册接口未让调用方传入
		assertEquals("NORMAL", userDO.getUserStatus());
		//只要是注册商户的会员，都是个人的，除非新增商户，并在后台BOSS开立为平台商（PLATFORM）/签约商（PARTNER）。
		assertEquals("PERSONAL", userDO.getUserType());
		//欣业邦内部产品注册都属于站内，只有外部商户独立对接神马付才是外部引入OUTSIDE_INTO
		assertEquals("INSIDE", userDO.getRegisterFrom());
		//商户业务系统的会员ID，目前基本没有其它外部商户使用神马付，故没值；欣业邦内部的壳牌和加好油的会员ID与神马付生成的userId一致，故也没值。
		assertEquals(null, userDO.getMerchantUserId());
		//加好油、壳牌、房产这样的平台标识。目前上游系统（油品）并没有用此设计,神马付会员系统在（api1.0.5)版本之后才有该属性，数据为空。
		assertEquals(null, userDO.getPlatPartnerId());
		assertEquals(null, userDO.getCertifyStatus());
		assertEquals(null, userDO.getCertType());
		assertEquals(null, userDO.getCertNo());
		assertEquals(null, userDO.getRegisterIp());
		assertEquals(null, userDO.getCountry());
		assertEquals(null, userDO.getProvince());
		assertEquals(null, userDO.getCity());
		assertEquals(null, userDO.getDistrict());
		assertEquals(null, userDO.getAddress());
		assertEquals(null, userDO.getPhone());
		assertEquals(null, userDO.getZipCode());
		assertEquals(null, userDO.getMemo());
		assertEquals(null, userDO.getCustomerId());
		//该字段原设计用于区别商户的结算模式：普通模式（渠道直接结算给商户），电商管家模式（由神马付向电商管家发起清分结算），不过目前该配置项存放在路由，该配置已弃用。
		assertEquals("NORMAL", userDO.getMerchantMode());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawAddTime()));
	}
	
	/**
	 * 根据userId查询断言account表
	 * @param userId
	 * @param total
	 * @param size
	 * @param platPartnerId
	 * @param partnerId
	 * @param accountNo
	 * @param tag
	 */
	private void accountByUserIdAssert(	String userId, int total, int size, String platPartnerId, String partnerId,
										String accountNo, String tag) {
		List<AccountDO> accountDOS = userTestBase.findAccountByUserId(userId);
		if (total <= 0) {
			assertEquals(total, accountDOS.size());
			return;
		}
		assertEquals(total, accountDOS.size());
		AccountDO accountDO = accountDOS.get(size - 1);
		assertEquals(platPartnerId, accountDO.getPlatPartnerId());
		assertEquals(partnerId, accountDO.getPartnerId());
		assertEquals(accountNo, accountDO.getAccountNo());
		assertEquals(tag, accountDO.getTag());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(accountDO.getId());
		//当时为了支持加好油，但目前无法追述其设计意图
		assertEquals(null, accountDO.getBandAccountNo());
		assertEquals(0L, accountDO.getBalance());
		assertEquals(0L, accountDO.getFreezeBalance());
		assertEquals(0L, accountDO.getCreditAmount());
		assertEquals(0L, accountDO.getHisInAmount());
		assertEquals(0L, accountDO.getHisOutAmount());
		assertEquals("111", accountDO.getPayModel());
		assertEquals("NORMAL", accountDO.getAccountType());
		assertEquals("ACTIVE", accountDO.getStatus());
		assertEquals(null, accountDO.getMemo());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(accountDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(accountDO.getRawAddTime()));
	}

	private void gasUserByPartnerIdAndMobile(int total,int size,String userId,String partnerId,String mobile,Date birthday){
		List<GasUserDO> gasUserDOS=gasSilverboltTestBase.findGasUserAll();
		if(total<=0){
			assertEquals(total, gasUserDOS.size());
			return;
		}
		assertEquals(total, gasUserDOS.size());
		GasUserDO gasUserDO= gasUserDOS.get(size - 1);
		assertEquals(userId,gasUserDO.getUserId());
		assertEquals(partnerId,gasUserDO.getPartnerId());
		assertEquals(mobile,gasUserDO.getMobile());
		assertEquals(birthday,gasUserDO.getBirthday());
		assertEquals(birthday,gasUserDO.getShortBirthday());
		assertEquals(userId,gasUserDO.getNickName());
		assertEquals(userId,gasUserDO.getRealName());
		assertEquals(userId,gasUserDO.getCertNo());
		assertEquals(userId,gasUserDO.getAccountTag());
		assertEquals(userId,gasUserDO.getHeadImgUrl());
		assertEquals(userId,gasUserDO.getCarNumber());
		assertEquals(userId,gasUserDO.getCarType());
		assertEquals(userId,gasUserDO.getSex());
		assertEquals(userId,gasUserDO.getMemberType());
		assertEquals(userId,gasUserDO.getGrade());
		assertEquals(userId,gasUserDO.getRecommendSource());
		assertEquals(userId,gasUserDO.getRecommendId());
		assertEquals(userId,gasUserDO.getRecommendStationId());
		assertEquals(userId,gasUserDO.getRecommendStationCode());
		assertEquals(userId,gasUserDO.getRecommendStationName());
		assertEquals(userId,gasUserDO.getRecommendMobile());
		assertEquals(userId,gasUserDO.getRecommendName());
		assertEquals(userId,gasUserDO.getCreateTime());
		assertEquals(userId,gasUserDO.getUpdateTime());
		assertEquals(userId,gasUserDO.getRawAddTime());
		assertEquals(userId,gasUserDO.getRawUpdateTime());
	}



	/**
	 * 支付密码和用户ID加盐
	 * @param userId
	 * @param payPassword
	 * @return
	 */
	private String payPasswordMD5(String userId, String payPassword) {
		String payPasswordMD5 = null;
		if (userId != null && payPassword != null) {
			StringBuffer content = new StringBuffer();
			content.append(userId.substring(15, 20));
			content.append(payPassword);
			content.append(userId.substring(10, 14));
			payPasswordMD5 = DigestUtil.digestWithMD5(content.toString());
		}
		return payPasswordMD5;
		
	}

}
