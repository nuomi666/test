//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.user.api.CardManageService;
//import com.xyb.gas.user.api.order.QueryCardByConditionOrder;
//import com.xyb.gas.user.api.result.CardQueryResult;
//import com.xyb.gas.user.api.result.QueryCardListResult;
//import com.xyb.gas.user.api.result.info.CarInfo;
//import com.xyb.gas.user.api.result.info.CardInfo;
//import com.xyb.gas.user.api.result.info.UserInfo;
//import dal.model.gas_user.UserCarInfoDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
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
//public class CardManageServiceQueryCardListTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    CardManageService cardManageService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//    @Autowired
//    UserTestBase userTestBase;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryCardListTestSuccess.csv")
//	@DisplayName("通过手机号或者卡号查询--成功用例")
//	public void cardManageServiceQueryCardListTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			QueryCardByConditionOrder order,
//			// 预置参数
//			UserCardInfoDO gasUserCardDO,
//			UserCardInfoDO gasUserCardDO1,
//			UserDO gasUserDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//        gasUserTestBase.cleanUserCarInfoByUserId(gasUserCardDO.getUserId());
//        userTestBase.cleanUserByUserId(gasUserCardDO.getUserId());
//        userTestBase.cleanAccountByUserId(gasUserCardDO.getUserId());
//        promotionTestBase.cleanPointsByUserId(gasUserCardDO.getUserId());
//		// 准备数据
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO1);
//        UserCarInfoDO userCarInfoDO=new UserCarInfoDO();
//        userCarInfoDO.setCarNumber("川M31B22");
//        userCarInfoDO.setUserId(gasUserCardDO.getUserId());
//        if(testId==1003){
//        gasUserTestBase.insertUserCarInfo(userCarInfoDO);
//        }
//        //积分
//        PointsDO pointsDO=new PointsDO();
//        pointsDO.setPartnerId(order.getPartnerId());
//        pointsDO.setPlatPartnerId("S0301806081400000015");
//        pointsDO.setUserId(gasUserDO.getUserId());
//        pointsDO.setPoints(100L);
//        pointsDO.setHistoryAddPoints(100L);
//        pointsDO.setHistorySubtractPoints(0L);
//        pointsDO.setPointId(OID.newID());
//        pointsDO.setRawAddTime(DateUtils.getSqlDate());
//        pointsDO.setRawUpdateTime(DateUtils.getSqlDate());
//        promotionTestBase.insertPoints(pointsDO);
//        //资金账户
//        dal.model.user.UserDO userDO=new  dal.model.user.UserDO();
//		userDO.setUserId(gasUserDO.getUserId());
//		userDO.setPartnerId(gasUserDO.getPartnerId());
//		userDO.setMobile(gasUserDO.getMobile());
//        userTestBase.insertUser(userDO);
//		AccountDO accountDO = new AccountDO();
//		accountDO.setAccountNo(gasUserDO.getUserId());
//		accountDO.setUserId(gasUserDO.getUserId());
//		accountDO.setStatus("ACTIVE");
//		accountDO.setAccountType("NORMAL");
//		accountDO.setPayModel("111");
//		accountDO.setTag("GAS_DUMMY_DEFAULT");
//		accountDO.setMemo("加好油测试账户1");
//		accountDO.setRawAddTime(DateUtils.getSqlDate());
//		accountDO.setRawUpdateTime(DateUtils.getSqlDate());
//		accountDO.setBalance(14500L);
//		accountDO.setFreezeBalance(200L);
//		accountDO.setHisInAmount(14500L);
//		accountDO.setHisOutAmount(0L);
//		userTestBase.insertAccount(accountDO);
//		// 测试过程
//		// 调用接口
//		CardQueryResult result = cardManageService.queryCardByCondition(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS, code, result);
////		assertEquals(message, result.getMessage());
//		// 数据验证
//        UserInfo user=result.getUserInfo();
//		assertEquals(gasUserDO.getUserId(), user.getUserId());
//		assertEquals(gasUserDO.getPartnerId(), user.getPartnerId());
//		assertEquals(gasUserDO.getRealName(), user.getRealName());
//		assertEquals(gasUserDO.getMobile(), user.getMobile());
//		assertEquals(gasUserDO.getBirthday(), user.getBirthday());
//		assertEquals(gasUserDO.getNickName(), user.getNickName());
//		assertEquals(gasUserDO.getHeadImgUrl(), user.getHeadImgUrl());
//		assertEquals(gasUserDO.getSex(), user.getSex().code());
//		if(testId==1003){
//			assertEquals(userCarInfoDO.getCarNumber(), user.getCarNumber());
//		}else {
//			assertEquals(null, user.getCarNumber());
//		}
//		assertEquals(gasUserDO.getMemberType(), user.getMemberType().code());
//		assertEquals(false, user.isPayed());
//		assertEquals(gasUserDO.getGrade(), user.getGrade());
////		assertEquals(gasUserDO.getUserId(), user.getCardNo());//没设置
//		assertEquals(accountDO.getAccountNo(), user.getAccountNo());
//		assertEquals(Money.cent(accountDO.getBalance()), user.getBalance());
//		assertEquals(pointsDO.getPoints().intValue(), user.getPoints());
//		assertEquals(gasUserDO.getRawAddTime(), user.getRawAddTime());
//        CardInfo card=result.getCardInfo();
//        String accountTag = "GAS_" + gasUserCardDO.getCardType() + "_" + gasUserCardDO.getTag();
//        assertEquals(gasUserCardDO.getAccountNo(), card.getAccountNo());
//        assertEquals(accountTag, card.getAccountTag());
//        assertEquals(gasUserCardDO.getCardNo(), card.getCardNo());
//        assertEquals(gasUserCardDO.getCardType(), card.getCardType().code());
//        assertEquals(gasUserCardDO.getInternalNo(), card.getInternalNo());
//        assertEquals(gasUserCardDO.getParentCardAccountNo(), card.getParentCardAccountNo());
//        assertEquals(gasUserCardDO.getPartnerId(), card.getPartnerId());
//        assertEquals(gasUserCardDO.getStatus(), card.getStatus().code());
//        assertEquals(gasUserCardDO.getTag(), card.getTag().code());
//        assertEquals(gasUserCardDO.getUserId(), card.getUserId());
//        CarInfo car = result.getCarInfo();
//        if(testId==1003){
//			assertEquals(userCarInfoDO.getCarNumber(), car.getCarNumber());
//		}else {
//        	assertEquals(null,car);
//		}
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO1.getUserId());
//		gasUserTestBase.cleanUserCarInfoByUserId(gasUserCardDO.getUserId());
//		userTestBase.cleanUserByUserId(gasUserCardDO.getUserId());
//		userTestBase.cleanAccountByUserId(gasUserCardDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(gasUserCardDO.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryCardListTestFailOne.csv")
//	@DisplayName("通过手机号或者卡号查询--参数非法")
//	public void cardManageServiceQueryCardListTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//            QueryCardByConditionOrder order,
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
//			order.setCondition(null);
//		}
//		// 调用接口
//        CardQueryResult result = cardManageService.queryCardByCondition(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
////		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/cardManageServiceQueryCardListTestFailTwo.csv")
//	@DisplayName("通过手机号或者卡号查询--失败用例")
//	public void cardManageServiceQueryCardListTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//            QueryCardByConditionOrder order,
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
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//		// 准备数据
//		gasUserTestBase.insertUser(gasUserDO);
//		gasUserTestBase.insertUserCardInfo(gasUserCardDO);
//		// 测试过程
//		// 调用接口
//        CardQueryResult result = cardManageService.queryCardByCondition(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
////		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByUserId(gasUserCardDO.getUserId());
//	}
//}
