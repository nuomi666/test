//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.gas.user.api.UserPayToolService;
//import com.xyb.gas.user.api.order.SyncPayUserInfoOrder;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserPayToolInfoDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/20.
// */
//public class UserPayToolServiceSyncPayUserInfoTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserPayToolService userPayToolService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userPayToolServiceSyncPayUserInfoTestSuccess.csv")
//	@DisplayName("支付完成--成功用例")
//	public void userPayToolServiceSyncPayUserInfoTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			SyncPayUserInfoOrder order,
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
////		gasUserTestBase.cleanUserPayToolInfoByPartnerIdAndOpenId(order.getPartnerId(),order.getOpenId());
//		// 准备数据
//		if(testId>=1002){
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		// 测试过程
//		if(testId==1001){
//			order.setUserId(null);
//		}
//		// 调用接口
//		SimpleResult result = userPayToolService.syncPayUserInfo(order);
//		// 结果验证
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userPayToolServiceSyncPayUserInfoTestFailOne.csv")
//	@DisplayName("支付完成--成功用例")
//	public void userPayToolServiceSyncPayUserInfoTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			SyncPayUserInfoOrder order,
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
////		gasUserTestBase.cleanUserPayToolInfoByPartnerIdAndOpenId(order.getPartnerId(),order.getOpenId());
//		// 准备数据
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userPayToolService.syncPayUserInfo(order);
//		// 结果验证
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userPayToolServiceSyncPayUserInfoTestFailTwo.csv")
//	@DisplayName("支付完成--成功用例")
//	public void userPayToolServiceSyncPayUserInfoTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			SyncPayUserInfoOrder order,
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
////		gasUserTestBase.cleanUserPayToolInfoByPartnerIdAndOpenId(order.getPartnerId(),order.getOpenId());
//		// 准备数据
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userPayToolService.syncPayUserInfo(order);
//		// 结果验证
//		// 数据验证
//		// 清除数据
//	}
//}
