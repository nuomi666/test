//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.QueryUserService;
//import com.xyb.gas.user.api.order.QueryCardListByUserOrder;
//import com.xyb.gas.user.api.result.UserCardListResult;
//import com.xyb.gas.user.api.result.info.UserCardInfo;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/20.
// */
//public class QueryUserServiceQueryCardListByUserTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    QueryUserService queryUserService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	UserTestBase userTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryCardListByUserTestSuccess.csv")
//	@DisplayName("根据用户查询用户下的卡--成功用例")
//	public void queryUserServiceQueryCardListByUserTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryCardListByUserOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserCardInfoDO gasUserCardDO1,
//			AccountDO accountDO,
//			AccountDO accountDO1,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//		userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
//		// 准备数据
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		userTestBase.insertAccount(accountDO);
//		if(testId>=1002) {
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO1);
//			userTestBase.insertAccount(accountDO1);
//		}
//		// 测试过程
//		if(testId<=1002){
//			order.setCardType(null);
//			order.setStatus(null);
//			order.setTag(null);
//		}
//		// 调用接口
//		UserCardListResult result = queryUserService.queryCardListByUser(order);
//		// 结果验证
//		print(result);
//		assertEquals(Status.SUCCESS, result.getStatus());
//		// 数据验证
//		List<UserCardInfo> cardInfos=result.getList();
//		if(testId!=1002){
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
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//		userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryCardListByUserTestFailOne.csv")
//	@DisplayName("根据用户查询用户下的卡--参数非法")
//	public void queryUserServiceQueryCardListByUserTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryCardListByUserOrder order,
//			// 结果参数
//			String code,
//			String message,
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
//		if(testId == 1003){
//			order.setUserId(null);
//		}
//		// 调用接口
//		UserCardListResult result = queryUserService.queryCardListByUser(order);
//		// 结果验证
//		assertEquals(Status.FAIL, result.getStatus());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryCardListByUserTestFailTwo.csv")
//	@DisplayName("根据用户查询用户下的卡--失败用例")
//	public void queryUserServiceQueryCardListByUserTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryCardListByUserOrder order,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		// 准备数据
//		// 测试过程
//		// 调用接口
//		UserCardListResult result = queryUserService.queryCardListByUser(order);
//		// 结果验证
//		assertEquals(Status.FAIL, result.getStatus());
//		// 数据验证
//		// 清除数据
//		gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//	}
//}
