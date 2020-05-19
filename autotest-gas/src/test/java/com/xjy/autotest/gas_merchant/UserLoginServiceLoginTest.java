//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.BaseUtil;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.enums.UserStatus;
//import com.xyb.gas.merchant.api.facade.UserLoginService;
//import com.xyb.gas.merchant.api.info.*;
//import com.xyb.gas.merchant.api.order.UserLoginBossOrder;
//import com.xyb.gas.merchant.api.result.UserLoginResult;
//import dal.model.gas_merchant.*;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/21.
// */
//public class UserLoginServiceLoginTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    UserLoginService userLoginService;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/userLoginServiceLoginTestSuccess.csv")
//	@DisplayName("登录商户平台--成功用例")
//	public void userLoginServiceLoginTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			UserLoginBossOrder order,
//			GasMerchantDO gasMerchantDO,
//			GasMerchantUserDO gasMerchantUserDO,
//			GasRoleDO gasRoleDO,
//			GasDeviceResourceDO gasDeviceResourceDO,
//			GasMerchantSourceDataDO gasMerchantSourceDataDO,
//			GasMerchantStationDO gasMerchantStationDO,
//			GasGoodsDO gasGoodsDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDO.getRoleName());
//		gasMerchantTestBase.cleanGasDeviceResourceByCode(gasDeviceResourceDO.getCode());
//		gasMerchantTestBase.cleanGasMerchantRoleByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantResourceByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantStationByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasStationOilGunByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasGoodsByGoodsCode(gasGoodsDO.getGoodsCode());
//		gasMerchantTestBase.cleanGasMerchantGoodsByPartnerId(gasMerchantDO.getPartnerId());
//		// 准备数据
//		//商户数据
//		String passwordEnum = BaseUtil.encrypt(order.getPassword(), gasMerchantUserDO.getSalt());
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//		//角色
//		gasMerchantTestBase.insertGasRole(gasRoleDO);
//		List<GasRoleDO> roles = gasMerchantTestBase.findGasRoleByRoleName(gasRoleDO.getRoleName());
//		//商户用户
//		gasMerchantUserDO.setRoleId(roles.get(0).getId());
//		gasMerchantUserDO.setPassword(passwordEnum);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDO);
//		//商户角色关联
//		GasMerchantRoleDO gasMerchantRoleDO = new GasMerchantRoleDO();
//		gasMerchantRoleDO.setRoleId(roles.get(0).getId());
//		gasMerchantRoleDO.setPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.insertGasMerchantRole(gasMerchantRoleDO);
//		//配置终端资源
//		gasMerchantTestBase.insertGasDeviceResource(gasDeviceResourceDO);
//		List<GasDeviceResourceDO> deviceResources = gasMerchantTestBase.findGasDeviceResourceByCode(gasDeviceResourceDO.getCode());
//		//资源角色关联表
//		GasMerchantRoleResourceDO gasMerchantRoleResourceDO = new GasMerchantRoleResourceDO();
//		gasMerchantRoleResourceDO.setResourceId(deviceResources.get(0).getId());
//		gasMerchantRoleResourceDO.setRoleId(roles.get(0).getId());
//		gasMerchantTestBase.insertGasMerchantRoleResource(gasMerchantRoleResourceDO);
//		//资源商户关联（pos机专用？？？）
//		GasMerchantResourceDO gasMerchantResourceDO = new GasMerchantResourceDO();
//		gasMerchantResourceDO.setResourceId(deviceResources.get(0).getId());
//		gasMerchantResourceDO.setPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.insertGasMerchantResource(gasMerchantResourceDO);
//		//油站
//		if (testId >= 1002) {
//			gasMerchantTestBase.insertGasMerchantStation(gasMerchantStationDO);
//		}
//		//商品
//		gasMerchantTestBase.insertGasGoods(gasGoodsDO);
//		GasMerchantGoodsDO gasMerchantGoodsDO = new GasMerchantGoodsDO();
//		gasMerchantGoodsDO.setGoodsCode(gasGoodsDO.getGoodsCode());
//		gasMerchantGoodsDO.setGoodsName(gasGoodsDO.getGoodsName());
//		gasMerchantGoodsDO.setGoodsType(gasGoodsDO.getGoodsType());
//		gasMerchantGoodsDO.setGroupId(gasGoodsDO.getGroupId());
//		gasMerchantGoodsDO.setPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.insertGasMerchantGoods(gasMerchantGoodsDO);
//		//配置油枪
//		GasStationOilGunDO gasStationOilGunDO = new GasStationOilGunDO();
//		gasStationOilGunDO.setOilGunNo("900");
//		gasStationOilGunDO.setGoodsCode(gasGoodsDO.getGoodsCode());
//		gasStationOilGunDO.setStationId(gasMerchantStationDO.getStationId());
//		gasStationOilGunDO.setPartnerId(gasMerchantDO.getPartnerId());
//		if (testId == 1003) {
//			gasMerchantTestBase.insertGasStationOilGun(gasStationOilGunDO);
//		}
//		//关联油站
//		GasMerchantUserStationDO gasMerchantUserStationDO = new GasMerchantUserStationDO();
//		gasMerchantUserStationDO.setUserId(gasMerchantUserDO.getUserId());
//		gasMerchantUserStationDO.setStationId(gasMerchantStationDO.getStationId());
//		if (testId >= 1002) {
//			gasMerchantTestBase.insertGasMerchantUserStation(gasMerchantUserStationDO);
//		}
//		//商户来源
//		if (testId == 1001) {
//			gasMerchantTestBase.insertGasMerchantSourceData(gasMerchantSourceDataDO);
//		}
//		// 测试过程
//		if (testId == 1003) {//登录失败
//			UserLoginBossOrder order1 = new UserLoginBossOrder();
//			order1.setAccount(order.getAccount());
//			order1.setPassword("123456");
//			order1.setGid(GID.newGID());
//			userLoginService.login(order1);
//		}
//		order.setGid(GID.newGID());
//		// 调用接口
//		UserLoginResult result = userLoginService.login(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		//商户信息
//		MerchantInfo merchantInfo = result.getInfo().getMerchantInfo();
//		assertEquals(gasMerchantDO.getPartnerId(), merchantInfo.getPartnerId());
//		assertEquals(gasMerchantDO.getPartnerName(), merchantInfo.getPartnerName());
//		assertEquals(gasMerchantDO.getShortName(), merchantInfo.getShortName());
//		assertEquals(gasMerchantDO.getMobileNo(), merchantInfo.getMobileNo());
//		assertEquals(gasMerchantDO.getAccountNo(), merchantInfo.getAccountNo());
//		assertEquals(gasMerchantDO.getMarketAccountNo(), merchantInfo.getMarketAccountNo());
//		assertEquals(gasMerchantDO.getStatus(), merchantInfo.getStatus().code());
//		assertEquals(gasMerchantDO.getEmail(), merchantInfo.getEmail());
//		assertEquals(gasMerchantDO.getHeadImgUrl(), merchantInfo.getHeadImgUrl());
//		//assertEquals(gasMerchantDO.getQueryDepth(), merchantInfo.getQueryDepth());
//		assertEquals(gasMerchantDO.getRawAddTime(), merchantInfo.getRawAddTime());
//		//来源信息
//		if (testId == 1001) {
//			assertEquals(gasMerchantSourceDataDO.getSourceType(), merchantInfo.getSourceType().code());
//			assertEquals(gasMerchantSourceDataDO.getSourceKey(), merchantInfo.getSourceKey());
//			assertEquals(true, merchantInfo.isAuthorized());
//			assertEquals(gasMerchantSourceDataDO.getAuthorizerRefreshToken(), merchantInfo.getAuthorizerRefreshToken());
//		} else {
//			assertEquals(null, merchantInfo.getSourceType());
//			assertEquals(null, merchantInfo.getSourceKey());
//			assertEquals(false, merchantInfo.isAuthorized());
//			assertEquals(null, merchantInfo.getAuthorizerRefreshToken());
//		}
//		//用户信息
//		MerchantUserInfo merchantUserInfo = result.getInfo().getUserInfo();
//		assertEquals(gasMerchantUserDO.getUserId(), merchantUserInfo.getUserId());
//		assertEquals(gasMerchantUserDO.getPartnerId(), merchantUserInfo.getPartnerId());
//		assertEquals(gasMerchantUserDO.getUserName(), merchantUserInfo.getUserName());
//		assertEquals(gasMerchantUserDO.getMobileNo(), merchantUserInfo.getMobileNo());
//		assertEquals(gasMerchantUserDO.getAccount(), merchantUserInfo.getAccount());
//		assertEquals(gasMerchantUserDO.getStatus(), merchantUserInfo.getStatus().code());
//		assertEquals(0, merchantUserInfo.getLoginErrorCount());
//		assertEquals(gasMerchantUserDO.getLoginErrorLimit(), merchantUserInfo.getLoginErrorLimit());
//		assertNotEquals(gasMerchantUserDO.getLastLoginTime(), merchantUserInfo.getLastLoginTime());
//		assertNotEquals(gasMerchantUserDO.getLastLoginSuccessTime(), merchantUserInfo.getLastLoginSuccessTime());
//		assertEquals(gasMerchantUserDO.getLastLogoutSuccessTime(), merchantUserInfo.getLastLogoutSuccessTime());
//		//权限资源
//		List<ResourceInfo> resourceInfos = result.getInfo().getInfos();
//		assertTrue(resourceInfos.size() > 0);
//		for (ResourceInfo resourceInfo : resourceInfos) {
//			assertEquals(deviceResources.get(0).getId(), resourceInfo.getId());
//			assertEquals(deviceResources.get(0).getName(), resourceInfo.getName());
//			assertEquals(deviceResources.get(0).getCode(), resourceInfo.getCode());
//			assertEquals(deviceResources.get(0).getParentId(), resourceInfo.getParentId());
////			assertEquals(deviceResources.get(0).getParentCode(), resourceInfo.getParentCode());
////			assertEquals(deviceResources.get(0).getParentName(), resourceInfo.getParentName());
//			assertEquals(deviceResources.get(0).getUrl(), resourceInfo.getUrl());
//			assertEquals(deviceResources.get(0).getResourceType(), resourceInfo.getResourceType().code());
//			assertEquals(deviceResources.get(0).getOrderNo(), resourceInfo.getOrderNo());
//			assertEquals(deviceResources.get(0).getIcon(), resourceInfo.getIcon());
//			assertEquals(deviceResources.get(0).getMemo(), resourceInfo.getMemo());
//		}
//		//所属油站ids
//		List<String> stationIds = result.getInfo().getStationIds();
//		if (testId == 1001) {
//			assertTrue(stationIds.size() == 0);
//		} else {
//			stationIds.contains(gasMerchantStationDO.getStationId());
//		}
//		//所属油站信息
//		List<MerchantStationDetailInfo> stationInfos = result.getInfo().getStationInfos();
//		if (testId >= 1002) {
//			assertTrue(stationInfos.size() > 0);
//			for (MerchantStationDetailInfo stationInfo : stationInfos) {
//				assertEquals(gasMerchantStationDO.getStationId(), stationInfo.getStationId());
//				assertEquals(gasMerchantStationDO.getPartnerId(), stationInfo.getPartnerId());
//				assertEquals(gasMerchantStationDO.getStationName(), stationInfo.getStationName());
//				assertEquals(gasMerchantStationDO.getStationCode(), stationInfo.getStationCode());
//				assertEquals(gasMerchantStationDO.getPhoneNo(), stationInfo.getPhoneNo());
//				assertEquals(gasMerchantStationDO.getStatus(), stationInfo.getStatus().code());
//				//assertEquals(gasMerchantStationDO.getConnectOilMachine(), stationInfo.getConnectOilMachine());
//				assertEquals(gasMerchantStationDO.getProvinceId(), stationInfo.getProvinceId());
//				assertEquals(gasMerchantStationDO.getCityId(), stationInfo.getCityId());
////				assertEquals(gasMerchantStationDO.getCityName(), stationInfo.getCityName());
//				assertEquals(gasMerchantStationDO.getDistrictId(), stationInfo.getDistrictId());
////				assertEquals(gasMerchantStationDO.getDistrictName(), stationInfo.getDistrictName());
//				assertEquals(gasMerchantStationDO.getStationAddress(), stationInfo.getStationAddress());
//				List<StationOilGunInfo> oilGunInfos = stationInfo.getOilGunInfos();
//				if (testId == 1003) {
//					assertTrue(oilGunInfos.size() > 0);
//					for (StationOilGunInfo oilGunInfo : oilGunInfos) {
//						assertEquals(gasStationOilGunDO.getPartnerId(), oilGunInfo.getPartnerId());
//						assertEquals(gasStationOilGunDO.getStationId(), oilGunInfo.getStationId());
//						assertEquals(gasStationOilGunDO.getOilGunNo(), oilGunInfo.getOilGunNo());
//						assertEquals(gasStationOilGunDO.getGoodsCode(), oilGunInfo.getGoodsCode());
//						assertEquals(gasGoodsDO.getGoodsName(), oilGunInfo.getGoodsName());
//					}
//				} else {
//					assertTrue(oilGunInfos.size() == 0);
//				}
//			}
//		} else {
//			assertTrue(stationInfos.size() == 0);
//		}
//		//油站打印小票信息
//		List<DevicePrintInfo> devicePrintInfos = result.getInfo().getDevicePrintInfos();
//		assertEquals(null, devicePrintInfos);
//		// 数据验证
//		List<GasMerchantUserDO> userInfos = gasMerchantTestBase.findGasMerchantUserByMobileNo(gasMerchantUserDO.getMobileNo());
//		assertTrue(userInfos.size() == 1);
//		for (GasMerchantUserDO userInfo : userInfos) {
//			assertEquals(gasMerchantUserDO.getUserId(), userInfo.getUserId());
//			assertEquals(roles.get(0).getId(), userInfo.getRoleId());
//			assertEquals(gasMerchantUserDO.getUserType(), userInfo.getUserType());
//			assertEquals(gasMerchantUserDO.getPartnerId(), userInfo.getPartnerId());
//			assertEquals(gasMerchantUserDO.getUserName(), userInfo.getUserName());
//			assertEquals(gasMerchantUserDO.getMobileNo(), userInfo.getMobileNo());
//			assertEquals(gasMerchantUserDO.getAccount(), userInfo.getAccount());
//			assertEquals(passwordEnum, userInfo.getPassword());
//			assertEquals(gasMerchantUserDO.getSalt(), userInfo.getSalt());
//			assertEquals(UserStatus.NORMAL.code(), userInfo.getStatus());
//			assertEquals(0, userInfo.getLoginErrorCount().intValue());
//			assertEquals(gasMerchantUserDO.getLoginErrorLimit(), userInfo.getLoginErrorLimit());
//			assertNotEquals(gasMerchantUserDO.getLastLoginTime(), userInfo.getLastLoginTime());
//			assertNotEquals(gasMerchantUserDO.getLastLoginSuccessTime(), userInfo.getLastLoginSuccessTime());
//			assertEquals(gasMerchantUserDO.getLastLogoutSuccessTime(), userInfo.getLastLogoutSuccessTime());
//			assertNotNull(userInfo.getRawAddTime());
//			assertNotEquals(userInfo.getRawAddTime(), userInfo.getRawUpdateTime());
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDO.getRoleName());
//		gasMerchantTestBase.cleanGasDeviceResourceByCode(gasDeviceResourceDO.getCode());
//		gasMerchantTestBase.cleanGasMerchantRoleByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantResourceByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantRoleResourceByResourceId(deviceResources.get(0).getId());
//		gasMerchantTestBase.cleanGasMerchantStationByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasStationOilGunByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasGoodsByGoodsCode(gasGoodsDO.getGoodsCode());
//		gasMerchantTestBase.cleanGasMerchantGoodsByPartnerId(gasMerchantDO.getPartnerId());
//	}
//}
