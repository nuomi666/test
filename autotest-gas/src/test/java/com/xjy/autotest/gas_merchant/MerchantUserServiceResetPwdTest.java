//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.BaseUtil;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
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
//public class MerchantUserServiceResetPwdTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_merchant/merchantUserServiceResetPwdTestSuccess.csv")
//	@DisplayName("重置用户密码--成功用例")
//	public void merchantUserServiceResetPwdTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			CommonBaseOrder order,
//			GasMerchantDO gasMerchantDO,
//			GasMerchantUserDO gasMerchantUserDO,
//			GasMerchantUserDO gasMerchantUserDOxx
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDOxx.getUserId());
//		// 准备数据
//		String oldPasswordEnum = BaseUtil.encrypt("abc123", gasMerchantUserDO.getSalt());
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//		gasMerchantUserDO.setPassword(oldPasswordEnum);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDO);
//		gasMerchantUserDOxx.setPassword(oldPasswordEnum);
//		gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDOxx);
//		// 测试过程
//		order.setId(gasMerchantUserDO.getUserId());
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = merchantUserService.resetPwd(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		GasMerchantUserDO userInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getId()).get(0);
//		String newPasswordEnum = BaseUtil.encrypt("123456", userInfo.getSalt());
//		assertEquals(newPasswordEnum, userInfo.getPassword());
//		assertEquals(gasMerchantUserDO.getUqKey(), userInfo.getUqKey());
//		assertEquals(0, userInfo.getLoginErrorCount().intValue());
//		assertNotEquals(gasMerchantUserDO.getRawUpdateTime(), userInfo.getRawUpdateTime());
//		GasMerchantUserDO userInfoxx = gasMerchantTestBase.findGasMerchantUserByUserId(gasMerchantUserDOxx.getUserId()).get(0);
//		assertEquals(oldPasswordEnum, userInfoxx.getPassword());
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
//		gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDOxx.getUserId());
//	}
//}
