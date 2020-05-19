//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.user.api.QueryUserService;
//import com.xyb.gas.user.api.order.QueryUserCardOrder;
//import com.xyb.gas.user.api.result.CardQueryResult;
//import com.xyb.gas.user.api.result.info.CardInfo;
//import com.xyb.gas.user.api.result.info.UserInfo;
//import dal.model.gas_user.UserCarInfoDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/20.
// */
//public class QueryUserServiceQueryUserCardInfoTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    QueryUserService queryUserService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	PromotionTestBase promotionTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserCardInfoTestSuccess.csv")
//	@DisplayName("根据商户id和卡号获取查询用户信息及卡信息--成功用例")
//	public void queryUserServiceQueryUserCardInfoTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QueryUserCardOrder order,
//			// 预置参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserCardInfoDO cardDO,
//			UserCardInfoDO cardDO1,
//			UserCarInfoDO carInfoDO,
//			UserDO userDO,
//			AccountDO accountDO,
//			PointsDO pointsDO
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		// 准备数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		// 准备数据
//		gasUserTestBase.insertUser(jhyUserDO);
//		//虚拟卡
//		gasUserTestBase.insertUserCardInfo(cardDO);
//		//实体卡
//		if (testId != 1001) {
//			gasUserTestBase.insertUserCardInfo(cardDO1);
//		}
//		//加好油会员车辆信息
//		gasUserTestBase.insertUserCarInfo(carInfoDO);
//		//清结算会员
//		userTestBase.insertUser(userDO);
//		//清结算资金账户
//		userTestBase.insertAccount(accountDO);
//		//积分
//		promotionTestBase.insertPoints(pointsDO);
//		//测试过程
//		order.setGid(GID.newGID());
//		// 测试过程
//		// 调用接口
//		CardQueryResult result = queryUserService.queryUserCardInfo(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		UserInfo userInfo=result.getUserInfo();
//		assertEquals(accountDO.getAccountNo(),userInfo.getAccountNo());
//		assertEquals(carInfoDO.getCarNumber(), userInfo.getCarNumber());
//		assertEquals(jhyUserDO.getGrade(), userInfo.getGrade().code());
//		assertEquals(jhyUserDO.getHeadImgUrl(),userInfo.getHeadImgUrl());
//		assertEquals(jhyUserDO.getMobile(),userInfo.getMobile());
//		assertEquals(jhyUserDO.getNickName(),userInfo.getNickName());
//		assertEquals(order.getPartnerId(),userInfo.getPartnerId());
//		assertEquals(userDO.getRealName(),userInfo.getRealName());
//		assertEquals(jhyUserDO.getUserId(),userInfo.getUserId());
//		assertEquals(Money.cent(accountDO.getBalance()), userInfo.getBalance());
//		assertEquals(jhyUserDO.getBirthday(),userInfo.getBirthday());
//		assertEquals(jhyUserDO.getMemberType(),userInfo.getMemberType().code());
//		assertEquals(pointsDO.getPoints().intValue(), userInfo.getPoints());
//		assertEquals(jhyUserDO.getRawAddTime(),userInfo.getRawAddTime());
//		assertEquals(jhyUserDO.getSex(),userInfo.getSex().code());
//
//		CardInfo cardInfo=result.getCardInfo();
//		if (testId == 1003) {
//			assertEquals(cardDO1.getParentCardAccountNo(), cardInfo.getParentCardAccountNo());
//			assertEquals(cardDO1.getInternalNo(), cardInfo.getInternalNo());
//			assertEquals(cardDO1.getCardType(), cardInfo.getCardType().code());
//			assertEquals(cardDO1.getTag(), cardInfo.getTag().code());
//			assertEquals(cardDO1.getAccountTag(), cardInfo.getAccountTag());
//			assertEquals(cardDO1.getStatus(), cardInfo.getStatus().code());
//		} else {
//			assertEquals(cardDO.getParentCardAccountNo(), cardInfo.getParentCardAccountNo());
//			assertEquals(null, cardInfo.getInternalNo());
//			assertEquals(cardDO.getCardType(), cardInfo.getCardType().code());
//			assertEquals(cardDO.getTag(), cardInfo.getTag().code());
//			assertEquals(cardDO.getAccountTag(), cardInfo.getAccountTag());
//			assertEquals(cardDO.getStatus(), cardInfo.getStatus().code());
//		}
//		assertEquals(accountDO.getAccountNo(),cardInfo.getAccountNo());
//		assertEquals(accountDO.getUserId(),cardInfo.getUserId());
//		assertEquals(order.getPartnerId(),cardInfo.getPartnerId());
//		assertEquals(order.getCardNo(),cardInfo.getCardNo());
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserCardInfoTestFailOne.csv")
//	@DisplayName("根据商户id和卡号获取查询用户信息及卡信息--参数非法")
//	public void queryUserServiceQueryUserCardInfoTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QueryUserCardOrder order
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
//			order.setCardNo(null);
//		}
//		// 调用接口
//		CardQueryResult result = queryUserService.queryUserCardInfo(order);
//		// 结果验证
//		print(result);
//		assertEquals(Status.FAIL, result.getStatus());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserCardInfoTestFailTwo.csv")
//	@DisplayName("根据商户id和卡号获取查询用户信息及卡信息--失败用例")
//	public void queryUserServiceQueryUserCardInfoTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QueryUserCardOrder order,
//			// 预置参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserCardInfoDO cardDO,
//			UserCardInfoDO cardDO1,
//			UserCarInfoDO carInfoDO,
//			UserDO userDO,
//			AccountDO accountDO,
//			PointsDO pointsDO
//	) {
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		// 准备数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		// 准备数据
//		if (testId != 1003) {
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		//虚拟卡
//		gasUserTestBase.insertUserCardInfo(cardDO);
//		//实体卡
//		if (testId != 1001) {
//			gasUserTestBase.insertUserCardInfo(cardDO1);
//		}
//		//加好油会员车辆信息
//		gasUserTestBase.insertUserCarInfo(carInfoDO);
//		//清结算会员
//		if (testId != 1001) {
//			userTestBase.insertUser(userDO);
//		}
//		//清结算资金账户
//		if (testId != 1002) {
//			userTestBase.insertAccount(accountDO);
//		}
//		//积分
//		promotionTestBase.insertPoints(pointsDO);
//		if (testId == 1002) {
//		}
//		// 测试过程
//		// 调用接口
//		CardQueryResult result = queryUserService.queryUserCardInfo(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//
//		// 清除数据
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserTestBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//	}
//}
