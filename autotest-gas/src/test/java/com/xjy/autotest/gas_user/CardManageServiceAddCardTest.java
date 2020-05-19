//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.enums.CardStatus;
//import com.xyb.gas.user.api.order.AddCardOrder;
//import com.xyb.user.api.enums.AccountType;
//import dal.model.gas_merchant.GasMerchantCardDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.user.AccountDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/16.
// */
//public class CardManageServiceAddCardTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 注：添加实体卡时，先有对应的虚拟账户才行.实体卡卡号就是商户制卡的卡面号
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceAddCardTestSuccess.csv")
//	@DisplayName("添加卡--成功用例")
//	public void cardManageServiceAddCardTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddCardOrder order,
//			// 预置参数
//			dal.model.gas_user.UserDO gasUserDO,
//			UserDO userDO,
//			AccountDO accountDO,
//			GasMerchantCardDO gasMerchantCardDO
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getCardNo());
//		if(testId==1001||testId==1003) {
//			userTestBase.cleanAccountByUserId(userDO.getUserId());
//			gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		}
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		gasUserTestBase.insertUser(gasUserDO);
//		if(testId==1003){
//			accountDO.setAccountNo(order.getParentCardAccountNo());
//			userTestBase.insertAccount(accountDO);
//		}
//		if (testId == 1002 || testId == 1004) {
//			gasMerchantTestBase.insertGasMerchantCard(gasMerchantCardDO);
//		}
//		// 测试过程
//		if(testId==1001){
//			order.setInternalNo(null);
//			order.setParentCardAccountNo(null);
//		}
//		if(testId==1002){
//			order.setParentCardAccountNo(null);
//		}
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = cardManageService.addCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		UserCardInfoDO cardInfo= gasUserTestBase.findUserCardInfoByCardNo(order.getCardNo()).get(0);
//		assertEquals(order.getCardNo(),cardInfo.getCardNo());
//		assertEquals(order.getCardType().code(),cardInfo.getCardType());
//		assertEquals(order.getUserId(),cardInfo.getUserId());
//		assertEquals(order.getTag().code(),cardInfo.getTag());
//		assertEquals(gasUserDO.getPartnerId(),cardInfo.getPartnerId());
//		assertEquals(CardStatus.NORMAL.code(),cardInfo.getStatus());
//		if(testId==1001||testId==1003){
//			assertEquals(order.getCardNo(),cardInfo.getInternalNo());
//		}else {
//			assertEquals(order.getInternalNo(),cardInfo.getInternalNo());
//		}
//		if(testId==1001||testId==1002){
//			assertEquals(null,cardInfo.getParentCardAccountNo());
//		}else {
//			assertEquals(order.getParentCardAccountNo(),cardInfo.getParentCardAccountNo());
//		}
//		AccountDO accountInfo=userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//		if(testId==1001||testId==1002){
//			assertEquals(AccountType.NORMAL.code(),accountInfo.getAccountType());
//			assertEquals(null,accountInfo.getBandAccountNo());
//			assertEquals("加好油开卡",accountInfo.getMemo());
//		}
//		if(testId==1003||testId==1004){
//			assertEquals(AccountType.NORMAL.code(),accountInfo.getAccountType());
//			assertEquals(order.getParentCardAccountNo(),accountInfo.getBandAccountNo());
//			assertEquals("加好油开卡",accountInfo.getMemo());
//		}
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getCardNo());
//		if(testId==1002||testId==1004) {
//			userTestBase.cleanAccountByUserId(userDO.getUserId());
//			gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		}
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceAddCardTestFailOne.csv")
//	@DisplayName("添加卡--参数非法")
//	public void cardManageServiceAddCardTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddCardOrder order
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
//			order.setCardType(null);
//		}
//		if(testId==1005){
//			order.setTag(null);
//		}
//		if(testId==1006){
//			order.setCardNo(null);
//		}
//		if(testId==1007){
//			order.setInternalNo(null);
//		}
//		if(testId==1008){
//			order.setParentCardAccountNo(null);
//		}
//		// 调用接口
//		SimpleResult result = cardManageService.addCard(order);
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
//	@AutoTest(file = "gas_user/cardManageServiceAddCardTestFailTwo.csv")
//	@DisplayName("添加卡--失败用例")
//	public void cardManageServiceAddCardTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddCardOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			dal.model.gas_user.UserDO gasUserDO,
//			UserDO userDO,
//			GasMerchantCardDO gasMerchantCardDO
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		userTestBase.cleanAccountByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(gasMerchantCardDO.getCardNo());
//		// 准备数据
//		if(testId!=1001){
//			userTestBase.insertUser(userDO);
//			gasUserTestBase.insertUser(gasUserDO);
//		}
//		if(testId==1003){
//			gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		}
//		//商户实体卡
//		gasMerchantTestBase.insertGasMerchantCard(gasMerchantCardDO);
//		// 测试过程
//		if(testId==1003){
//			order.setCardNo(gasUserCardDO.getCardNo());
//		}
//		// 调用接口
//		SimpleResult result = cardManageService.addCard(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		userTestBase.cleanAccountByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(order.getUserId());
//		gasMerchantTestBase.cleanGasMerchantCardByCardNo(gasMerchantCardDO.getCardNo());
//	}
//}
