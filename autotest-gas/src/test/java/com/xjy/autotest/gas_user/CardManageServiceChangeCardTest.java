//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.enums.CardStatus;
//import com.xyb.gas.user.api.enums.CardType;
//import com.xyb.gas.user.api.order.ChangeCardOrder;
//import dal.model.gas_merchant.GasMerchantCardDO;
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
//public class CardManageServiceChangeCardTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceChangeCardTestSuccess.csv")
//	@DisplayName("更换实体卡--成功用例")
//	public void cardManageServiceChangeCardTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ChangeCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserDO gasUserDO,
//			GasMerchantCardDO gasMerchantCardDO
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getNewCardNo());
//		// 准备数据
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		gasMerchantTestBase.insertGasMerchantCard(gasMerchantCardDO);
//		// 测试过程
//		if(testId==1001||testId==1002){
//			order.setNewCardNo(null);
//		}
//		// 调用接口
//		SimpleResult result = cardManageService.changeCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<UserCardInfoDO> cradInfos= gasUserTestBase.findUserCardInfoByUserId(gasUserDO.getUserId());
//		assertTrue(cradInfos.size()>0);
//		for(UserCardInfoDO cradInfo:cradInfos){
//			assertEquals(order.getInternalNo(),cradInfo.getInternalNo());
//			assertEquals(gasUserCardDO.getPartnerId(),cradInfo.getPartnerId());
//			assertEquals(CardStatus.NORMAL.code(),cradInfo.getStatus());
//			assertEquals(CardType.ENTITY.code(),cradInfo.getCardType());
//			assertEquals(gasUserCardDO.getTag(),cradInfo.getTag());
//			assertEquals(gasUserCardDO.getAccountNo(),cradInfo.getAccountNo());
//			if(testId==1001||testId==1002){
//				assertEquals(gasUserCardDO.getCardNo(),cradInfo.getCardNo());
//			}else {
//				assertEquals(order.getNewCardNo(),cradInfo.getCardNo());
//			}
//		}
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getNewCardNo());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceChangeCardTestFailOne.csv")
//	@DisplayName("更换实体卡--参数非法")
//	public void cardManageServiceChangeCardTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ChangeCardOrder order
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
//			order.setOldCardNo(null);
//		}
//		if(testId==1005){
//			order.setInternalNo(null);
//		}
//		// 调用接口
//		SimpleResult result = cardManageService.changeCard(order);
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
//	@AutoTest(file = "gas_user/cardManageServiceChangeCardTestFailTwo.csv")
//	@DisplayName("更换实体卡--失败用例")
//	public void cardManageServiceChangeCardTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ChangeCardOrder order,
//			// 预置参数
//			String userIdxx,
//			UserCardInfoDO gasUserCardDO,
//			UserDO gasUserDO,
//			UserCardInfoDO gasUserCardDO1,
//			GasMerchantCardDO gasMerchantCardDO
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(userIdxx);
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(userIdxx);
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getNewCardNo());
//		// 准备数据
//		if(testId!=1001){
//			gasUserTestBase.insertUser(gasUserDO);
//		}
//		if(testId!=1002){
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		}
//		if(testId==1004){
//			gasUserCardDO1.setUserId(userIdxx);
//			gasUserCardDO1.setCardNo(userIdxx);
//			gasUserCardDO1.setCardType(gasUserCardDO.getCardType());
//			gasUserCardDO1.setPartnerId(gasUserCardDO.getPartnerId());
//			gasUserCardDO1.setTag(gasUserCardDO.getTag());
//			gasUserCardDO1.setInternalNo(order.getInternalNo());
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO1);
//		}
//		if (testId != 1004) {
//			gasMerchantTestBase.insertGasMerchantCard(gasMerchantCardDO);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = cardManageService.changeCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(userIdxx);
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(userIdxx);
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getNewCardNo());
//	}
//}
