//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.UserLoginOrder;
//import com.xyb.gas.user.api.result.info.SimpleUserInfo;
//import dal.model.gas_user.UserPayToolInfoDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceLoginTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_user/userServiceLoginTestSuccess.csv")
//	@DisplayName("用户登录--成功用例")
//	public void userServiceLoginTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			UserLoginOrder order,
//			// 预置参数
//			dal.model.gas_user.UserDO gasUserDO,
//			UserDO userDO,
//			UserPayToolInfoDO userPayToolInfoDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserPayToolInfo(userPayToolInfoDO);
//		// 测试过程
//		// 调用接口
//		BizResult<SimpleUserInfo> result = userService.login(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS,code,result);
//		assertEquals(message,result.getDescription());
//		// 数据验证
//		SimpleUserInfo userInfo=result.getInfo();
//		assertEquals(gasUserDO.getBirthday(),userInfo.getBirthday());
//		assertEquals(gasUserDO.getHeadImgUrl(),userInfo.getHeadImgUrl());
//		assertEquals(gasUserDO.getMemberType(),userInfo.getMemberType().code());
//		assertEquals(gasUserDO.getMobile(),userInfo.getMobile());
//		assertEquals(gasUserDO.getNickName(),userInfo.getNickName());
//		assertEquals(gasUserDO.getPartnerId(),userInfo.getPartnerId());
//		assertEquals(gasUserDO.getSex(),userInfo.getSex().code());
//		assertEquals(gasUserDO.getUserId(),userInfo.getUserId());
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceLoginTestFailOne.csv")
//	@DisplayName("用户登录--参数非法")
//	public void userServiceLoginTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			UserLoginOrder order,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId==1001){
//			order.setPartnerId(null);
//		}
//		if(testId==1002){
//			order.setOpenId(null);
//		}
//		if(testId==1003){
//			order.setGid(null);
//		}
//		if(testId==1004){
//			order=null;
//		}
//		// 调用接口
//		BizResult result = userService.login(order);
//		// 结果验证
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceLoginTestFailTwo.csv")
//	@DisplayName("用户登录--失败用例")
//	public void userServiceLoginTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			UserLoginOrder order,
//			// 预置参数
//			dal.model.gas_user.UserDO gasUserDO,
//			UserDO userDO,
//			UserPayToolInfoDO userPayToolInfoDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserPayToolInfo(userPayToolInfoDO);
//		// 测试过程
//		// 调用接口
//		BizResult result = userService.login(order);
//		// 结果验证
//		assertEquals(Status.FAIL, result.getStatus());
//		// 数据验证
//		assertEquals(null,result.getInfo());
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//	}
//}
