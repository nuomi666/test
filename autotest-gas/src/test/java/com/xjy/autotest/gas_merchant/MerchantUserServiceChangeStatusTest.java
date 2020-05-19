//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.order.ChangeMerchantUserStatusOrder;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/21.
// */
//public class MerchantUserServiceChangeStatusTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_merchant/merchantUserServiceChangeStatusTestSuccess.csv")
//	@DisplayName("修改用户状态--成功用例")
//	public void merchantUserServiceChangeStatusTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ChangeMerchantUserStatusOrder order,
//			GasMerchantDO gasMerchantDO,
//			GasMerchantUserDO gasMerchantUserDO,
//			GasMerchantUserDO gasMerchantUserDOxx
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDOxx.getUserId());
//		// 准备数据
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDO);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDOxx);
//		// 测试过程
//		order.setUserId(gasMerchantUserDO.getUserId());
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = merchantUserService.changeStatus(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		GasMerchantUserDO userInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getUserId()).get(0);
//		assertEquals(order.getUserStatus().code(), userInfo.getStatus());
//		assertNotEquals(gasMerchantUserDO.getRawUpdateTime(), userInfo.getRawUpdateTime());
//		assertEquals(gasMerchantUserDO.getRawAddTime(), userInfo.getRawAddTime());
//		assertEquals(order.getUserId(), userInfo.getUserId());
//		assertEquals(gasMerchantUserDO.getRoleId(), userInfo.getRoleId());
//		assertEquals(gasMerchantUserDO.getUserType(), userInfo.getUserType());
//		assertEquals(gasMerchantUserDO.getPartnerId(), userInfo.getPartnerId());
//		assertEquals(gasMerchantUserDO.getUserName(), userInfo.getUserName());
//		assertEquals(gasMerchantUserDO.getMobileNo(), userInfo.getMobileNo());
//		assertEquals(gasMerchantUserDO.getAccount(), userInfo.getAccount());
//		assertEquals(gasMerchantUserDO.getLoginErrorCount(), userInfo.getLoginErrorCount());
//		assertEquals(gasMerchantUserDO.getLoginErrorLimit(), userInfo.getLoginErrorLimit());
//		assertEquals(gasMerchantUserDO.getLastLoginTime(), userInfo.getLastLoginTime());
//		assertEquals(gasMerchantUserDO.getLastLoginSuccessTime(), userInfo.getLastLoginSuccessTime());
//		assertEquals(gasMerchantUserDO.getLastLogoutSuccessTime(), userInfo.getLastLogoutSuccessTime());
//		GasMerchantUserDO userInfoxx = gasMerchantTestBase.findGasMerchantUserByUserId(gasMerchantUserDOxx.getUserId()).get(0);
//		assertEquals(gasMerchantUserDOxx.getStatus(), userInfoxx.getStatus());
//		assertEquals(gasMerchantUserDOxx.getRawUpdateTime(), userInfoxx.getRawUpdateTime());
//		assertEquals(gasMerchantUserDOxx.getRawAddTime(), userInfoxx.getRawAddTime());
//		assertEquals(gasMerchantUserDOxx.getUserId(), userInfoxx.getUserId());
//		assertEquals(gasMerchantUserDOxx.getRoleId(), userInfoxx.getRoleId());
//		assertEquals(gasMerchantUserDOxx.getUserType(), userInfoxx.getUserType());
//		assertEquals(gasMerchantUserDOxx.getPartnerId(), userInfoxx.getPartnerId());
//		assertEquals(gasMerchantUserDOxx.getUserName(), userInfoxx.getUserName());
//		assertEquals(gasMerchantUserDOxx.getMobileNo(), userInfoxx.getMobileNo());
//		assertEquals(gasMerchantUserDOxx.getAccount(), userInfoxx.getAccount());
//		assertEquals(gasMerchantUserDOxx.getLoginErrorCount(), userInfoxx.getLoginErrorCount());
//		assertEquals(gasMerchantUserDOxx.getLoginErrorLimit(), userInfoxx.getLoginErrorLimit());
//		assertEquals(gasMerchantUserDOxx.getLastLoginTime(), userInfoxx.getLastLoginTime());
//		assertEquals(gasMerchantUserDOxx.getLastLoginSuccessTime(), userInfoxx.getLastLoginSuccessTime());
//		assertEquals(gasMerchantUserDOxx.getLastLogoutSuccessTime(), userInfoxx.getLastLogoutSuccessTime());
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDOxx.getUserId());
//	}
//}
