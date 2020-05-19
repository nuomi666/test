//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.order.QuerySingleCardOrder;
//import com.xyb.gas.user.api.result.info.CardInfo;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/16.
// */
//public class CardManageServiceQuerySingleCardTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQuerySingleCardTestSuccess.csv")
//	@DisplayName("根据卡号、用户ID查询卡的信息--成功用例")
//	public void cardManageServiceQuerySingleCardTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QuerySingleCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserDO gasUserDO
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		// 准备数据
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		// 测试过程
//		// 调用接口
//		BizResult<CardInfo> result = cardManageService.querySingleCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		CardInfo info=result.getInfo();
//		assertEquals(gasUserCardDO.getAccountNo(),info.getAccountNo());
//		assertEquals(gasUserCardDO.getAccountTag(), info.getAccountTag());
//		assertEquals(order.getCardNo(),info.getCardNo());
//		assertEquals(gasUserCardDO.getCardType(),info.getCardType().code());
//		assertEquals(gasUserCardDO.getInternalNo(),info.getInternalNo());
//		assertEquals(gasUserCardDO.getParentCardAccountNo(),info.getParentCardAccountNo());
//		assertEquals(gasUserCardDO.getPartnerId(),info.getPartnerId());
//		assertEquals(gasUserCardDO.getStatus(),info.getStatus().code());
//		assertEquals(gasUserCardDO.getTag(),info.getTag().code());
//		assertEquals(order.getUserId(),info.getUserId());
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQuerySingleCardTestFailOne.csv")
//	@DisplayName("根据卡号、用户ID查询卡的信息--参数非法")
//	public void cardManageServiceQuerySingleCardTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QuerySingleCardOrder order,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId==1001){
//			order=null;
//		}
//		if(testId==1002){
//			order.setGid(null);
//		}
//		if(testId==1003){
//			order.setUserId(null);
//		}
//		if(testId==1004){
//			order.setCardNo(null);
//		}
//		// 调用接口
//		BizResult<CardInfo> result = cardManageService.querySingleCard(order);
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
//	@AutoTest(file = "gas_user/cardManageServiceQuerySingleCardTestFailTwo.csv")
//	@DisplayName("根据卡号、用户ID查询卡的信息--失败用例")
//	public void cardManageServiceQuerySingleCardTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QuerySingleCardOrder order,
//			// 预置参数
//			String userIdxx,
//			UserCardInfoDO gasUserCardDO,
//			UserDO gasUserDO,
//			//干扰数据
//			UserCardInfoDO gasUserCardDO1,
//			UserDO gasUserDO1,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(userIdxx);
//		gasUserTestBase.cleanUserCardInfoByUserId(userIdxx);
//		// 准备数据
//		if(testId!=1001) {
//			gasUserTestBase.insertUser(gasUserDO);
//		}
//		if(testId!=1002) {
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		}
//		if(testId==1003) {
//			gasUserDO1.setUserId(userIdxx);
//			gasUserDO1.setPartnerId(gasUserDO.getPartnerId());
//			gasUserDO1.setMobile("15215748562");
//			gasUserTestBase.insertUser(gasUserDO1);
//			gasUserCardDO1.setUserId(userIdxx);
//			gasUserCardDO1.setCardNo(userIdxx);
//			gasUserCardDO1.setCardType(gasUserCardDO.getCardType());
//			gasUserCardDO1.setPartnerId(gasUserCardDO.getPartnerId());
//			gasUserCardDO1.setTag(gasUserCardDO.getTag());
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO1);
//		}
//		// 测试过程
//		if(testId==1003){
//			order.setUserId(userIdxx);
//			order.setCardNo(gasUserCardDO.getCardNo());
//		}
//		if(testId==1004){
//			order.setUserId(gasUserCardDO.getUserId());
//			order.setCardNo(userIdxx);
//		}
//		// 调用接口
//		BizResult<CardInfo> result = cardManageService.querySingleCard(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO1.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//		gasUserTestBase.cleanUserByUserId(userIdxx);
//		gasUserTestBase.cleanUserCardInfoByUserId(userIdxx);
//	}
//}
