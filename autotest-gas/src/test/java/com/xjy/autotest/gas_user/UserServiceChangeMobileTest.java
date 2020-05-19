//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.ChangeMobileOrder;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/28.
// */
//public class UserServiceChangeMobileTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
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
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceChangeMobileTestSuccess.csv")
//	@DisplayName("修改手机号--成功用例")
//	public void userServiceChangeMobileTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			ChangeMobileOrder order,
//			dal.model.gas_user.UserDO jhyUserDO,
//			dal.model.gas_user.UserDO jhyUserDO1,
//			UserDO userDO,
//			UserDO userDO1
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO1.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO1.getUserId());
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		gasUserTestBase.insertUser(jhyUserDO);
//		String key="gas-user:"+jhyUserDO.getPartnerId() + order.getNewMobile();
//		if(testId!=1001) {
//			redisTemplate.opsForValue().set(key, order.getSmsValidateCode());
//		}
//		//干扰数据
//		userTestBase.insertUser(userDO1);
//		gasUserTestBase.insertUser(jhyUserDO1);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = userService.changeMobile(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		UserDO userInfo=userTestBase.findUserByUserId(userDO.getUserId()).get(0);
//		assertEquals(order.getNewMobile(),userInfo.getMobile());
//		UserDO userInfoxx=userTestBase.findUserByUserId(userDO1.getUserId()).get(0);
//		assertEquals(userDO1.getMobile(),userInfoxx.getMobile());
//		dal.model.gas_user.UserDO gasUserInfo=gasUserTestBase.findUserByUserId(jhyUserDO.getUserId()).get(0);
//		assertEquals(order.getNewMobile(),gasUserInfo.getMobile());
//		dal.model.gas_user.UserDO gasUserInfoxx=gasUserTestBase.findUserByUserId(jhyUserDO1.getUserId()).get(0);
//		assertEquals(jhyUserDO1.getMobile(),gasUserInfoxx.getMobile());
//		// 清除数据
//		redisTemplate.delete(key);
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO1.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO1.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceChangeMobileTestFailOne.csv")
//	@DisplayName("修改手机号--参数非法")
//	public void userServiceChangeMobileTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ChangeMobileOrder order
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		order.setGid(GID.newGID());
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
//			order.setOldMobile(null);
//		}
//		if (testId == 1005) {
//			order.setNewMobile(null);
//		}
//		// 调用接口
//		SimpleResult result = userService.changeMobile(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceChangeMobileTestFailTwo.csv")
//	@DisplayName("修改手机号--失败用例")
//	public void userServiceChangeMobileTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ChangeMobileOrder order,
//			dal.model.gas_user.UserDO jhyUserDO,
//			dal.model.gas_user.UserDO jhyUserDO1,
//			UserDO userDO,
//			UserDO userDO1
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO1.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO1.getUserId());
//		// 准备数据
//		if(testId!=1004) {
//			userTestBase.insertUser(userDO);
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		String key="gas-user:"+jhyUserDO.getPartnerId() + order.getNewMobile();
//		if(testId==1001) {
//			redisTemplate.opsForValue().set(key, "5566");
//		}else {
//			redisTemplate.opsForValue().set(key, order.getSmsValidateCode());
//		}
//		Object obj=redisTemplate.opsForValue().get(key);
//		//干扰数据
//		userTestBase.insertUser(userDO1);
//		gasUserTestBase.insertUser(jhyUserDO1);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = userService.changeMobile(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
////		UserDO userInfo=userTestBase.findUserByUserId(userDO.getUserId()).get(0);
////		assertEquals(userDO.getMobile(),userInfo.getMobile());
////		UserDO userInfoxx=userTestBase.findUserByUserId(userDO1.getUserId()).get(0);
////		assertEquals(userDO1.getMobile(),userInfoxx.getMobile());
////		dal.model.gas_user.UserDO gasUserInfo=gasUserTestBase.findUserByUserId(jhyUserDO.getUserId()).get(0);
////		assertEquals(jhyUserDO.getMobile(),gasUserInfo.getMobile());
////		dal.model.gas_user.UserDO gasUserInfoxx=gasUserTestBase.findUserByUserId(jhyUserDO1.getUserId()).get(0);
////		assertEquals(jhyUserDO1.getMobile(),gasUserInfoxx.getMobile());
//		// 清除数据
//		redisTemplate.delete(key);
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO1.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO1.getUserId());
//	}
//}
