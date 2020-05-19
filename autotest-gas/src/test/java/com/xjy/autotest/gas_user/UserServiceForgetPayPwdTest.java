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
//import com.xyb.gas.user.api.order.ForgetPayPwdOrder;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceForgetPayPwdTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserService userService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	private StringRedisTemplate redisTemplate;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceForgetPayPwdTestSuccess.csv")
//	@DisplayName("找回支付密码--成功用例")
//	public void userServiceForgetPayPwdTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			ForgetPayPwdOrder order,
//			// 数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserDO userDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		gasUserTestBase.insertUser(jhyUserDO);
//		String key="gas-user:"+jhyUserDO.getPartnerId() + jhyUserDO.getMobile();
//		redisTemplate.opsForValue().set(key,order.getSmsValidateCode());
//		// 测试过程
//		order.setMobile("15215046789");
//		// 调用接口
//		SimpleResult result = userService.forgetPayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS, code, result);
//		assertEquals(message, result.getDescription());
//		// 数据验证
//		StringBuffer content = new StringBuffer();
//		content.append(userDO.getUserId().substring(15, 20));
//		content.append(order.getPayPwd());
//		content.append(userDO.getUserId().substring(10, 14));
//		String passwordEnum = DigestUtil.digestWithMD5(content.toString());
//		UserDO userInfo= userTestBase.findUserByUserId(order.getPartnerId()).get(0);
//		assertEquals(passwordEnum,userInfo.getPayPassword());
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
//		redisTemplate.delete(jhyUserDO.getPartnerId() + jhyUserDO.getMobile());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//	}
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceForgetPayPwdTestFailOne.csv")
//	@DisplayName("找回支付密码--参数非法")
//	public void userServiceForgetPayPwdTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			ForgetPayPwdOrder order,
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
//			order.setPartnerId(null);
//		}
//		if (testId == 1004) {
//			order.setPayPwd(null);
//		}
//		if (testId == 1005) {
//			order.setSmsValidateCode(null);
//		}
//		// 调用接口
//		SimpleResult result = userService.forgetPayPwd(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL,code,result);
//		assertEquals(message,result.getDescription());
//		// 数据验证
//		// 清除数据
//	}
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceForgetPayPwdTestFailTwo.csv")
//	@DisplayName("找回支付密码--失败用例")
//	public void userServiceForgetPayPwdTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			ForgetPayPwdOrder order,
//			// 数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserDO userDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		// 准备数据
//		String key="gas-user:"+jhyUserDO.getPartnerId() + jhyUserDO.getMobile();
////		if(testId==1001) {
////			redisTemplate.opsForValue().set(jhyUserDO.getPartnerId() + jhyUserDO.getMobile(), order.getSmsValidateCode());
////		}
////		if(testId==1002) {
////			redisTemplate.opsForValue().set(key, "5648");
////		}
////		if(testId>1002) {
////			redisTemplate.opsForValue().set(key, order.getSmsValidateCode());
////		}
//		if(testId!=1003) {
//			userTestBase.insertUser(userDO);
//		}
//		if(testId!=1004) {
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.forgetPayPwd(order);
//		// 结果验证
//		assertResult(testId,Status.FAIL,code,result);
//		assertEquals(message,result.getMessage());
//		// 数据验证
//		// 清除数据
////		redisTemplate.delete(jhyUserDO.getPartnerId() + jhyUserDO.getMobile());
////		redisTemplate.delete(key);
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//	}
//}
