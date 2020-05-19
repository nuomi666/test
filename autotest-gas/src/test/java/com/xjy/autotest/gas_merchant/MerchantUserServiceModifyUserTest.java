//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.BaseUtil;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.enums.UserStatus;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.order.ModifyMerchantUserOrder;
//import dal.model.gas_merchant.*;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Set;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/21.
// */
//public class MerchantUserServiceModifyUserTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    MerchantUserService merchantUserService;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/merchantUserServiceModifyUserTestSuccess.csv")
//	@DisplayName("修改商户用户--成功用例")
//	public void merchantUserServiceModifyUserTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ModifyMerchantUserOrder order,
//			GasMerchantDO gasMerchantDO,
//			GasMerchantDO gasMerchantDOxx,
//			GasMerchantSourceDataDO gasMerchantSourceDataDO,
//			GasMerchantSourceDataDO gasMerchantSourceDataDOxx,
//			GasMerchantStationDO gasMerchantStationDO,
//			GasMerchantStationDO gasMerchantStationDOxx,
//			GasMerchantUserDO gasMerchantUserDO,
//			GasRoleDO gasRoleDO,
//			GasRoleDO gasRoleDOxx
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDOxx.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(order.getUserId());
//		gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDO.getRoleName());
//		gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDOxx.getRoleName());
//		gasMerchantTestBase.cleanGasMerchantRoleByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantRoleByPartnerId(gasMerchantDOxx.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantStationByStationId(gasMerchantStationDO.getStationId());
//		gasMerchantTestBase.cleanGasMerchantStationByStationId(gasMerchantStationDOxx.getStationId());
//		gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantSourceDataDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantSourceDataDOxx.getPartnerId());
//		// 准备数据
//		//修改前商户
//		if (testId != 1003) {
//			gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//			gasMerchantTestBase.insertGasMerchantSourceData(gasMerchantSourceDataDO);
//		}
//		gasMerchantTestBase.insertGasRole(gasRoleDO);
//		List<GasRoleDO> roles = gasMerchantTestBase.findGasRoleByRoleName(gasRoleDO.getRoleName());
//		GasMerchantRoleDO gasMerchantRoleDO = new GasMerchantRoleDO();
//		gasMerchantRoleDO.setPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantRoleDO.setRoleId(roles.get(0).getId());
//		gasMerchantTestBase.insertGasMerchantRole(gasMerchantRoleDO);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDO);
//		gasMerchantTestBase.insertGasMerchantStation(gasMerchantStationDO);
//		//修改后商户
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDOxx);
//		gasMerchantTestBase.insertGasMerchantSourceData(gasMerchantSourceDataDOxx);
//		if (testId != 1001) {
//			gasMerchantTestBase.insertGasRole(gasRoleDOxx);
//		}
//		List<GasRoleDO> rolesxx = gasMerchantTestBase.findGasRoleByRoleName(gasRoleDOxx.getRoleName());
//		GasMerchantRoleDO gasMerchantRoleDOxx = new GasMerchantRoleDO();
//		gasMerchantRoleDOxx.setPartnerId(gasMerchantDOxx.getPartnerId());
//		gasMerchantRoleDOxx.setRoleId(rolesxx.get(0).getId());
//		gasMerchantTestBase.insertGasMerchantRole(gasMerchantRoleDOxx);
//		gasMerchantTestBase.insertGasMerchantStation(gasMerchantStationDOxx);
//		//商户油站
//		GasMerchantUserStationDO gasMerchantUserStationDO = new GasMerchantUserStationDO();
//		gasMerchantUserStationDO.setStationId("001if9yaxy78g102eh00");
//		gasMerchantUserStationDO.setUserId(gasMerchantUserDO.getUserId());
//		if (testId <= 1003) {
//			gasMerchantTestBase.insertGasMerchantUserStation(gasMerchantUserStationDO);
//		}
//		// 测试过程
//		Set<String> stationIds = Sets.newHashSet();
//		stationIds.add("001if9yaxy78g102eh01");
//		if (testId == 1003) {
//			stationIds.add("001if9yaxy78g102eh00");
//		}
//		if (testId != 1004) {
//			order.setStationIds(stationIds);
//		}
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = merchantUserService.modifyUser(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		GasMerchantUserDO userInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getUserId()).get(0);
//		List<GasMerchantUserStationDO> userStations = gasMerchantTestBase.findGasMerchantUserStationByUserId(order.getUserId());
//		if (testId == 1004) {
//			assertEquals(0, userStations.size());
//		} else if (testId == 1003) {
//			assertEquals(2, userStations.size());
//		} else {
//			assertEquals(1, userStations.size());
//			for (GasMerchantUserStationDO userStation : userStations) {
//				assertEquals(order.getUserId(), userStation.getUserId());
//				assertEquals("001if9yaxy78g102eh01", userStation.getStationId());
//			}
//		}
//		String pwdEnum = BaseUtil.encrypt(order.getPassword(), userInfo.getSalt());
//		assertEquals(order.getUserId(), userInfo.getUserId());
//		assertEquals(rolesxx.get(0).getId(), userInfo.getRoleId());
//		//assertEquals(order.getUserType().code(), userInfo.getUserType());
//		assertEquals(order.getPartnerId(), userInfo.getPartnerId());
//		assertEquals(order.getUserName(), userInfo.getUserName());
//		assertEquals(order.getMobileNo(), userInfo.getMobileNo());
//		assertEquals(order.getAccount(), userInfo.getAccount());
////		if (testId == 1002) {
////			assertEquals(gasMerchantUserDO.getPassword(), userInfo.getPassword());
////		} else {
////			assertEquals(pwdEnum, userInfo.getPassword());
////		}
////			assertEquals(order.getUserName(), userInfo.getSalt());
//		assertEquals(UserStatus.NORMAL.code(), userInfo.getStatus());
//		assertEquals(gasMerchantUserDO.getLoginErrorCount(), userInfo.getLoginErrorCount());
//		assertEquals(order.getLoginErrorLimit(), userInfo.getLoginErrorLimit());
//		assertEquals(gasMerchantUserDO.getLastLoginTime(), userInfo.getLastLoginTime());
//		assertEquals(gasMerchantUserDO.getLastLoginSuccessTime(), userInfo.getLastLoginSuccessTime());
//		assertEquals(gasMerchantUserDO.getLastLogoutSuccessTime(), userInfo.getLastLogoutSuccessTime());
//		assertNotNull(userInfo.getRawAddTime());
//		assertNotEquals(userInfo.getRawAddTime(), userInfo.getRawUpdateTime());
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDOxx.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(order.getUserId());
//		gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDO.getRoleName());
//		gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDOxx.getRoleName());
//		gasMerchantTestBase.cleanGasMerchantRoleByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantRoleByPartnerId(gasMerchantDOxx.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantStationByStationId(gasMerchantStationDO.getStationId());
//		gasMerchantTestBase.cleanGasMerchantStationByStationId(gasMerchantStationDOxx.getStationId());
//		gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantSourceDataDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantSourceDataDOxx.getPartnerId());
//	}
//}
