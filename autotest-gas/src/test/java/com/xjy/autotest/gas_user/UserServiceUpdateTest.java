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
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.UserUpdateOrder;
//import com.xyb.promotion.api.coupon.enums.CouponStatus;
//import com.xyb.promotion.api.coupon.enums.CouponType;
//import dal.model.gas_user.UserCarInfoDO;
//import dal.model.promotion.CouponDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/14.
// */
//public class UserServiceUpdateTest extends SpringBootTestBase{
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
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceUpdateTestSuccess.csv")
//	@DisplayName("更新用户信息--成功用例")
//	public void userServiceUpdateTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			UserUpdateOrder order,
//			// 会员
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserDO userDO,
//			//车
//			UserCarInfoDO carInfoDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		gasUserTestBase.cleanUserCarInfoByCarNumber(order.getCarNumber());
//		promotionTestBase.cleanPointsByUserId(userDO.getUserId());
//		promotionTestBase.cleanCouponByUserId(userDO.getUserId());
//		// 准备数据
//		userTestBase.insertUser(userDO);
//		if(testId==1003){
//			jhyUserDO.setBirthday(null);
//		}
//		if (testId == 1004) {
//			userDO.setRealName(null);
//		}
//		if (testId == 1005) {
//			jhyUserDO.setSex(null);
//		}
//		if(testId==1007){
//			carInfoDO.setCarNumber(order.getCarNumber());
//		}
//		gasUserTestBase.insertUser(jhyUserDO);
//		if(testId==1006||testId==1007) {
//			gasUserTestBase.insertUserCarInfo(carInfoDO);
//		}
//		PointsDO pointsDO = new PointsDO();
//		pointsDO.setPartnerId(userDO.getPartnerId());
//		pointsDO.setPlatPartnerId("S0301806081400000015");
//		pointsDO.setUserId(userDO.getUserId());
//		pointsDO.setPoints(10L);
//		pointsDO.setHistoryAddPoints(10L);
//		pointsDO.setHistorySubtractPoints(0L);
//		pointsDO.setPointId(OID.newID());
//		pointsDO.setRawAddTime(DateUtils.getSqlDate());
//		pointsDO.setRawUpdateTime(DateUtils.getSqlDate());
//		promotionTestBase.insertPoints(pointsDO);
//		PointsDO points = promotionTestBase.findPointsByUserId(userDO.getUserId()).get(0);
//		// 测试过程
//		if(testId==1001){
//			order.setBirthday(null);
//			order.setCarNumber(null);
//			order.setHeadImgUrl(null);
//			order.setNickName(null);
//			order.setRealName(null);
//			order.setSex(null);
//		}
//		if(testId==1002){
//			order.setBirthday(null);
//			order.setCarNumber(null);
//			order.setHeadImgUrl(null);
//			order.setNickName(null);
//			order.setRealName(null);
//			order.setSex(null);
//		}
//		// 调用接口
//		SimpleResult result = userService.update(order);
//		// 结果验证
//		print(result);
//		assertResult(testId, Status.SUCCESS,code,result);
//		//assertEquals(message,result.getDescription());
//		sleep(3);
//		// 数据验证
//		UserDO userInfo=userTestBase.findUserByUserId(order.getUserId()).get(0);
//		dal.model.gas_user.UserDO jhyUserInfo =gasUserTestBase.findUserByUserId(order.getUserId()).get(0);
//		List<UserCarInfoDO> carInfos= gasUserTestBase.findUserCarInfoByUserId(order.getUserId());
//		//xyb用户信息校验
//		assertEquals(userDO.getMobile(),userInfo.getMobile());
//		assertEquals(userDO.getUserType(),userInfo.getUserType());
//		assertEquals(userDO.getRegisterFrom(),userInfo.getRegisterFrom());
//		assertEquals(userDO.getMerchantUserId(),userInfo.getMerchantUserId());
//		assertEquals(userDO.getUserName(),userInfo.getUserName());
//		assertEquals(userDO.getCertNo(),userInfo.getCertNo());
//		assertEquals(userDO.getAddress(),userInfo.getAddress());
//		assertEquals(userDO.getCertType(),userInfo.getCertType());
//		assertEquals(userDO.getCity(),userInfo.getCity());
//		assertEquals(userDO.getCountry(),userInfo.getCountry());
//		assertEquals(userDO.getDistrict(),userInfo.getDistrict());
//		assertEquals(userDO.getMemo(),userInfo.getMemo());
//		assertEquals(userDO.getPhone(),userInfo.getPhone());
//		assertEquals(userDO.getProvince(),userInfo.getProvince());
//		assertEquals(userDO.getRegisterIp(),userInfo.getRegisterIp());
//		assertEquals(userDO.getZipCode(),userInfo.getZipCode());
//		assertEquals(userDO.getUserStatus(),userInfo.getUserStatus());
//		assertEquals(userDO.getCertifyStatus(),userInfo.getCertifyStatus());
//		assertEquals(userDO.getPartnerId(),userInfo.getPartnerId());
//		assertEquals(userDO.getCustomerId(),userInfo.getCustomerId());
//		assertEquals(userDO.getRawAddTime(),userInfo.getRawAddTime());
//		assertEquals(userDO.getParentUserId(),userInfo.getParentUserId());
//		if(testId==1001){
//			assertEquals(userDO.getRealName(),userInfo.getRealName());
//			assertEquals(userDO.getRawUpdateTime(), userInfo.getRawUpdateTime());
//		}else {
//			assertEquals(order.getRealName(),userInfo.getRealName());
//			assertNotEquals(userDO.getRawUpdateTime(), userInfo.getRawUpdateTime());
//		}
//		//jhy用户信息校验
//		assertEquals(jhyUserDO.getMobile(),jhyUserInfo.getMobile());
//		assertEquals(jhyUserDO.getPartnerId(),jhyUserInfo.getPartnerId());
//		assertEquals(jhyUserDO.getMemberType(),jhyUserInfo.getMemberType());
//		assertEquals(jhyUserDO.getGrade(),jhyUserInfo.getGrade());
//		assertEquals(jhyUserDO.getPayed(),jhyUserInfo.getPayed());
//		assertEquals(jhyUserDO.getRawAddTime(),jhyUserInfo.getRawAddTime());
//		if(testId<=1002) {
//			assertEquals(jhyUserDO.getHeadImgUrl(),jhyUserInfo.getHeadImgUrl());
//			assertEquals(jhyUserDO.getNickName(),jhyUserInfo.getNickName());
//			assertEquals(jhyUserDO.getRealName(),jhyUserInfo.getRealName());
//			assertEquals(jhyUserDO.getSex(),jhyUserInfo.getSex());
//			assertEquals(jhyUserDO.getRawUpdateTime(), jhyUserInfo.getRawUpdateTime());
//		}else {
//			assertEquals(order.getHeadImgUrl(),jhyUserInfo.getHeadImgUrl());
//			assertEquals(order.getNickName(),jhyUserInfo.getNickName());
//			assertEquals(order.getRealName(),jhyUserInfo.getRealName());
//			assertEquals(order.getSex().code(),jhyUserInfo.getSex());
//			assertNotEquals(jhyUserDO.getRawUpdateTime(), jhyUserInfo.getRawUpdateTime());
//		}
//		if(testId==1003) {
//			assertEquals(order.getBirthday(), jhyUserInfo.getBirthday());
//		}else {
//			assertEquals(jhyUserDO.getBirthday(), jhyUserInfo.getBirthday());
//		}
//		//车辆信息校验
//		if(testId<=1002){
//			assertTrue(carInfos.size()==0);
//		}
//		if(testId>=1003){
//			assertTrue(carInfos.size()==1);
//			for(UserCarInfoDO carInfo:carInfos){
//				assertEquals(order.getCarNumber(),carInfo.getCarNumber());
//				if(testId>=1003&&testId<=1005){
//					assertEquals(null,carInfo.getApplyDate());
//					assertEquals(null,carInfo.getAuditDate());
//					assertEquals(null,carInfo.getAuditStatus());
//					assertEquals(null,carInfo.getAuthenticateImg());
//					assertEquals(null,carInfo.getCarType());
//				}else {
//					assertEquals(carInfoDO.getApplyDate(),carInfo.getApplyDate());
//					assertEquals(carInfoDO.getAuditDate(),carInfo.getAuditDate());
//					assertEquals(carInfoDO.getAuditStatus(),carInfo.getAuditStatus());
//					assertEquals(carInfoDO.getAuthenticateImg(),carInfo.getAuthenticateImg());
//					assertEquals(carInfoDO.getCarType(),carInfo.getCarType());
//					//assertNotEquals(carInfoDO.getRawUpdateTime(),carInfo.getRawUpdateTime());
//				}
//			}
//		}
//		//积分
//		PointsDO pointsxx = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
//		if (testId >= 1003 && testId <= 1005) {
//			assertEquals(points.getPoints().intValue() + 10, pointsxx.getPoints().intValue());
//			assertEquals(points.getHistoryAddPoints().intValue() + 10, pointsxx.getHistoryAddPoints().intValue());
//			assertEquals(points.getHistorySubtractPoints().intValue(), pointsxx.getHistorySubtractPoints().intValue());
//		} else {
//			assertEquals(points.getPoints().intValue(), pointsxx.getPoints().intValue());
//			assertEquals(points.getHistoryAddPoints().intValue(), pointsxx.getHistoryAddPoints().intValue());
//			assertEquals(points.getHistorySubtractPoints().intValue(), pointsxx.getHistorySubtractPoints().intValue());
//		}
//		//券
//		List<CouponDO> coupons = promotionTestBase.findCouponByUserId(userDO.getUserId());
//		if (testId >= 1003 && testId <= 1005) {
//			assertEquals(1, coupons.size());
//			for (CouponDO coupon : coupons) {
//				assertEquals("001imamfune0s107pr00", coupon.getDefinitionId());
//				assertEquals("满100减5元", coupon.getName());
//				assertEquals(userDO.getPartnerId(), coupon.getPartnerId());
//				assertEquals("S0301806081400000015", coupon.getPlatPartnerId());
//				assertEquals(CouponType.OVER.toString(), coupon.getCouponType());
//				assertEquals(CouponStatus.TAKEN.toString(), coupon.getStatus());
//			}
//		} else {
//			assertEquals(0, coupons.size());
//		}
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
//		gasUserTestBase.cleanUserCarInfoByUserId(carInfoDO.getUserId());
//		gasUserTestBase.cleanUserCarInfoByCarNumber(order.getCarNumber());
//		promotionTestBase.cleanPointsByUserId(userDO.getUserId());
//		promotionTestBase.cleanCouponByUserId(userDO.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceUpdateTestFailOne.csv")
//	@DisplayName("更新用户信息--参数非法")
//	public void userServiceUpdateTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			UserUpdateOrder order,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId==1001){
//			order.setUserId(null);
//		}
//		if(testId==1002){
//			order.setGid(null);
//		}
//		if(testId==1003){
//			order=null;
//		}
//		// 调用接口
//		SimpleResult result = userService.update(order);
//		// 结果验证
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userServiceUpdateTestFailTwo.csv")
//	@DisplayName("更新用户信息--失败用例")
//	public void userServiceUpdateTestFailTwo(
//			// 基本参数
//			int testId,
//			// 业务参数
//			UserUpdateOrder order,
//			// 会员
//			dal.model.gas_user.UserDO jhyUserDO,
//			UserDO userDO,
//			//卡
//			UserCarInfoDO carInfoDO,
//			// 结果参数
//			String code,
//			String message,
//			String description
//	) {
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
////		gasUserTestBase.cleanUserCarInfoByUserIdAndCarNumber(carInfoDO.getUserId(),carInfoDO.getCarNumber());
//		// 准备数据
//		if(testId==1001) {
//			userTestBase.insertUser(userDO);
//		}
//		if(testId==1002) {
//			gasUserTestBase.insertUser(jhyUserDO);
//		}
//		// 测试过程
//		// 调用接口
//		SimpleResult result = userService.update(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		assertEquals(message, result.getMessage());
//		// 数据验证
//		// 清除数据
//		userTestBase.cleanUserByUserId(userDO.getUserId());
//		gasUserTestBase.cleanUserByUserId(jhyUserDO.getUserId());
////		gasUserTestBase.cleanUserCarInfoByUserIdAndCarNumber(carInfoDO.getUserId(),carInfoDO.getCarNumber());
//	}
//}
