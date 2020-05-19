//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.security.DigestUtil;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.InitPayPwdOrder;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceInitPayPwdTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserService userService;
//
//	@Autowired
//	UserTestBase userTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceInitPayPwdTestSuccess.csv")
//	@DisplayName("第一次设置支付密码--成功用例")
//	public void userServiceInitPayPwdTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			InitPayPwdOrder order,
//			// 数据库参数
//            UserDO userDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.initPayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS, code, result);
//		assertEquals(message, result.getDescription());
//		// 数据验证
//		StringBuffer content = new StringBuffer();
//		content.append(order.getUserId().substring(15, 20));
//		content.append(order.getPayPwd());
//		content.append(order.getUserId().substring(10, 14));
//		String oldPasswordEnum = DigestUtil.digestWithMD5(content.toString());
//		UserDO userInfo= userTestBase.findUserByUserId(order.getUserId()).get(0);
//		assertEquals(oldPasswordEnum, userInfo.getPayPassword());
//		assertEquals(userDO.getParentUserId(),userInfo.getParentUserId());
//		assertEquals(userDO.getRealName(),userInfo.getRealName());
//		assertEquals(userDO.getMobile(),userInfo.getMobile());
//		assertEquals(userDO.getUserType(),userInfo.getUserType());
//		assertEquals(userDO.getRegisterFrom(),userInfo.getRegisterFrom());
//		assertEquals(userDO.getMerchantUserId(),userInfo.getMerchantUserId());
//		assertEquals(userDO.getUserName(),userInfo.getUserName());
//		assertEquals(userDO.getCertNo(),userInfo.getCertNo());
//		assertEquals(userDO.getAddress(),userInfo.getAddress());
//		assertEquals(userDO.getCertType(),userInfo.getCertType());
//		assertEquals(userDO.getCity(),userInfo.getCity());
//		assertEquals(userDO.getCountry(),userInfo.getCountry());
//		assertEquals(userDO.getDistrict(),userInfo.getDistrict());
//		assertEquals(userDO.getMemo(),userInfo.getMemo());
//		assertEquals(userDO.getPhone(),userInfo.getPhone());
//		assertEquals(userDO.getProvince(),userInfo.getProvince());
//		assertEquals(userDO.getRegisterIp(),userInfo.getRegisterIp());
//		assertEquals(userDO.getZipCode(),userInfo.getZipCode());
//		assertEquals(userDO.getUserStatus(),userInfo.getUserStatus());
//		assertEquals(userDO.getCertifyStatus(),userInfo.getCertifyStatus());
//		assertEquals(userDO.getPartnerId(),userInfo.getPartnerId());
//		assertEquals(userDO.getCustomerId(),userInfo.getCustomerId());
//		assertEquals(userDO.getRawAddTime(),userInfo.getRawAddTime());
//		assertNotEquals(userDO.getRawUpdateTime(),userInfo.getRawUpdateTime());
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//	}
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceInitPayPwdTestFailOne.csv")
//	@DisplayName("第一次设置支付密码--参数非法")
//	public void userServiceInitPayPwdTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			InitPayPwdOrder order,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if (testId == 1001) {
//			order = null;
//		}
//		if (testId == 1002) {
//			order.setGid(null);
//		}
//		if (testId == 1003) {
//			order.setUserId(null);
//		}
//		if (testId == 1004) {
//			order.setPayPwd(null);
//		}
//		// 调用接口
//		SimpleResult result = userService.initPayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL,code,result);
//		assertEquals(message,result.getDescription());
//		// 数据验证
//		// 清除数据
//	}
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceInitPayPwdTestFailTwo.csv")
//	@DisplayName("第一次设置支付密码--失败用例")
//	public void userServiceInitPayPwdTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			InitPayPwdOrder order,
//			// 数据库参数
//			UserDO userDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		// 准备数据
//		if(testId==1002){
//			userTestBase.insertUser(userDO);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.initPayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL,code,result);
//		assertEquals(message,result.getMessage());
//		// 数据验证
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//	}
//}
