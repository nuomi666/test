//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.SyncWeChatInfoOrder;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserPayToolInfoDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceSyncTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserService userService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceSyncTestSuccess.csv")
//	@DisplayName("同步用户微信信息--成功用例")
//	public void userServiceSyncTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			SyncWeChatInfoOrder order,
//			// 会员
//			UserDO jhyUserDO,
//			UserPayToolInfoDO userPayToolInfoDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(order.getPartnerId());
//		// 准备数据
//		if(testId==1004){
//			userPayToolInfoDO.setUserId(null);
//		}
//		if(testId==1002||testId==1004||testId==1005){
//			gasUserTestBase.insertUserPayToolInfo(userPayToolInfoDO);
//		}
//		if(testId==1002||testId==1005){
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		// 测试过程
//		if(testId<=1002){
//			order.setHeadImgUrl(null);
//			order.setNickName(null);
//			order.setSex(null);
//		}
//		// 调用接口
//		SimpleResult result = userService.sync(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS,code,result);
//		assertEquals(message,result.getDescription());
//		// 数据验证
//		UserPayToolInfoDO userPayToolInfo = gasUserTestBase.findUserPayToolInfoByPartnerId(order.getPartnerId()).stream().filter((upy) -> (order.getOpenId().equals(upy.getOpenId()))).collect(Collectors.toList()).get(0);
//		assertEquals(order.getType().code(), userPayToolInfo.getType());
//		List<UserDO> userInfo = gasUserTestBase.findUserByUserId(jhyUserDO.getUserId());
//		if(testId==1005) {
//			assertEquals(order.getHeadImgUrl(), userInfo.get(0).getHeadImgUrl());
//			assertEquals(order.getNickName(), userInfo.get(0).getNickName());
//			assertEquals(order.getSex().code(), userInfo.get(0).getSex());
//			assertEquals(jhyUserDO.getRawAddTime(),userInfo.get(0).getRawAddTime());
//			assertNotEquals(jhyUserDO.getRawUpdateTime(),userInfo.get(0).getRawUpdateTime());
//		}
//		if(testId==1002) {
//			assertEquals(jhyUserDO.getHeadImgUrl(),userInfo.get(0).getHeadImgUrl());
//			assertEquals(jhyUserDO.getNickName(),userInfo.get(0).getNickName());
//			assertEquals(jhyUserDO.getSex(),userInfo.get(0).getSex());
//			assertEquals(jhyUserDO.getRawAddTime(),userInfo.get(0).getRawAddTime());
//			assertEquals(jhyUserDO.getRawUpdateTime(), userInfo.get(0).getRawUpdateTime());
//		}
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(order.getPartnerId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceSyncTestFailOne.csv")
//	@DisplayName("同步用户微信信息--参数非法")
//	public void userServiceSyncTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			SyncWeChatInfoOrder order,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId==1001){
//			order.setType(null);
//		}
//		if(testId==1002){
//			order.setPartnerId(null);
//		}
//		if(testId==1003){
//			order.setOpenId(null);
//		}
//		if(testId==1004){
//			order.setGid(null);
//		}
//		if(testId==1005){
//			order=null;
//		}
//		// 调用接口
//		SimpleResult result = userService.sync(order);
//		// 结果验证
//		assertResult(testId,Status.FAIL,code,result);
//		assertEquals(message,result.getMessage());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceSyncTestFailTwo.csv")
//	@DisplayName("同步用户微信信息--失败用例")
//	public void userServiceSyncTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			SyncWeChatInfoOrder order,
//			// 会员
//			UserDO jhyUserDO,
//			UserPayToolInfoDO userPayToolInfoDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//		// 准备数据
//		gasUserTestBase.insertUserPayToolInfo(userPayToolInfoDO);
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.sync(order);
//		// 结果验证
//		print(result);
//		assertEquals(Status.FAIL, result.getStatus());
//		// 数据验证
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(userPayToolInfoDO.getPartnerId());
//	}
//}
