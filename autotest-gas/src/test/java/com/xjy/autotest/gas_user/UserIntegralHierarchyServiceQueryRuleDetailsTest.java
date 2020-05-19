//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserIntegralHierarchyService;
//import com.xyb.gas.user.api.enums.UserGrade;
//import com.xyb.gas.user.api.order.QueryUserRuleOrder;
//import com.xyb.gas.user.api.order.UserGradeOrder;
//import com.xyb.gas.user.api.result.info.UserIntegralResetRuleInfo;
//import com.xyb.gas.user.api.result.info.UserLevelRuleInfo;
//import com.xyb.gas.user.api.result.info.UserRuleInfo;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_user.UserIntegralResetRuleDO;
//import dal.model.gas_user.UserLevelRuleDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/11/26.
// */
//public class UserIntegralHierarchyServiceQueryRuleDetailsTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_user/userIntegralHierarchyServiceQueryRuleDetailsTestSuccess.csv")
//	@DisplayName("会员规则详情--成功用例")
//	public void userIntegralHierarchyServiceQueryRuleDetailsTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			QueryUserRuleOrder order,
//			GasMerchantDO gasMerchantDO,
//			UserLevelRuleDO userLevelRuleDO,
//			UserIntegralResetRuleDO userIntegralResetRuleDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(userLevelRuleDO.getPartnerId());
////		gasUserTestBase.cleanUserByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(userIntegralResetRuleDO.getPartnerId());
//		// 准备数据
//		UserGradeOrder commonOrder=new UserGradeOrder();
//		commonOrder.setMin(1);
//		commonOrder.setMax(100);
//		commonOrder.setUserGradeCode(UserGrade.GRADE_COMMON.code());
//		UserGradeOrder silverOrder=new UserGradeOrder();
//		silverOrder.setMin(101);
//		silverOrder.setMax(500);
//		silverOrder.setUserGradeCode(UserGrade.GRADE_SILVER.code());
//		UserGradeOrder goldOrder=new UserGradeOrder();
//		goldOrder.setMin(501);
//		goldOrder.setMax(1000);
//		goldOrder.setUserGradeCode(UserGrade.GRADE_GOLD.code());
//		UserGradeOrder diamondsOrder=new UserGradeOrder();
//		diamondsOrder.setMin(1001);
//		diamondsOrder.setUserGradeCode(UserGrade.GRADE_DIAMONDS.code());
//		List<UserGradeOrder> levelRule = new ArrayList<UserGradeOrder>();
//		levelRule.add(commonOrder);
//		levelRule.add(silverOrder);
//		levelRule.add(goldOrder);
//		levelRule.add(diamondsOrder);
//		List<String> days = new ArrayList<String>();
//		if(testId==1001){//每年： MM-DD 01-01
//			days.add("01-01");
//		}
//		if(testId==1003) {//定时:YYYY-MM-DD  2018-01-01
//			days.add("2018-11-27");
//			days.add("2018-12-27");
//		}
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//		if(testId!=1002) {
//			userLevelRuleDO.setLevelRule(JSON.toJSONString(levelRule).toString());
//			gasUserTestBase.insertUserLevelRule(userLevelRuleDO);
//		}
//		if(testId>=1002) {
//			userIntegralResetRuleDO.setDays(JSON.toJSONString(days).toString());
//			gasUserTestBase.insertUserIntegralResetRule(userIntegralResetRuleDO);
//		}
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		BizResult<UserRuleInfo> result = userIntegralHierarchyService.queryRuleDetails(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		UserIntegralResetRuleInfo userIntegralResetRuleInfo=result.getInfo().getUserIntegralResetRuleInfo();
//		if(testId==1001){
//			assertEquals(null,userIntegralResetRuleInfo);
//		}else {
//			assertEquals(order.getPartnerId(),userIntegralResetRuleInfo.getPartnerId());
//			assertEquals(Boolean.valueOf(userIntegralResetRuleDO.getResetSwitch()),userIntegralResetRuleInfo.isResetSwitch());
//			assertEquals(userIntegralResetRuleDO.getIntegralResetType(),userIntegralResetRuleInfo.getIntegralResetType().code());
//			if(testId==1003){
//				assertEquals(null,userIntegralResetRuleInfo.getUseTimeUnit());
//			}else {
//				assertEquals(userIntegralResetRuleDO.getUseTimeUnit(),userIntegralResetRuleInfo.getUseTimeUnit().code());
//			}
//		}
//		UserLevelRuleInfo userLevelRuleInfo=result.getInfo().getUserLevelRuleInfo();
//		if(testId==1002){
//			assertEquals(null,userLevelRuleInfo);
//		}else {
//			assertEquals(userLevelRuleDO.getLevelUpdateType(),userLevelRuleInfo.getLevelUpdateType().code());
//			assertEquals(userLevelRuleDO.getLevelRule(),JSON.toJSONString(userLevelRuleInfo.getLevelRule()).toString());
//			if(testId==1003){
//				assertEquals(null,userLevelRuleInfo.getUseTimeUnit());
//			}else {
//				assertEquals(userLevelRuleDO.getUseTimeUnit(),userLevelRuleInfo.getUseTimeUnit().code());
//			}
//			assertEquals(userLevelRuleDO.getCumulativeOfDays().intValue(),userLevelRuleInfo.getCumulativeOfDays());
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(userLevelRuleDO.getPartnerId());
////		gasUserTestBase.cleanUserByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(userIntegralResetRuleDO.getPartnerId());
//	}
//}
