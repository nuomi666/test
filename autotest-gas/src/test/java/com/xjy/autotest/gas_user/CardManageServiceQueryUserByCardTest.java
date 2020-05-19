//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.order.QueryUserByCardOrder;
//import com.xyb.gas.user.api.result.QueryUserByCardResult;
//import com.xyb.gas.user.api.result.info.UserCardInfo;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/16.
// */
//public class CardManageServiceQueryUserByCardTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	UserTestBase userTestBase;
//	/**
//	 * 目前只考虐了一张卡对应一个资金账户的情况
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryUserByCardTestSuccess.csv")
//	@DisplayName("根据卡号列表查询相关卡信息--成功用例")
//	public void cardManageServiceQueryUserByCardTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QueryUserByCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserCardInfoDO gasUserCardDO1,
//			AccountDO accountDO,
//			AccountDO accountDO1
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getCardNo());
//		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//		userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
//		// 准备数据
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		userTestBase.insertAccount(accountDO);
//		if(testId==1002) {
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO1);
//			userTestBase.insertAccount(accountDO1);
//		}
//		// 测试过程
//        List<String> cards = new ArrayList<String>();
//        cards.add(gasUserCardDO.getCardNo());
//        if(testId>=1002&&testId<=1003){
//			cards.add(gasUserCardDO1.getCardNo());
//		}
//		order.setCards(cards);
//		// 调用接口
//		QueryUserByCardResult result = cardManageService.queryUserByCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<UserCardInfo> cardInfos=result.getList();
//		if(testId==1001||testId==1003){
//			assertEquals(1,cardInfos.size());
//			for(UserCardInfo cardInfo:cardInfos){
//				assertEquals(gasUserCardDO.getAccountNo(),cardInfo.getAccountNo());
//				assertEquals(accountDO.getBalance(),cardInfo.getBalance().getCent());
//				assertEquals(gasUserCardDO.getCardNo(),cardInfo.getCardNo());
//				assertEquals(gasUserCardDO.getUserId(),cardInfo.getUserId());
//				assertEquals(gasUserCardDO.getInternalNo(),cardInfo.getInternalNo());
//				assertEquals(gasUserCardDO.getParentCardAccountNo(),cardInfo.getParentCardAccountNo());
//				assertEquals(gasUserCardDO.getPartnerId(),cardInfo.getPartnerId());
//				assertEquals(gasUserCardDO.getStatus(),cardInfo.getStatus().code());
//				assertEquals(gasUserCardDO.getTag(),cardInfo.getTag().code());
//				assertEquals(gasUserCardDO.getCardType(),cardInfo.getCardType().code());
//			}
//		}else {
//			assertEquals(2,cardInfos.size());
//			for(UserCardInfo cardInfo:cardInfos){
//				if(gasUserCardDO.getCardNo().equals(cardInfo.getCardNo())) {
//					assertEquals(gasUserCardDO.getAccountNo(),cardInfo.getAccountNo());
//					assertEquals(accountDO.getBalance(),cardInfo.getBalance().getCent());
//					assertEquals(gasUserCardDO.getCardNo(),cardInfo.getCardNo());
//					assertEquals(gasUserCardDO.getUserId(),cardInfo.getUserId());
//					assertEquals(gasUserCardDO.getInternalNo(),cardInfo.getInternalNo());
//					assertEquals(gasUserCardDO.getParentCardAccountNo(),cardInfo.getParentCardAccountNo());
//					assertEquals(gasUserCardDO.getPartnerId(),cardInfo.getPartnerId());
//					assertEquals(gasUserCardDO.getStatus(),cardInfo.getStatus().code());
//					assertEquals(gasUserCardDO.getTag(),cardInfo.getTag().code());
//					assertEquals(gasUserCardDO.getCardType(),cardInfo.getCardType().code());
//				}
//				if(gasUserCardDO1.getCardNo().equals(cardInfo.getCardNo())) {
//					assertEquals(gasUserCardDO1.getAccountNo(),cardInfo.getAccountNo());
//					assertEquals(accountDO1.getBalance(),cardInfo.getBalance().getCent());
//					assertEquals(gasUserCardDO1.getUserId(),cardInfo.getUserId());
//					assertEquals(gasUserCardDO1.getInternalNo(),cardInfo.getInternalNo());
//					assertEquals(gasUserCardDO1.getParentCardAccountNo(),cardInfo.getParentCardAccountNo());
//					assertEquals(gasUserCardDO1.getPartnerId(),cardInfo.getPartnerId());
//					assertEquals(gasUserCardDO1.getStatus(),cardInfo.getStatus().code());
//					assertEquals(gasUserCardDO1.getTag(),cardInfo.getTag().code());
//					assertEquals(gasUserCardDO1.getCardType(),cardInfo.getCardType().code());
//				}
//			}
//		}
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getCardNo());
//		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//		userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryUserByCardTestFailOne.csv")
//	@DisplayName("根据卡号列表查询相关卡信息--参数非法")
//	public void cardManageServiceQueryUserByCardTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryUserByCardOrder order,
//			String cardNo,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		List<String> cards = new ArrayList<String>();
//		List<String> accountNoList = new ArrayList<String>();
//		if(testId != 1004){
//			cards.add(cardNo);
//		}
//		order.setCards(cards);
//		if(testId == 1001){
//			order = null;
//		}
//		if(testId == 1002){
//			order.setGid(null);
//		}
//		if(testId == 1003){
//			order.setCards(null);
//		}
//		// 调用接口
//		QueryUserByCardResult result = cardManageService.queryUserByCard(order);
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
//	@AutoTest(file = "gas_user/cardManageServiceQueryUserByCardTestFailTwo.csv")
//	@DisplayName("根据卡号列表查询相关卡信息--失败用例")
//	public void cardManageServiceQueryUserByCardTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryUserByCardOrder order,
//			String cardNoxx,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(cardNoxx);
//		// 准备数据
//		// 测试过程
//		List<String> cards = new ArrayList<String>();
//		cards.add(cardNoxx);
//		order.setCards(cards);
//		// 调用接口
//		QueryUserByCardResult result = cardManageService.queryUserByCard(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//		 gasUserTestBase.cleanUserCardInfoByUserId(cardNoxx);
//	}
//}
