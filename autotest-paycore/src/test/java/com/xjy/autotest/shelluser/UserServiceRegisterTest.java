package com.xjy.autotest.shelluser;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.InitData.ShellInitDataBase;
import com.xjy.autotest.testbase.ShelluserTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
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
 * 2.传入短信验证码可以注册（会员自主注册），不传入也可以注册（BOSS后台导入）
 *
 * 【开发实现逻辑】：-----------------------------------------------------------------------------------------------------
 * 1.入参校验=>短信验证码验证=>手机号+商户号查询是否已注册=>不存在就注册，存在就更新。
 * 2.a.注册流程与逻辑：=>注册时检查商户是否存在和运行状态=>调用清结算创建账户=>持久化壳牌业务会员数据=>持久化车辆信息(可多辆但实际业务没有，车辆会判重）
 * =>调用神马付设置支付密码接口（目前调用的是更新接口不合理）=>如果是推荐注册，则会进入持久化壳牌推荐关系数据。
 * b.更新流程与逻辑：=>先格式化日期属性并更新壳牌会员信息-再更新会员车辆信息-最后更新神马付账户信息（真实名）。
 * 3.=>与微信绑定关系，前置条件是openid不为空（一个微信号只能绑定一个会员，一个会员只能被一个微信号绑定）（但是在极端情况下（幂等），会根据openid直接更新会员ID和状态）
 * =>创建“注册/更新”会员通知任务（分析通知任务和营销通知任务），存储在系统数据库表notify_task =>执行发送任务。
 * 神马付内部逻辑（检查partnerId是对应的会员否存在且会员状态正常=>创建会员和账号）
 *
 * 【服务设计问题】：------------------------------------------------------------------------------------------------------
 * 1.用户在注册/激活时不会填写多个车辆信息，至多单个，设计冗余。 。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
 * 2.注册和激活当分离。
 * 3.注册接口当根据不同注册来源分别队待，分BOSS后台EXCLE导入（不传入短信验证码）和用户自主注册接口（要传入短信验证码）。。。。。。。。。
 * 4.与微信绑定节点问题： 问a：目前把"用户已绑定过微信"与“微信号已绑定过用户”两种情况笼统校验一并处理，应当区分校验处理返回。
 * 问b：新增绑定关系为啥要更新不知道，请说出场景来。如果是为了防止幂等，那当处理返回当前绑定成功。
 * 问c：如需一个微信号只绑定一个会员，且一个会员绑定一个微信号，且防止极端并发情况，需把PartnerId+openid唯一索引修改为PartnerId+openid+状态，
 * 并增加索引userId+状态+类型的唯一索引。
 * 5.user表设计问题：register_from注释为注册来源，应该修改为注册方式。import_source该字段意义不大，可以合并至register_from字段去表达。
 *
 * 【涉及系统表名】：------------------------------------------------------------------------------------------------------
 * yc-shell-user系统：{user(会员基本信息)、user_car_info（车辆信息）、user_card_info（会员卡信息--神马付账号）、
 * user_pay_tool_info（微信/支付宝会员绑定）、user_invite_log（会员推荐信息）、notify_task（分析&营销通知信息）}
 * yc-shell-merchant系统：{gas_merchant(商户信息表)、gas_merchant_source_data（商户来源信息表）}
 * xyb-user系统：{user(会员信息)、account（账户信息）}
 *
 * 【用例整体设计】：------------------------------------------------------------------------------------------------------
 * 1.整体用例的预置数据商户信息采用初始化数据插入（初始数据放在代码中）。
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

/**
 * 注册业务：------------------------------------------------------------------------------------------------------------
 * 1001、所有必填项注册（mobile、partnerId、type、importSource）
 * 1002、
 *
 *
 * 激活：
 */
@AutoTest(file = "shelluser/userServiceRegisterTestSuccess.csv",project = "shelluser")
@DisplayName("--成功用例")
public void userServiceRegisterTestSuccess(// 基本参数
											int testId, Status status, String code,
											// 业务参数
											RegisterOrder registerOrder, String carNo, String carNo2) {
	// 清除数据
//	shellUserTestBase.cleanUserByMobile(registerOrder.getMobile());
	//		shellUserTestBase.cleanUserCarInfoByCarNumber(carNo);
	//		shellUserTestBase.cleanUserCarInfoByCarNumber(carNo2);
//	shellUserTestBase.cleanUserCardInfoByPartnerId(registerOrder.getPartnerId());
//	shellUserTestBase.cleanUserPayToolInfoByPartnerId(registerOrder.getPartnerId());
	//		shellUserTestBase.cleanUserPayToolInfoByOpenId(registerOrder.getOpenId());
//	shellUserTestBase.cleanUserInviteLogByPartnerId(registerOrder.getPartnerId());
//	shellUserTestBase.cleanNotifyTaskByGid(registerOrder.getGid());
	// 准备数据
	//模拟插入短信验证码进入redis被被测对象读取
	//		shellInitDataBase.insertRedisVerificationCode(registerOrder.getPartnerId(), registerOrder.getMobile(), registerOrder.getSmsValidateCode());
	shellInitDataBase.initPartnerUser();
	// 测试过程
	List<String> carNumber = new ArrayList<String>();
	carNumber.add(carNo);
	carNumber.add(carNo2);
	//		registerOrder.setCarNumber(carNumber);
	// 调用接口
	RegisterUserResult result = userService.register(registerOrder);
	// 结果验证
	print(result);
	assertEquals(status, result.getStatus());
	assertEquals(code, result.getCode());
	// 数据验证
	userByMobileAssert(registerOrder.getMobile(), 1, 1, result.getUserId(), registerOrder.getPartnerId(), registerOrder.getBirthday(),
		registerOrder.getNickName(), registerOrder.getRealName(), registerOrder.getHeadImgUrl(), registerOrder.getSex().getCode(), "NORMAL",
		"AUTONOMY_GENERALIZE", registerOrder.getGrade().getCode(), null, null, "false", "default");

	// 清除数据
}

/**
 * 根据mobile查询断言user表数据
 *
 * @param mobile
 * @param total
 * @param size
 * @param userId
 * @param partnerId
 * @param birthday
 * @param nickName
 * @param realName
 * @param headImgUrl
 * @param sex
 * @param memberType
 * @param registerFrom
 * @param grade
 * @param rawAddTime
 * @param certNo
 * @param identifier
 * @param importSource
 */
private void userByMobileAssert(String mobile, int total, int size, String userId, String partnerId, Date birthday, String nickName, String realName,
								String headImgUrl, String sex, String memberType, String registerFrom, String grade, Date rawAddTime, String certNo,
								String identifier, String importSource) {
	List<UserDO> userDOS = shellUserTestBase.findUserByMobile(mobile);
	assertEquals(total, userDOS.size());
	UserDO userDO = userDOS.get(size - 1);
	assertEquals(userId, userDO.getUserId());
	assertEquals(partnerId, userDO.getPartnerId());
	assertEquals(birthday, userDO.getBirthday());
	assertEquals(DateUtil.dtSimpleFormat(birthday).substring(5), userDO.getShortBirthday());
	assertEquals(nickName, userDO.getNickName());
	assertEquals(realName, userDO.getRealName());
	assertEquals(headImgUrl, userDO.getHeadImgUrl());
	assertEquals(sex, userDO.getSex());
	assertEquals(memberType, userDO.getMemberType());
	assertEquals(grade, userDO.getRegisterFrom());
	assertEquals(userId, userDO.getGrade());
	assertEquals(certNo, userDO.getCertNo());
	assertEquals(identifier, userDO.getIdentifier());
	assertEquals(importSource, userDO.getImportSource());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(userDO.getId());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawUpdateTime()));
	if (rawAddTime == null) {
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawAddTime()));
	} else {
		assertEquals(rawAddTime, userDO.getRawAddTime());
	}
}

/**
 * 根据partnerId查询断言user_card_info表数据
 *
 * @param partnerId
 * @param total
 * @param size
 * @param userId
 * @param cardNo
 * @param internalNo
 * @param parentCardAccountNo
 * @param cardType
 * @param tag
 * @param accountTag
 * @param accountNo
 * @param status
 */
private void userCardInfoByPartnerIdAssert(	String partnerId, int total, int size, String userId, String cardNo, String internalNo,
											String parentCardAccountNo, String cardType, String tag, String accountTag, String accountNo,
											String status) {
	List<UserCardInfoDO> userCardInfoDOS = shellUserTestBase.findUserCardInfoByPartnerId(partnerId);
	assertEquals(total, userCardInfoDOS.size());
	UserCardInfoDO userCardInfoDO = userCardInfoDOS.get(size - 1);
	assertEquals(userId, userCardInfoDO.getUserId());
	assertEquals(cardNo, userCardInfoDO.getCardNo());
	assertEquals(internalNo, userCardInfoDO.getInternalNo());
	assertEquals(parentCardAccountNo, userCardInfoDO.getParentCardAccountNo());
	assertEquals(cardType, userCardInfoDO.getCardType());
	assertEquals(tag, userCardInfoDO.getTag());
	assertEquals(accountTag, userCardInfoDO.getAccountTag());
	assertEquals(accountNo, userCardInfoDO.getAccountNo());
	assertEquals(status, userCardInfoDO.getStatus());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(userCardInfoDO.getId());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userCardInfoDO.getRawUpdateTime()));
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userCardInfoDO.getRawAddTime()));
}

/**
 * 根据carNumber查询断言user_car_info表数据
 *
 * @param carNumber
 * @param total
 * @param size
 * @param userId
 * @param carType
 * @param authenticateImg
 * @param auditStatus
 * @param applyDate
 * @param auditDate
 */
private void userCarInfoByCarNumberAssert(	String carNumber, int total, int size, String userId, String carType, String authenticateImg,
											String auditStatus, Date applyDate, Date auditDate) {
	List<UserCarInfoDO> userCarInfoDOS = shellUserTestBase.findUserCarInfoByCarNumber(carNumber);
	assertEquals(total, userCarInfoDOS.size());
	UserCarInfoDO userCarInfoDO = userCarInfoDOS.get(size - 1);
	assertEquals(userId, userCarInfoDO.getUserId());
	assertEquals(carType, userCarInfoDO.getCarType());
	assertEquals(authenticateImg, userCarInfoDO.getAuthenticateImg());
	assertEquals(auditStatus, userCarInfoDO.getAuditStatus());
	assertEquals(applyDate, userCarInfoDO.getApplyDate());
	assertEquals(auditDate, userCarInfoDO.getAuditDate());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(userCarInfoDO.getId());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userCarInfoDO.getRawUpdateTime()));
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userCarInfoDO.getRawAddTime()));
}

/**
 * 根据PartnerId和OpenId查询断言user_pay_tool_info表
 *
 * @param partnerId
 * @param openId
 * @param total
 * @param size
 * @param userId
 * @param bindStatus
 * @param type
 */
private void userPayToolInfoByPartnerIdAndOpenIdAssert(	String partnerId, String openId, int total, int size, String userId, String bindStatus,
														String type) {
	List<UserPayToolInfoDO> userPayToolInfoDOS = shellUserTestBase.findUserPayToolInfoByPartnerId(partnerId);
	assertEquals(total, userPayToolInfoDOS.size());
	UserPayToolInfoDO userPayToolInfoDO = userPayToolInfoDOS.get(size - 1);
	assertEquals(userId, userPayToolInfoDO.getUserId());
	assertEquals(bindStatus, userPayToolInfoDO.getBindStatus());
	assertEquals(type, userPayToolInfoDO.getType());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(userPayToolInfoDO.getId());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userPayToolInfoDO.getRawUpdateTime()));
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userPayToolInfoDO.getRawAddTime()));
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
private void userInviteLogByUserInviteIdAssert(	String userInviteId, int total, int size, String userId, String partnerId, String nickName,
												String userInviteName, String userInviteMobile) {
	List<UserInviteLogDO> userInviteLogDOS = shellUserTestBase.findUserInviteLogByUserInviteId(userInviteId);
	assertEquals(total, userInviteLogDOS.size());
	UserInviteLogDO userInviteLogDO = userInviteLogDOS.get(size - 1);
	assertEquals(userId, userInviteLogDO.getUserId());
	assertEquals(nickName, userInviteLogDO.getNickName());
	assertEquals(partnerId, userInviteLogDO.getPartnerId());
	assertEquals(userInviteMobile, userInviteLogDO.getUserInviteMobile());
	assertEquals(userInviteName, userInviteLogDO.getUserInviteName());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(userInviteLogDO.getId());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userInviteLogDO.getRawUpdateTime()));
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userInviteLogDO.getRawAddTime()));
}

/**
 * 根据gid 查询断言notify_task表
 *
 * @param gid
 * @param total
 * @param size
 * @param notifyType
 * @param retryCount
 * @param maxRetryCount
 * @param status
 * @param detail
 */
private void notifyTaskByGid(	String gid, int total, int size, String notifyType, Integer retryCount, Integer maxRetryCount, String status,
								String detail) {
	List<NotifyTaskDO> notifyTaskDOS = shellUserTestBase.findNotifyTaskByGid(gid);
	assertEquals(total, notifyTaskDOS.size());
	NotifyTaskDO notifyTaskDO = notifyTaskDOS.get(size - 1);
	assertEquals(notifyType, notifyTaskDO.getNotifyType());
	assertEquals(retryCount, notifyTaskDO.getRetryCount());
	assertEquals(maxRetryCount, notifyTaskDO.getMaxRetryCount());
	assertEquals(status, notifyTaskDO.getStatus());
	assertEquals(detail, notifyTaskDO.getDetail());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(notifyTaskDO.getId());
	assertNotNull(notifyTaskDO.getIdentity());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(notifyTaskDO.getRawUpdateTime()));
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(notifyTaskDO.getRawAddTime()));
}

/**
 * 根据userId查询断言xyb-user表
 *
 * @param userid
 * @param total
 * @param size
 * @param merchantUserId
 * @param parentUserId
 * @param platPartnerId
 * @param userName
 * @param payPassword
 * @param registerFrom
 * @param userType
 * @param userStatus
 * @param certifyStatus
 * @param realName
 * @param certType
 * @param certNo
 * @param registerIp
 * @param country
 * @param province
 * @param city
 * @param district
 * @param address
 * @param phone
 * @param mobile
 * @param zipCode
 * @param memo
 * @param customerId
 * @param partnerId
 * @param merchantMode
 */
private void xybUserByUserIdAssert(	String userid, int total, int size, String merchantUserId, String parentUserId, String platPartnerId,
									String userName, String payPassword, String registerFrom, String userType, String userStatus,
									String certifyStatus, String realName, String certType, String certNo, String registerIp, String country,
									String province, String city, String district, String address, String phone, String mobile, String zipCode,
									String memo, String customerId, String partnerId, String merchantMode) {
	List<dal.model.user.UserDO> userDOS = userTestBase.findUserByUserId(userid);
	assertEquals(total, userDOS.size());
	dal.model.user.UserDO userDO = userDOS.get(size - 1);
	assertEquals(merchantUserId, userDO.getMerchantUserId());
	assertEquals(parentUserId, userDO.getParentUserId());
	assertEquals(platPartnerId, userDO.getPlatPartnerId());
	assertEquals(userName, userDO.getUserName());
	assertEquals(payPassword, userDO.getPayPassword());
	assertEquals(registerFrom, userDO.getRegisterFrom());
	assertEquals(userType, userDO.getUserType());
	assertEquals(userStatus, userDO.getUserStatus());
	assertEquals(certifyStatus, userDO.getCertifyStatus());
	assertEquals(realName, userDO.getRealName());
	assertEquals(certType, userDO.getCertType());
	assertEquals(certNo, userDO.getCertNo());
	assertEquals(registerIp, userDO.getRegisterIp());
	assertEquals(country, userDO.getCountry());
	assertEquals(province, userDO.getProvince());
	assertEquals(city, userDO.getCity());
	assertEquals(district, userDO.getDistrict());
	assertEquals(address, userDO.getAddress());
	assertEquals(phone, userDO.getPhone());
	assertEquals(mobile, userDO.getMobile());
	assertEquals(zipCode, userDO.getZipCode());
	assertEquals(memo, userDO.getMemo());
	assertEquals(customerId, userDO.getCustomerId());
	assertEquals(partnerId, userDO.getPartnerId());
	assertEquals(merchantMode, userDO.getMerchantMode());
	//基本不会有业务场景变化所以直接校验
	assertNotNull(userDO.getId());
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawUpdateTime()));
	assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawAddTime()));
}

/**
 * 根据userId和Tag查询断言account表
 *
 * @param userId
 * @param tag
 * @param total
 * @param size
 * @param platPartnerId
 * @param partnerId
 * @param accountNo
 * @param bandAccountNo
 * @param balance
 * @param freezeBalance
 * @param creditAmount
 * @param hisInAmount
 * @param hisOutAmount
 * @param status
 * @param accountType
 * @param payModel
 * @param memo
 */
private void accountByUserIdAndTagAssert(	String userId, String tag, int total, int size, String platPartnerId, String partnerId, String accountNo,
											String bandAccountNo, long balance, long freezeBalance, long creditAmount, long hisInAmount,
											long hisOutAmount, String status, String accountType, String payModel, String memo) {
	// List<AccountDO> accountDOS = userTestBase.findAccountByUserIdAndTag(userId, tag);
	// assertEquals(total, accountDOS.size());
	// AccountDO accountDO = accountDOS.get(size - 1);
	// assertEquals(platPartnerId, accountDO.getPlatPartnerId());
	// assertEquals(partnerId, accountDO.getPartnerId());
	// assertEquals(accountNo, accountDO.getAccountNo());
	// assertEquals(bandAccountNo, accountDO.getBandAccountNo());
	// assertEquals(balance, accountDO.getBalance());
	// assertEquals(freezeBalance, accountDO.getFreezeBalance());
	// assertEquals(creditAmount, accountDO.getCreditAmount());
	// assertEquals(hisInAmount, accountDO.getHisInAmount());
	// assertEquals(hisOutAmount, accountDO.getHisOutAmount());
	// assertEquals(status, accountDO.getStatus());
	// assertEquals(accountType, accountDO.getAccountType());
	// assertEquals(payModel, accountDO.getPayModel());
	// assertEquals(memo, accountDO.getMemo());
	// //基本不会有业务场景变化所以直接校验
	// assertNotNull(accountDO.getId());
	// assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(accountDO.getRawUpdateTime()));
	// assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(accountDO.getRawAddTime()));
}
}
