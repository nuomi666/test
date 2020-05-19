//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.enums.CardStatus;
//import com.xyb.gas.user.api.enums.CardType;
//import com.xyb.gas.user.api.order.LostCardOrder;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/16.
// */
//public class CardManageServiceLostCardTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceLostCardTestSuccess.csv")
//	@DisplayName("挂失--成功用例")
//	public void cardManageServiceLostCardTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			LostCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserDO gasUserDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByPartnerId(order.getPartnerId());
//		// 准备数据
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		// 测试过程
//		// 调用接口
//		SimpleResult result = cardManageService.lostCard(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS, code, result);
//		assertEquals(message, result.getDescription());
//		// 数据验证
//		List<UserCardInfoDO> cradInfos= gasUserTestBase.findUserCardInfoByUserId(gasUserDO.getUserId());
//		assertTrue(cradInfos.size()>0);
//		for(UserCardInfoDO cradInfo:cradInfos){
//			assertEquals(gasUserCardDO.getInternalNo(),cradInfo.getInternalNo());
//			assertEquals(gasUserCardDO.getPartnerId(),cradInfo.getPartnerId());
//			assertEquals(CardStatus.LOST.code(),cradInfo.getStatus());
//			assertEquals(CardType.ENTITY.code(),cradInfo.getCardType());
//			assertEquals(gasUserCardDO.getTag(),cradInfo.getTag());
//			assertEquals(gasUserCardDO.getAccountNo(),cradInfo.getAccountNo());
//			assertEquals(order.getCardNo(),cradInfo.getCardNo());
//		}
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByPartnerId(order.getPartnerId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceLostCardTestFailOne.csv")
//	@DisplayName("挂失--参数非法")
//	public void cardManageServiceLostCardTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			LostCardOrder order,
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
//			order.setPartnerId(null);
//		}
//		if(testId==1004){
//			order.setCardNo(null);
//		}
//		// 调用接口
//		SimpleResult result = cardManageService.lostCard(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
////		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 调这个接口前会拿用户的手机去查询对应的卡信息，所以在这层调用不存在用户不存在这种情况
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceLostCardTestFailTwo.csv")
//	@DisplayName("挂失--失败用例")
//	public void cardManageServiceLostCardTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			LostCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserDO gasUserDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByPartnerId(order.getPartnerId());
//		// 准备数据
//		if(testId!=1001){
//			gasUserTestBase.insertUser(gasUserDO);
//		}
//		if(testId!=1002){
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = cardManageService.lostCard(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(message, result.getDescription());
//		// 数据验证
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByPartnerId(order.getPartnerId());
//	}
//}
