//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.fastjson.JSON;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
//import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
//import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
//import dal.model.gas_merchant.GasMerchantGoodsPricePlanDO;
//import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/11.
// */
//public class MerchantGoodsServiceRemoveMerchantPricePlanTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    MerchantGoodsService merchantGoodsService;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/merchantGoodsServiceRemoveMerchantPricePlanTestSuccess.csv")
//	@DisplayName("商户删除商品价格计划--成功用例")
//	public void merchantGoodsServiceRemoveMerchantPricePlanTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			CommonBaseOrder order,
//			GoodsPriceOrder goodsPriceOrder,
//			GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO,
//			GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDOxx,
//			GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO,
//			GasStationGoodsPricePlanDO gasStationGoodsPricePlanDOxx
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDOxx.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByMerchantPlanId(gasMerchantGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByMerchantPlanId(gasMerchantGoodsPricePlanDOxx.getPlanId());
//		// 准备数据
//		Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
//		goodsPriceOrders.add(goodsPriceOrder);
//		gasMerchantGoodsPricePlanDO.setGoodsInfo(JSON.toJSONString(goodsPriceOrders));
//		gasMerchantTestBase.insertGasMerchantGoodsPricePlan(gasMerchantGoodsPricePlanDO);
//		gasStationGoodsPricePlanDO.setGoodsInfo(JSON.toJSONString(goodsPriceOrders));
//		gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDO);
//		if(testId==1002){
//			gasStationGoodsPricePlanDO.setId(99999L);
//			gasStationGoodsPricePlanDO.setPlanId(OID.newID());
//			gasStationGoodsPricePlanDO.setStationId(OID.newID());
//			gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDO);
//		}
//		gasMerchantGoodsPricePlanDOxx.setGoodsInfo(JSON.toJSONString(goodsPriceOrders));
//		gasMerchantTestBase.insertGasMerchantGoodsPricePlan(gasMerchantGoodsPricePlanDOxx);
//		gasStationGoodsPricePlanDOxx.setGoodsInfo(JSON.toJSONString(goodsPriceOrders));
//		gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDOxx);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = merchantGoodsService.removeMerchantPricePlan(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasMerchantGoodsPricePlanDO> merchantGoodsPricePlanS = gasMerchantTestBase.findGasMerchantGoodsPricePlanByPlanId(order.getId()).stream().filter(
//				(mer) -> ("Y".equals(mer.getDeleteFlag()))).collect(Collectors.toList());
//		assertEquals(0,merchantGoodsPricePlanS.size());
//		List<GasMerchantGoodsPricePlanDO> merchantGoodsPricePlanSxx = gasMerchantTestBase.findGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDOxx.getPlanId()).stream().filter(
//				(mer) -> ("Y".equals(mer.getDeleteFlag()))).collect(Collectors.toList());
//		assertEquals(1,merchantGoodsPricePlanSxx.size());
//		List<GasStationGoodsPricePlanDO> stationGoodsPricePlanS = gasMerchantTestBase.findGasStationGoodsPricePlanByMerchantPlanId(gasMerchantGoodsPricePlanDO.getPlanId()).stream().filter(
//				(sta) -> ("Y".equals(sta.getDeleteFlag()))).collect(Collectors.toList());
//		assertEquals(0,stationGoodsPricePlanS.size());
//		List<GasStationGoodsPricePlanDO> stationGoodsPricePlanSxx = gasMerchantTestBase.findGasStationGoodsPricePlanByMerchantPlanId(merchantGoodsPricePlanSxx.get(0).getPlanId()).stream().filter(
//				(sta) -> ("Y".equals(sta.getDeleteFlag()))).collect(Collectors.toList());
//		assertEquals(1,stationGoodsPricePlanSxx.size());
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDOxx.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByMerchantPlanId(gasMerchantGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByMerchantPlanId(gasMerchantGoodsPricePlanDOxx.getPlanId());
//	}
//}
