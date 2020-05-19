//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserIntegralHierarchyService;
//import com.xyb.gas.user.api.order.AddUserIntegralResetOrder;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_user.UserIntegralResetRuleDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/11/26.
// */
//public class UserIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    UserIntegralHierarchyService userIntegralHierarchyService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestSuccess.csv")
//	@DisplayName("保存会员积分清零规则--成功用例")
//	public void userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddUserIntegralResetOrder order,
//			GasMerchantDO gasMerchantDO,
//			UserIntegralResetRuleDO userIntegralResetRuleDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
////		gasUserTestBase.cleanUserByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(userIntegralResetRuleDO.getPartnerId());
//		// 准备数据
//		List<String> days = new ArrayList<String>();
//		if(testId==1001){//每周：1-7 表示周日到周六
//			days.add("1");
//		}
//		if(testId==1002){//每月：1-31 表示1号到31号
//			days.add("1");
//		}
//		if(testId==1003){//每年： MM-DD 01-01
//			days.add("01-01");
//		}
//		if(testId==1004) {//定时:YYYY-MM-DD  2018-01-01
//			days.add("2018-11-26");
//		}
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//		if(testId>=1003) {
//			userIntegralResetRuleDO.setDays(JSON.toJSONString(days).toString());
//			gasUserTestBase.insertUserIntegralResetRule(userIntegralResetRuleDO);
//		}
//		// 测试过程
//		order.setDays(days);
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = userIntegralHierarchyService.addPartnerUserIntegralResetRule(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<UserIntegralResetRuleDO> rules=gasUserTestBase.findUserIntegralResetRuleByPartnerId(order.getPartnerId());
//		assertEquals(1,rules.size());
//		for(UserIntegralResetRuleDO rule:rules){
//			assertEquals(order.getPartnerId(),rule.getPartnerId());
//			assertEquals(String.valueOf(order.isResetSwitch()),rule.getResetSwitch());
//			assertEquals(order.getIntegralResetType().toString(),rule.getIntegralResetType());
//			assertEquals(order.getUseTimeUnit().toString(),rule.getUseTimeUnit());
////			assertEquals(order.getPartnerId(),rule.getDays());
////			assertEquals(order.getPartnerId(),rule.getTime());
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
////		gasUserTestBase.cleanUserByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(userIntegralResetRuleDO.getPartnerId());
//	}
//}
