//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.PagedResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.user.api.QueryUserService;
//import com.xyb.gas.user.api.order.QueryAllMerchantUserOrder;
//import com.xyb.gas.user.api.result.info.UserInfo;
//import dal.model.gas_user.UserCarInfoDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/26.
// */
//public class QueryUserServiceQueryAllMerchantUserTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
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
//
//	/**
//	 * 查询90天以内的数据
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryAllMerchantUserTestSuccess.csv")
//	@DisplayName("根据商户id分页查询该商户下的用户列表--成功用例")
//	public void queryUserServiceQueryAllMerchantUserTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			QueryAllMerchantUserOrder order,
//			//数据库参数
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserCardInfoDO cardDO,
//			UserCardInfoDO cardDO1,
//			UserCarInfoDO carInfoDO,
//			UserDO userDO,
//			AccountDO accountDO,
//			PointsDO pointsDO,
//			dal.model.gas_user.UserDO jhyUserDO1,
//			UserCardInfoDO cardDO2,
//			UserCardInfoDO cardDO3,
//			UserCarInfoDO carInfoDO1,
//			UserDO userDO1,
//			AccountDO accountDO1,
//			PointsDO pointsDO1,
//			dal.model.gas_user.UserDO jhyUserDO2,
//			UserCardInfoDO cardDO4,
//			UserCarInfoDO carInfoDO2,
//			UserDO userDO2,
//			AccountDO accountDO2,
//			PointsDO pointsDO2
//	) {
//		// 清除数据
//		gasUserBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		gasUserBase.cleanUserByUserId(jhyUserDO1.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO2.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO3.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO1.getUserId());
//		userTestBase.cleanUserByUserId(userDO1.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO1.getUserId());
//		gasUserBase.cleanUserByUserId(jhyUserDO2.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO4.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO2.getUserId());
//		userTestBase.cleanUserByUserId(userDO2.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO2.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO2.getUserId());
//		// 准备数据
//		//第一个用户
//		gasUserBase.insertUser(jhyUserDO);
//		//虚拟卡
//		gasUserBase.insertUserCardInfo(cardDO);
//		//实体卡
//		gasUserBase.insertUserCardInfo(cardDO1);
//		gasUserBase.insertUserCarInfo(carInfoDO);
//		userTestBase.insertUser(userDO);
//		userTestBase.insertAccount(accountDO);
//		promotionTestBase.insertPoints(pointsDO);
//		//第二个用户
//		gasUserBase.insertUser(jhyUserDO1);
//		//虚拟卡
//		gasUserBase.insertUserCardInfo(cardDO2);
//		//实体卡
//		gasUserBase.insertUserCardInfo(cardDO3);
//		gasUserBase.insertUserCarInfo(carInfoDO1);
//		userTestBase.insertUser(userDO1);
//		userTestBase.insertAccount(accountDO1);
//		promotionTestBase.insertPoints(pointsDO1);
//		//第三个用户
//		gasUserBase.insertUser(jhyUserDO2);
//		//虚拟卡
//		gasUserBase.insertUserCardInfo(cardDO4);
//		gasUserBase.insertUserCarInfo(carInfoDO2);
//		userTestBase.insertUser(userDO2);
//		userTestBase.insertAccount(accountDO2);
//		promotionTestBase.insertPoints(pointsDO2);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		PagedResult<UserInfo> result = queryUserService.queryAllMerchantUser(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////		assertEquals(code, result.getCode());
//		// 数据验证
//		if (testId <= 1004) {
//			assertEquals(3l, result.getTotalCount());
//		}
//		assertEquals(order.getPageNo(), result.getPageInfo().getPageNo());
//		assertEquals(order.getPageSize(), result.getPageInfo().getPageSize());
////		assertEquals(order.getPageSize(), result.getPageInfo().getTotalPage());
//		if (testId == 1005) {
//			assertEquals(1l, result.getPageInfo().getTotalCount());
//		} else {
//			assertEquals(3l, result.getPageInfo().getTotalCount());
//		}
//		List<UserInfo> userInfos = result.getInfoList();
//		//注册时间倒序排列
//		if (testId == 1005) {//一条数据
//			assertTrue(userInfos.size() == 1);
//			assertEquals(userDO.getUserId(), userInfos.get(0).getUserId());
//			assertEquals(userDO.getPartnerId(), userInfos.get(0).getPartnerId());
//			assertEquals(jhyUserDO.getMobile(), userInfos.get(0).getMobile());
//			assertEquals(userDO.getRealName(), userInfos.get(0).getRealName());
//			assertEquals(jhyUserDO.getBirthday(), userInfos.get(0).getBirthday());
//			assertEquals(jhyUserDO.getNickName(), userInfos.get(0).getNickName());
//			assertEquals(jhyUserDO.getRealName(), userInfos.get(0).getRealName());
//			assertEquals(jhyUserDO.getHeadImgUrl(), userInfos.get(0).getHeadImgUrl());
//			assertEquals(jhyUserDO.getSex(), userInfos.get(0).getSex().code());
//			assertEquals(carInfoDO.getCarNumber(), userInfos.get(0).getCarNumber());
//			assertEquals(jhyUserDO.getMemberType(), userInfos.get(0).getMemberType().code());
//			assertEquals(jhyUserDO.getPayed(), String.valueOf(userInfos.get(0).isPayed()));
//			assertEquals(jhyUserDO.getGrade(), userInfos.get(0).getGrade().code());
//			assertEquals(cardDO1.getCardNo(), userInfos.get(0).getCardNo());
//			assertEquals(accountDO.getAccountNo(), userInfos.get(0).getAccountNo());
//			assertEquals(Money.cent(accountDO.getBalance()), userInfos.get(0).getBalance());
//			assertEquals(pointsDO.getPoints().intValue(), userInfos.get(0).getPoints());
//		} else if (testId == 1002) {//3条数据，每页显示1条，第2页
//			assertTrue(userInfos.size() == 1);
//			assertEquals(userDO1.getUserId(), userInfos.get(0).getUserId());
//			assertEquals(userDO1.getPartnerId(), userInfos.get(0).getPartnerId());
//			assertEquals(jhyUserDO1.getMobile(), userInfos.get(0).getMobile());
//			assertEquals(userDO1.getRealName(), userInfos.get(0).getRealName());
//			assertEquals(jhyUserDO1.getBirthday(), userInfos.get(0).getBirthday());
//			assertEquals(jhyUserDO1.getNickName(), userInfos.get(0).getNickName());
//			assertEquals(jhyUserDO1.getHeadImgUrl(), userInfos.get(0).getHeadImgUrl());
//			assertEquals(jhyUserDO1.getSex(), userInfos.get(0).getSex().code());
//			assertEquals(carInfoDO1.getCarNumber(), userInfos.get(0).getCarNumber());
//			assertEquals(jhyUserDO1.getMemberType(), userInfos.get(0).getMemberType().code());
//			assertEquals(jhyUserDO1.getPayed(), String.valueOf(userInfos.get(0).isPayed()));
//			assertEquals(jhyUserDO1.getGrade(), userInfos.get(0).getGrade().code());
//			assertEquals(cardDO3.getCardNo(), userInfos.get(0).getCardNo());
//			assertEquals(accountDO1.getAccountNo(), userInfos.get(0).getAccountNo());
//			assertEquals(Money.cent(accountDO1.getBalance()), userInfos.get(0).getBalance());
//			assertEquals(pointsDO1.getPoints().intValue(), userInfos.get(0).getPoints());
//		} else if (testId == 1003) {//3条数据，每页显示2条，第1页
//			assertTrue(userInfos.size() == 2);
//			assertEquals(userDO2.getUserId(), userInfos.get(0).getUserId());
//			assertEquals(userDO2.getPartnerId(), userInfos.get(0).getPartnerId());
//			assertEquals(jhyUserDO2.getMobile(), userInfos.get(0).getMobile());
//			assertEquals(userDO2.getRealName(), userInfos.get(0).getRealName());
//			assertEquals(jhyUserDO2.getBirthday(), userInfos.get(0).getBirthday());
//			assertEquals(jhyUserDO2.getNickName(), userInfos.get(0).getNickName());
//			assertEquals(jhyUserDO2.getHeadImgUrl(), userInfos.get(0).getHeadImgUrl());
//			assertEquals(jhyUserDO2.getSex(), userInfos.get(0).getSex().code());
//			assertEquals(carInfoDO2.getCarNumber(), userInfos.get(0).getCarNumber());
//			assertEquals(jhyUserDO2.getMemberType(), userInfos.get(0).getMemberType().code());
//			assertEquals(jhyUserDO2.getPayed(), String.valueOf(userInfos.get(0).isPayed()));
//			assertEquals(jhyUserDO2.getGrade(), userInfos.get(0).getGrade().code());
//			assertEquals(null, userInfos.get(0).getCardNo());
//			assertEquals(accountDO2.getAccountNo(), userInfos.get(0).getAccountNo());
//			assertEquals(Money.cent(accountDO2.getBalance()), userInfos.get(0).getBalance());
//			assertEquals(pointsDO2.getPoints().intValue(), userInfos.get(0).getPoints());
//
//			assertEquals(userDO1.getUserId(), userInfos.get(1).getUserId());
//			assertEquals(userDO1.getPartnerId(), userInfos.get(1).getPartnerId());
//			assertEquals(jhyUserDO1.getMobile(), userInfos.get(1).getMobile());
//			assertEquals(userDO1.getRealName(), userInfos.get(1).getRealName());
//			assertEquals(jhyUserDO1.getBirthday(), userInfos.get(1).getBirthday());
//			assertEquals(jhyUserDO1.getNickName(), userInfos.get(1).getNickName());
//			assertEquals(jhyUserDO1.getHeadImgUrl(), userInfos.get(1).getHeadImgUrl());
//			assertEquals(jhyUserDO1.getSex(), userInfos.get(1).getSex().code());
//			assertEquals(carInfoDO1.getCarNumber(), userInfos.get(1).getCarNumber());
//			assertEquals(jhyUserDO1.getMemberType(), userInfos.get(1).getMemberType().code());
//			assertEquals(jhyUserDO1.getPayed(), String.valueOf(userInfos.get(1).isPayed()));
//			assertEquals(jhyUserDO1.getGrade(), userInfos.get(1).getGrade().code());
//			assertEquals(cardDO3.getCardNo(), userInfos.get(1).getCardNo());
//			assertEquals(accountDO1.getAccountNo(), userInfos.get(1).getAccountNo());
//			assertEquals(Money.cent(accountDO1.getBalance()), userInfos.get(1).getBalance());
//			assertEquals(pointsDO1.getPoints().intValue(), userInfos.get(1).getPoints());
//		} else {//3条数据，每页显示10条，第1页
//			assertTrue(userInfos.size() == 3);
//			assertEquals(userDO2.getUserId(), userInfos.get(0).getUserId());
//			assertEquals(userDO2.getPartnerId(), userInfos.get(0).getPartnerId());
//			assertEquals(jhyUserDO2.getMobile(), userInfos.get(0).getMobile());
//			assertEquals(userDO2.getRealName(), userInfos.get(0).getRealName());
//			assertEquals(jhyUserDO2.getBirthday(), userInfos.get(0).getBirthday());
//			assertEquals(jhyUserDO2.getNickName(), userInfos.get(0).getNickName());
//			assertEquals(jhyUserDO2.getHeadImgUrl(), userInfos.get(0).getHeadImgUrl());
//			assertEquals(jhyUserDO2.getSex(), userInfos.get(0).getSex().code());
//			assertEquals(carInfoDO2.getCarNumber(), userInfos.get(0).getCarNumber());
//			assertEquals(jhyUserDO2.getMemberType(), userInfos.get(0).getMemberType().code());
//			assertEquals(jhyUserDO2.getPayed(), String.valueOf(userInfos.get(0).isPayed()));
//			assertEquals(jhyUserDO2.getGrade(), userInfos.get(0).getGrade().code());
//			assertEquals(null, userInfos.get(0).getCardNo());
//			assertEquals(accountDO2.getAccountNo(), userInfos.get(0).getAccountNo());
//			assertEquals(Money.cent(accountDO2.getBalance()), userInfos.get(0).getBalance());
//			assertEquals(pointsDO2.getPoints().intValue(), userInfos.get(0).getPoints());
//
//			assertEquals(userDO1.getUserId(), userInfos.get(1).getUserId());
//			assertEquals(userDO1.getPartnerId(), userInfos.get(1).getPartnerId());
//			assertEquals(jhyUserDO1.getMobile(), userInfos.get(1).getMobile());
//			assertEquals(userDO1.getRealName(), userInfos.get(1).getRealName());
//			assertEquals(jhyUserDO1.getBirthday(), userInfos.get(1).getBirthday());
//			assertEquals(jhyUserDO1.getNickName(), userInfos.get(1).getNickName());
//			assertEquals(jhyUserDO1.getHeadImgUrl(), userInfos.get(1).getHeadImgUrl());
//			assertEquals(jhyUserDO1.getSex(), userInfos.get(1).getSex().code());
//			assertEquals(carInfoDO1.getCarNumber(), userInfos.get(1).getCarNumber());
//			assertEquals(jhyUserDO1.getMemberType(), userInfos.get(1).getMemberType().code());
//			assertEquals(jhyUserDO1.getPayed(), String.valueOf(userInfos.get(1).isPayed()));
//			assertEquals(jhyUserDO1.getGrade(), userInfos.get(1).getGrade().code());
//			assertEquals(cardDO3.getCardNo(), userInfos.get(1).getCardNo());
//			assertEquals(accountDO1.getAccountNo(), userInfos.get(1).getAccountNo());
//			assertEquals(Money.cent(accountDO1.getBalance()), userInfos.get(1).getBalance());
//			assertEquals(pointsDO1.getPoints().intValue(), userInfos.get(1).getPoints());
//
//			assertEquals(userDO.getUserId(), userInfos.get(2).getUserId());
//			assertEquals(userDO.getPartnerId(), userInfos.get(2).getPartnerId());
//			assertEquals(jhyUserDO.getMobile(), userInfos.get(2).getMobile());
//			assertEquals(userDO.getRealName(), userInfos.get(2).getRealName());
//			assertEquals(jhyUserDO.getBirthday(), userInfos.get(2).getBirthday());
//			assertEquals(jhyUserDO.getNickName(), userInfos.get(2).getNickName());
//			assertEquals(jhyUserDO.getHeadImgUrl(), userInfos.get(2).getHeadImgUrl());
//			assertEquals(jhyUserDO.getSex(), userInfos.get(2).getSex().code());
//			assertEquals(carInfoDO.getCarNumber(), userInfos.get(2).getCarNumber());
//			assertEquals(jhyUserDO.getMemberType(), userInfos.get(2).getMemberType().code());
//			assertEquals(jhyUserDO.getPayed(), String.valueOf(userInfos.get(2).isPayed()));
//			assertEquals(jhyUserDO.getGrade(), userInfos.get(2).getGrade().code());
//			assertEquals(cardDO1.getCardNo(), userInfos.get(2).getCardNo());
//			assertEquals(accountDO.getAccountNo(), userInfos.get(2).getAccountNo());
//			assertEquals(Money.cent(accountDO.getBalance()), userInfos.get(2).getBalance());
//			assertEquals(pointsDO.getPoints().intValue(), userInfos.get(2).getPoints());
//		}
//		// 清除数据
//		gasUserBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO1.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//		gasUserBase.cleanUserByUserId(jhyUserDO1.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO2.getCardNo());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO3.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO1.getUserId());
//		userTestBase.cleanUserByUserId(userDO1.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO1.getUserId());
//		gasUserBase.cleanUserByUserId(jhyUserDO2.getUserId());
//		gasUserBase.cleanUserCardInfoByCardNo(cardDO4.getCardNo());
//		gasUserBase.cleanUserCarInfoByUserId(carInfoDO2.getUserId());
//		userTestBase.cleanUserByUserId(userDO2.getUserId());
//		userTestBase.cleanAccountByUserId(accountDO2.getUserId());
//		promotionTestBase.cleanPointsByUserId(pointsDO2.getUserId());
//	}
//}
