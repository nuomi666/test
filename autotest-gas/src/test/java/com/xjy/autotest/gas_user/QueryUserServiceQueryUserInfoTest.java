//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.user.api.QueryUserService;
//import com.xyb.gas.user.api.order.QuerySingleUserOrder;
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
//public class QueryUserServiceQueryUserInfoTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    QueryUserService queryUserService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserBase;
//
//	@Autowired
//	PromotionTestBase promotionTestBase;
//	/**
//	 * 该接口返回的卡号为用户的实体卡卡号，有可能为空
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserInfoTestSuccess.csv")
//	@DisplayName("根据用户id查询用户信息--成功用例")
//	public void queryUserServiceQueryUserInfoTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QuerySingleUserOrder order,
//			//数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserCardInfoDO cardDO,
//			UserCardInfoDO cardDO1,
//			UserCarInfoDO carInfoDO,
//			UserDO userDO,
//			AccountDO accountDO,
//			PointsDO pointsDO
//	) {
//		// 清除数据
//		gasUserBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		// 准备数据
//		gasUserBase.insertUser(jhyUserDO);
//		//虚拟卡
//		gasUserBase.insertUserCardInfo(cardDO);
//		//实体卡
//		if (testId != 1001) {
//			gasUserBase.insertUserCardInfo(cardDO1);
//		}
//		//加好油会员车辆信息
//		gasUserBase.insertUserCarInfo(carInfoDO);
//		//清结算会员
//		userTestBase.insertUser(userDO);
//		//清结算资金账户
//		userTestBase.insertAccount(accountDO);
//		//积分
//		promotionTestBase.insertPoints(pointsDO);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		BizResult<UserInfo> result = queryUserService.queryUserInfo(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		UserInfo info = result.getInfo();
//		assertEquals(order.getUserId(), info.getUserId());
//		assertEquals(userDO.getPartnerId(), info.getPartnerId());
//		assertEquals(jhyUserDO.getMobile(), info.getMobile());
//		assertEquals(userDO.getRealName(), info.getRealName());
//		assertEquals(jhyUserDO.getBirthday(), info.getBirthday());
//		assertEquals(jhyUserDO.getNickName(), info.getNickName());
//		assertEquals(jhyUserDO.getHeadImgUrl(), info.getHeadImgUrl());
//		assertEquals(jhyUserDO.getSex(), info.getSex().code());
//		assertEquals(carInfoDO.getCarNumber(), info.getCarNumber());
//		assertEquals(jhyUserDO.getMemberType(), info.getMemberType().code());
//		assertEquals(jhyUserDO.getPayed(), String.valueOf(info.isPayed()));
//		assertEquals(jhyUserDO.getGrade(), info.getGrade().code());
//		if (testId == 1001) {
//			assertEquals(null, info.getCardNo());
//		} else {
//			assertEquals(cardDO1.getCardNo(), info.getCardNo());
//		}
//		assertEquals(accountDO.getAccountNo(), info.getAccountNo());
//		assertEquals(Money.cent(accountDO.getBalance()), info.getBalance());
//		assertEquals(pointsDO.getPoints(), info.getPoints());
//		// 清除数据
//		gasUserBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//	}
//
//	/**
//	 * 该接口返回的卡号为用户的实体卡卡号，有可能为空
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserInfoTestFailOne.csv")
//	@DisplayName("根据用户id查询用户信息--参数非法")
//	public void queryUserServiceQueryUserInfoTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QuerySingleUserOrder order
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		order.setGid(GID.newGID());
//		if (testId == 1001) {
//			order = null;
//		}
//		if (testId == 1002) {
//			order.setGid(null);
//		}
//		if (testId == 1003) {
//			order.setUserId(null);
//		}
//		// 调用接口
//		BizResult<UserInfo> result = queryUserService.queryUserInfo(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 该接口返回的卡号为用户的实体卡卡号，有可能为空
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserInfoTestFailTwo.csv")
//	@DisplayName("根据用户id查询用户信息--失败用例")
//	public void queryUserServiceQueryUserInfoTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QuerySingleUserOrder order,
//			//数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserCardInfoDO cardDO,
//			UserCardInfoDO cardDO1,
//			UserCarInfoDO carInfoDO,
//			UserDO userDO,
//			AccountDO accountDO,
//			PointsDO pointsDO
//	) {
//		// 清除数据
//		gasUserBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		// 准备数据
//		if (testId != 1003) {
//			gasUserBase.insertUser(jhyUserDO);
//		}
//		//虚拟卡
//		gasUserBase.insertUserCardInfo(cardDO);
//		//实体卡
//		if (testId != 1001) {
//			gasUserBase.insertUserCardInfo(cardDO1);
//		}
//		//加好油会员车辆信息
//		gasUserBase.insertUserCarInfo(carInfoDO);
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
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		BizResult<UserInfo> result = queryUserService.queryUserInfo(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//		gasUserBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//	}
//}
