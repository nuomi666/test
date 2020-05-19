//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.security.DigestUtil;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.ValidatePayPwdOrder;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceValidatePayPwdTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserService userService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceValidatePayPwdTestSuccess.csv")
//	@DisplayName("校验支付密码--成功用例")
//	public void userServiceValidatePayPwdTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			ValidatePayPwdOrder order,
//			// 数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserDO userDO,
//			// 结果参数
//			String code,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		// 准备数据
//		StringBuffer content = new StringBuffer();
//		content.append(order.getUserId().substring(15, 20));
//		content.append(order.getPayPwd());
//		content.append(order.getUserId().substring(10, 14));
//		String payPasswordEnum = DigestUtil.digestWithMD5(content.toString());
//		userDO.setPayPassword(payPasswordEnum);
//		userTestBase.insertUser(userDO);
//		gasUserTestBase.insertUser(jhyUserDO);
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.validatePayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS,code,result);
//		assertEquals(description,result.getDescription());
//		// 数据验证
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceValidatePayPwdTestFailOne.csv")
//	@DisplayName("校验支付密码--参数非法")
//	public void userServiceValidatePayPwdTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			ValidatePayPwdOrder order,
//			// 结果参数
//			String code,
//			String description
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId == 1001){
//			order = null;
//		}
//		if(testId == 1002){
//			order.setGid(null);
//		}
//		if (testId == 1003) {
//			order.setUserId(null);
//		}
//		if(testId == 1004){
//			order.setPayPwd(null);
//		}
//		// 调用接口
//		SimpleResult result = userService.validatePayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL,code,result);
//		assertEquals(description,result.getMessage());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceValidatePayPwdTestFailTwo.csv")
//	@DisplayName("校验支付密码--失败用例")
//	public void userServiceValidatePayPwdTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			ValidatePayPwdOrder order,
//			// 数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserDO userDO,
//			// 结果参数
//			String code,
//			String description
//	) {
//		// 清除数据
//			userTestBase.cleanUserByUserId(userDO.getUserId());
//			gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		// 准备数据
//		StringBuffer content = new StringBuffer();
//		content.append(order.getUserId().substring(15, 20));
//		content.append(order.getPayPwd());
//		content.append(order.getUserId().substring(10, 14));
//		String payPasswordEnum = DigestUtil.digestWithMD5(content.toString());
//		if(testId!=1003) {
//			userDO.setPayPassword(payPasswordEnum);
//		}
//		userTestBase.insertUser(userDO);
//		if(testId!=1001) {
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.validatePayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(description, result.getMessage());
//		// 数据验证
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//	}
//
//}
