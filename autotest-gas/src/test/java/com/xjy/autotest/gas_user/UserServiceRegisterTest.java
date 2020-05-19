//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.enums.*;
//import com.xyb.gas.user.api.order.RegisterOrder;
//import com.xyb.gas.user.api.result.RegisterUserResult;
//import com.xyb.promotion.api.coupon.enums.CouponStatus;
//import com.xyb.promotion.api.coupon.enums.CouponType;
//import com.xyb.user.api.enums.AccountType;
//import com.xyb.user.api.enums.RegisterFrom;
//import com.xyb.user.api.enums.UserType;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_merchant.GasMerchantUserStationDO;
//import dal.model.gas_user.UserCarInfoDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserPayToolInfoDO;
//import dal.model.promotion.CouponDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceRegisterTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserService userService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	PromotionTestBase promotionTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	@Autowired
//	private StringRedisTemplate redisTemplate;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceRegisterTestSuccess.csv")
//	@DisplayName("注册用户--成功用例")
//	public void userServiceRegisterTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			RegisterOrder order,
//			//预置参数
//			dal.model.user.UserDO userDO,
//			UserPayToolInfoDO userPayToolInfoDO,
//			UserDO gasUserDO,
//			GasMerchantUserDO gasMerchantUserDO
//	) {
//		// 清除数据
//		String merchantUserId=order.getPartnerId() + "-" + order.getMobile();
//		userTestBase.cleanUserByUserId(userDO.getUserId());
////		userTestBase.cleanUserByPartnerId(order.getPartnerId());
////		gasUserTestBase.cleanUserBym
//		gasUserTestBase.cleanUserPayToolInfoByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasUserTestBase.cleanUserCarInfoByCarNumber(order.getCarNumber());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
//		// 准备数据
//        String key="gas-user:"+order.getPartnerId() + order.getMobile();
//		redisTemplate.opsForValue().set(key,order.getSmsValidateCode());
//		userDO.setMobile(order.getMobile());
//		userTestBase.insertUser(userDO);
//		userPayToolInfoDO.setOpenId(order.getOpenId());
//		userPayToolInfoDO.setPartnerId(order.getPartnerId());
////		if(testId==1003){//现在一个微信在一个商家下绑定了就不能变了
////			gasUserTestBase.insertUserPayToolInfo(userPayToolInfoDO);
////		}
//		gasUserTestBase.insertUser(gasUserDO);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDO);
//		//油站信息
//		GasMerchantUserStationDO gasMerchantUserStationDO=new GasMerchantUserStationDO();
//		gasMerchantUserStationDO.setStationId("001if9yazl84g025eh00");
//		gasMerchantUserStationDO.setUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.insertGasMerchantUserStation(gasMerchantUserStationDO);
//		// 测试过程
//		if(testId==1001){
//			order.setBirthday(null);
//			order.setHeadImgUrl(null);
//			order.setNickName(null);
//			order.setRealName(null);
//			order.setSex(null);
//			order.setCarNumber(null);
//		}
//		// 调用接口
//		RegisterUserResult result = userService.register(order);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS,code,result);
//		//assertEquals(description,result.getDescription());
//		// 数据验证
////		gasUserTestBase.cleanUserCardInfoByUserId(result.getUserId());
////		gasUserTestBase.cleanUserByUserId(result.getUserId());
////		userTestBase.cleanUserByUserId(result.getUserId());
////		userTestBase.cleanAccountByUserId(result.getUserId());
////		promotionTestBase.cleanPointsByUserId(result.getUserId());
////		promotionTestBase.cleanCouponByUserId(result.getUserId());
//		//清结算会员信息
//		dal.model.user.UserDO userInfo = userTestBase.findUserByUserId(result.getUserId()).get(0);
//			assertEquals(order.getPartnerId(),userInfo.getPartnerId());
//			assertEquals(null,userInfo.getMerchantUserId());
//			assertEquals(RegisterFrom.INSIDE.code(),userInfo.getRegisterFrom());
//			assertEquals(UserType.PERSONAL.code(),userInfo.getUserType());
//			assertEquals(order.getMobile(),userInfo.getMobile());
//			assertEquals(userDO.getUserId(),userInfo.getParentUserId());
//			if(testId==1001){
//				assertEquals(null,userInfo.getRealName());
//			}else {
//				assertEquals(order.getRealName(),userInfo.getRealName());
//			}
//			assertEquals(null,userInfo.getPayPassword());
//			assertEquals(null,userInfo.getAddress());
//			assertEquals(null,userInfo.getCertNo());
//			assertEquals(null,userInfo.getCertType());
//			assertEquals(null,userInfo.getCity());
//			assertEquals(null,userInfo.getCountry());
//			assertEquals(null,userInfo.getDistrict());
//			assertEquals(null,userInfo.getPhone());
//			assertEquals(null,userInfo.getProvince());
//			assertEquals(null,userInfo.getRegisterIp());
//			assertEquals(null,userInfo.getZipCode());
//			assertEquals(null,userInfo.getMemo());
//
//			//xyb账户信息
//			List<AccountDO> accountInfos=userTestBase.findAccountByUserId(userInfo.getUserId());
//			assertTrue(accountInfos.size()>0);
//			String accountNo=accountInfos.get(0).getAccountNo();
//			for(AccountDO accountInfo:accountInfos){
//				assertEquals(new Long(0),accountInfo.getHisOutAmount());
//				assertEquals(new Long(0),accountInfo.getHisInAmount());
//				assertEquals(new Long(0),accountInfo.getBalance());
//				assertEquals(new Long(0),accountInfo.getFreezeBalance());
//				assertEquals(AccountType.NORMAL.toString(),accountInfo.getAccountType());
//			}
//			//jhy用户信息
//		List<UserDO> jhyUserInfos = gasUserTestBase.findUserByUserId(result.getUserId());
//			assertTrue(jhyUserInfos.size()>0);
//			for(UserDO jhyUserInfo:jhyUserInfos){
//				assertEquals(order.getPartnerId(),jhyUserInfo.getPartnerId());
//				assertEquals(order.getMobile(),jhyUserInfo.getMobile());
//				assertEquals(MemberType.NORMAL.code(),jhyUserInfo.getMemberType());
//				assertEquals("false",jhyUserInfo.getPayed());
//				assertEquals(UserGrade.GRADE_COMMON.code(), jhyUserInfo.getGrade());
//				if(testId==1003){
////					assertEquals(order.getSource().code(), jhyUserInfo.getSource());
////					assertEquals(order.getRecommendId(), jhyUserInfo.getRecommendId());
//					assertEquals(gasUserDO.getMobile(), jhyUserInfo.getRecommendMobile());
//				}else if(testId==1004){
////					assertEquals(order.getSource().code(), jhyUserInfo.getSource());
////					assertEquals(order.getRecommendId(), jhyUserInfo.getRecommendId());
//					assertEquals(gasMerchantUserDO.getMobileNo(), jhyUserInfo.getRecommendMobile());
//				}else {
////					assertEquals(order.getSource().code(), jhyUserInfo.getSource());
//					assertEquals(null, jhyUserInfo.getRecommendId());
//					assertEquals(null, jhyUserInfo.getRecommendMobile());
//				}
//				if(testId==1001){
//					assertEquals(null,jhyUserInfo.getBirthday());
//					assertEquals(null,jhyUserInfo.getNickName());
//					assertEquals(null,jhyUserInfo.getHeadImgUrl());
//					assertEquals(null,jhyUserInfo.getSex());
//				}else {
//					assertEquals(order.getBirthday(),jhyUserInfo.getBirthday());
//					assertEquals(order.getNickName(),jhyUserInfo.getNickName());
//					assertEquals(order.getHeadImgUrl(),jhyUserInfo.getHeadImgUrl());
//					assertEquals(order.getSex().code(),jhyUserInfo.getSex());
//				}
//			}
//		List<UserPayToolInfoDO> userPayToolInfos = gasUserTestBase.findUserPayToolInfoByUserId(result.getUserId());
//			assertTrue(userPayToolInfos.size()>0);
//			for(UserPayToolInfoDO userPayToolInfo:userPayToolInfos){
//				assertEquals(order.getPartnerId(),userPayToolInfo.getPartnerId());
//				assertEquals(order.getOpenId(),userPayToolInfo.getOpenId());
//				assertEquals(order.getType().code(),userPayToolInfo.getType());
////				if(testId==1003){
////					assertEquals(userPayToolInfoDO.getRawAddTime(),userPayToolInfo.getRawAddTime());
////					assertNotEquals(userPayToolInfoDO.getRawUpdateTime(),userPayToolInfo.getRawUpdateTime());
////				}
//			}
//			//jhy卡信息
//		List<UserCardInfoDO> userCardInfoDOs = gasUserTestBase.findUserCardInfoByUserId(result.getUserId());
//			assertTrue(userCardInfoDOs.size()>0);
//			for(UserCardInfoDO userCardInfoDO:userCardInfoDOs){
//				assertEquals(order.getPartnerId(),userCardInfoDO.getPartnerId());
//				assertEquals(accountNo,userCardInfoDO.getCardNo());
//				assertEquals(null,userCardInfoDO.getInternalNo());
//				assertEquals(null,userCardInfoDO.getParentCardAccountNo());
//				assertEquals(CardType.DUMMY.code(),userCardInfoDO.getCardType());
//				assertEquals(CardBizType.DEFAULT.code(),userCardInfoDO.getTag());
//				assertEquals(accountNo,userCardInfoDO.getAccountNo());
//				assertEquals(CardStatus.NORMAL.code(),userCardInfoDO.getStatus());
//			}
//		//车信息
//		List<UserCarInfoDO> carInfos=gasUserTestBase.findUserCarInfoByUserId(result.getUserId());
//			if(testId!=1001) {
//				assertTrue(carInfos.size() > 0);
//				for (UserCarInfoDO carInfo : carInfos) {
//					assertEquals(result.getUserId(), carInfo.getUserId());
//					assertEquals(order.getCarNumber(), carInfo.getCarNumber());
//				}
//			}
//		//赠送信息
//		//券（营销创建的信息，具体看活动商家配的是什么就送的什么）
////		CouponDO coupon = promotionTestBase.findCouponByUserId(result.getUserId()).get(0);
////		assertEquals("001im3f3tzu4s107pr00", coupon.getDefinitionId());
////		assertEquals("满100减5元", coupon.getName());
////		assertEquals(order.getPartnerId(), coupon.getPartnerId());
////		assertEquals("S0301806081400000015", coupon.getPlatPartnerId());
////		assertEquals(CouponType.OVER.toString(), coupon.getCouponType());
////		assertEquals(CouponStatus.TAKEN.toString(), coupon.getStatus());
////		//积分
////		PointsDO points = promotionTestBase.findPointsByUserId(result.getUserId()).get(0);
////		assertEquals(order.getPartnerId(), points.getPartnerId());
////		assertEquals("S0301806081400000015", points.getPlatPartnerId());
////		assertEquals(10L, points.getPoints());
////		assertEquals(null, points.getHistorySubtractPoints());
////		assertEquals(10L, points.getHistoryAddPoints());
//		// 清除数据
//		redisTemplate.delete(key);
//		gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
//		if(testId!=1001) {
//			gasUserTestBase.cleanUserByUserId(result.getUserId());
//			userTestBase.cleanUserByUserId(result.getUserId());
//			userTestBase.cleanAccountByUserId(result.getUserId());
//			promotionTestBase.cleanPointsByUserId(result.getUserId());
//			promotionTestBase.cleanCouponByUserId(result.getUserId());
//			gasUserTestBase.cleanUserPayToolInfoByUserId(result.getUserId());
//			gasUserTestBase.cleanUserCardInfoByUserId(result.getUserId());
//			gasUserTestBase.cleanUserCarInfoByUserId(result.getUserId());
//		}
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceRegisterTestFailOne.csv")
//	@DisplayName("注册商户--参数非法")
//	public void userServiceRegisterTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			RegisterOrder order,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId==1001){
//			order.setMobile(null);
//		}
//		if(testId==1002){
//			order.setPartnerId(null);
//		}
//		if(testId==1003){
//			order.setOpenId(null);
//		}
//		if(testId==1004){
//			order.setGid(null);
//		}
//		if(testId==1005){
//			order=null;
//		}
//		// 调用接口
//		SimpleResult result = userService.register(order);
//		// 结果验证
//		assertResult(testId,Status.FAIL,code,result);
//		assertEquals(description,result.getMessage());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceRegisterTestFailTwo.csv")
//	@DisplayName("注册商户--失败用例")
//	public void userServiceRegisterTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			RegisterOrder order,
//			//预置参数
//			UserDO jhyUserDO,
//			dal.model.user.UserDO userDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		String merchantUserId=order.getPartnerId() + "-" + order.getMobile();
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		userTestBase.cleanUserByPartnerId(order.getPartnerId());
////		gasUserTestBase.cleanUserByPartnerIdAndMobile(order.getPartnerId(), order.getMobile());
////		gasUserTestBase.cleanUserPayToolInfoByPartnerIdAndOpenId(order.getPartnerId(), order.getOpenId());
//		// 准备数据
//		String key="gas-user:"+order.getPartnerId() + order.getMobile();
////		if(testId==1001) {
////			redisTemplate.opsForValue().set(order.getPartnerId() + order.getMobile(), order.getSmsValidateCode());
////		}
////		if(testId==1002) {
////			redisTemplate.opsForValue().set(key, "5648");
////		}
//		if(testId!=1003) {
//			userTestBase.insertUser(userDO);
//		}
//		if(testId==1004) {
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		if(testId>1002){
//			order.setSmsValidateCode(null);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.register(order);
//		// 结果验证
//		assertResult(testId,Status.FAIL,code,result);
//		assertEquals(message,result.getMessage());
//		// 数据验证
//		// 清除数据
////        redisTemplate.delete(order.getPartnerId() + order.getMobile());
////        redisTemplate.delete(key);
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//	}
//}
