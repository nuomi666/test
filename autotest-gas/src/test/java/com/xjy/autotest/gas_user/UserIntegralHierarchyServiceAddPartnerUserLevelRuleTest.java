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
//import com.xyb.gas.user.api.enums.UserGrade;
//import com.xyb.gas.user.api.order.AddUserLevelRuleOrder;
//import com.xyb.gas.user.api.order.UserGradeOrder;
//import dal.model.gas_merchant.GasMerchantDO;
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
//public class UserIntegralHierarchyServiceAddPartnerUserLevelRuleTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserLevelRuleTestSuccess.csv")
//	@DisplayName("保存会员等级规则--成功用例")
//	public void userIntegralHierarchyServiceAddPartnerUserLevelRuleTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddUserLevelRuleOrder order,
//			GasMerchantDO gasMerchantDO,
//			UserLevelRuleDO userLevelRuleDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(userLevelRuleDO.getPartnerId());
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
//		gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//		if(testId>=1004) {
//			userLevelRuleDO.setLevelRule(JSON.toJSONString(levelRule).toString());
//			gasUserTestBase.insertUserLevelRule(userLevelRuleDO);
//		}
//		// 测试过程
//		order.setLevelRule(levelRule);
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = userIntegralHierarchyService.addPartnerUserLevelRule(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<UserLevelRuleDO> levelRules=gasUserTestBase.findUserLevelRuleByPartnerId(order.getPartnerId());
//		assertEquals(1,levelRules.size());
//		for(UserLevelRuleDO rule:levelRules){
//			assertEquals(order.getPartnerId(),rule.getPartnerId());
//			assertEquals(order.getLevelUpdateType().code(),rule.getLevelUpdateType());
//			assertEquals(JSON.toJSONString(levelRule).toString(),rule.getLevelRule());
//			assertEquals(order.getUseTimeUnit().toString(),rule.getUseTimeUnit());
//			assertEquals(order.getCumulativeOfDays(),rule.getCumulativeOfDays().intValue());
////			assertEquals(order.getPartnerId(),rule.getTime());
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(order.getPartnerId());
//		gasUserTestBase.cleanUserLevelRuleByPartnerId(userLevelRuleDO.getPartnerId());
//	}
//}
