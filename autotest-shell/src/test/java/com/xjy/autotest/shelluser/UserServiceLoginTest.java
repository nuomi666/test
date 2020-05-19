package com.xjy.autotest.shelluser;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.ShellInitDataBase;
import com.xjy.autotest.testbase.ShelluserTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.yc.shell.user.api.enums.UserGrade;
import com.xyb.yc.shell.user.api.result.info.SimpleUserInfo;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.yc.shell.user.api.UserService;
import com.xyb.yc.shell.user.api.order.UserLoginOrder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author miantiao Created on 2019/06/11.
 */
public class UserServiceLoginTest extends SpringBootTestBase {
	
	@Reference(version = DUBBO_VERSION_1)
	UserService userService;
	@Autowired
	ShelluserTestBase shellUserTestBase;
	@Autowired
	ShellInitDataBase shellInitDataBase;
	@Autowired
	UserTestBase userTestBase;

	
	/**
	 * 1001,登录成功
	 */
	@AutoTest(file = "shelluser/userServiceLoginTestSuccess.csv",project = "shelluser")
	@DisplayName("登录--成功用例")
	public void userServiceLoginTestSuccess(// 基本参数
											int testId, Status status, String code, String description, String message,
											// 业务参数
											UserLoginOrder userLoginOrder) {
		// 清除数据
		// 准备数据
		//		准备被更新会员信息
		Map<String, Object> param = new HashMap<String, Object>();
		param = shellInitDataBase.initShellUser();
		String partnerId = param.get("partnerId").toString();
		String openId = param.get("openId").toString();
		String userId = param.get("userId").toString();
		Date birthday = (Date) param.get("birthday");
		String sex = param.get("sex").toString();
		String realName = param.get("realName").toString();
		String grade=param.get("grade").toString();
		String headImgUrl=param.get("headImgUrl").toString();
		String mobile=param.get("mobile").toString();
		String nickName=param.get("nickName").toString();
		String registerFrom=param.get("registerFrom").toString();
		String memberType=param.get("memberType").toString();
		// 测试过程
		userLoginOrder.setOpenId(openId);
		userLoginOrder.setPartnerId(partnerId);
		// 调用接口
		BizResult<SimpleUserInfo>  result = userService.login(userLoginOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertEquals(description, result.getDescription());
		assertEquals(message, result.getMessage());
		// 数据验证
		//	校验result返回数据
		assertEquals(DateUtil.dtSimpleFormat(birthday),DateUtil.dtSimpleFormat(result.getInfo().getBirthday()));
		// 未设计返回
		assertEquals(null,result.getInfo().getCarNumber());
		assertEquals(null,result.getInfo().getCertNo());
		assertEquals(grade,result.getInfo().getGrade().code());
		assertEquals(headImgUrl,result.getInfo().getHeadImgUrl());
		assertEquals(memberType,result.getInfo().getMemberType().code());
		assertEquals(mobile,result.getInfo().getMobile());
		assertEquals(nickName,result.getInfo().getNickName());
		assertEquals(partnerId,result.getInfo().getPartnerId());
		assertEquals(realName,result.getInfo().getRealName());
		assertEquals(null,result.getInfo().getRecommendId());
		assertEquals(null,result.getInfo().getRecommendMobile());
		assertEquals(registerFrom,result.getInfo().getRegisterFrom().code());
		assertEquals(sex,result.getInfo().getSex().code());
		assertEquals(userId,result.getInfo().getUserId());
		// 清除数据
	}
	/**
	 * 1001,openId为null，预期提示openId不能空。
	 * 1002,partnerId为null，预期提示partnerId不能空。
	 * 1002,order为null，预期提示order不能空。
	 */
	@AutoTest(file = "shelluser/userServiceLoginTestFailOne.csv")
	@DisplayName("登录--参数检查用例")
	public void userServiceLoginTestFailOne(// 基本参数
											int testId, Status status, String code, String description, String message,
											// 业务参数
											UserLoginOrder userLoginOrder) {
		// 清除数据
		// 准备数据
		//		准备被更新会员信息
		Map<String, Object> param = new HashMap<String, Object>();
		param = shellInitDataBase.initShellUser();
		String partnerId = param.get("partnerId").toString();
		String openId = param.get("openId").toString();
		// 测试过程
		if(testId==1001) {
			userLoginOrder.setOpenId(null);
			userLoginOrder.setPartnerId(partnerId);
		}
		if(testId==1002) {
			userLoginOrder.setOpenId(openId);
			userLoginOrder.setPartnerId(null);
		}
		if(testId==1003) {
			userLoginOrder=null;
		}

		// 调用接口
		BizResult<SimpleUserInfo>  result = userService.login(userLoginOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertEquals(description, result.getDescription());
		assertEquals(message, result.getMessage());
		// 数据验证
		//	校验result返回数据
		assertEquals(null,result.getInfo());
		// 清除数据
	}
	/**
	 * 1001、用户不存在
	 * 1002、用户被冻结状态异常无法登录
	 * 1003、用户被注销状态异常无法登录
	 */
	@AutoTest(file = "shelluser/userServiceLoginTestFailTwo.csv")
	@DisplayName("登录--业务异常用例")
	public void userServiceLoginTestFailTwo(// 基本参数
											int testId, Status status, String code, String description, String message,
											// 业务参数
											UserLoginOrder userLoginOrder,String userStatus) {
		// 清除数据
		shellUserTestBase.cleanUserPayToolInfoByOpenId(userLoginOrder.getOpenId());
		// 准备数据
		//		准备会员信息
		Map<String, Object> param = new HashMap<String, Object>();
		if(testId==1002||testId==1003){
		param=shellInitDataBase.initShellUser();
		String userId=param.get("userId").toString();
		//     更新神马付会员表状态为冻结和注销
			UserDO userDO=userTestBase.findUserByUserId(userId).get(0);
			userDO.setUserStatus(userStatus);
			userTestBase.updateUserByUserId(userId,userDO);
		}
		// 测试过程
		// 调用接口
		BizResult<SimpleUserInfo>  result = userService.login(userLoginOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertEquals(description, result.getDescription());
		assertEquals(message, result.getMessage());
		// 数据验证
		//	校验result返回数据
		assertEquals(null,result.getInfo());
		// 清除数据
	}
}
