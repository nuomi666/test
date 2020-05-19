//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.order.QueryCardOrder;
//import com.xyb.gas.user.api.result.info.CardInfo;
//import dal.model.gas_user.UserCardInfoDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/16.
// */
//public class CardManageServiceQueryCardTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryCardTestSuccess.csv")
//	@DisplayName("通过内码查询卡信息--成功用例")
//	public void cardManageServiceQueryCardTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QueryCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		// 准备数据
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		// 测试过程
//		// 调用接口
//		BizResult<CardInfo> result = cardManageService.queryCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		CardInfo info=result.getInfo();
//		assertEquals(gasUserCardDO.getAccountNo(),info.getAccountNo());
//		assertEquals(gasUserCardDO.getAccountTag(), info.getAccountTag());
//		assertEquals(gasUserCardDO.getCardNo(),info.getCardNo());
//		assertEquals(gasUserCardDO.getCardType(),info.getCardType().code());
//		assertEquals(order.getInternalNo(),info.getInternalNo());
//		assertEquals(gasUserCardDO.getParentCardAccountNo(),info.getParentCardAccountNo());
//		assertEquals(gasUserCardDO.getPartnerId(),info.getPartnerId());
//		assertEquals(gasUserCardDO.getStatus(),info.getStatus().code());
//		assertEquals(gasUserCardDO.getTag(),info.getTag().code());
//		assertEquals(gasUserCardDO.getUserId(),info.getUserId());
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryCardTestFailOne.csv")
//	@DisplayName("通过内码查询卡信息--参数非法")
//	public void cardManageServiceQueryCardTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryCardOrder order,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		// 测试过程
//		if(testId==1001){
//			order=null;
//		}
//		if(testId==1002){
//			order.setGid(null);
//		}
//		if(testId==1003){
//			order.setInternalNo(null);
//		}
//		// 调用接口
//		BizResult<CardInfo> result = cardManageService.queryCard(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryCardTestFailTwo.csv")
//	@DisplayName("通过内码查询卡信息--失败用例")
//	public void cardManageServiceQueryCardTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		// 准备数据
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		// 测试过程
//		// 调用接口
//		BizResult<CardInfo> result = cardManageService.queryCard(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(message, result.getMessage());
//		// 数据验证
//		CardInfo info=result.getInfo();
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//	}
//}
