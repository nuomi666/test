//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.merchant.api.enums.GoodsType;
//import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
//import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
//import com.xyb.gas.merchant.api.order.ManageMerchantGoodsPricePlanOrder;
//import dal.model.gas_merchant.GasMerchantGoodsPricePlanDO;
//import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/10.
// */
//public class MerchantGoodsServiceManageMerchantPricePlanTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_merchant/merchantGoodsServiceManageMerchantPricePlanTestSuccess.csv")
//	@DisplayName("商家管理商品价格计划--成功用例")
//	public void merchantGoodsServiceManageMerchantPricePlanTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			ManageMerchantGoodsPricePlanOrder order,
//			GoodsPriceOrder goodsPriceOrder,
//			GoodsPriceOrder goodsPriceOrder1,
//			GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO,
//			GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO,
//			GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO1
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(order.getPriceName());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPriceName(order.getPriceName());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO1.getPlanId());
//		// 准备数据
//		Set<GoodsPriceOrder> goodsPriceOrdersxx = Sets.newHashSet();
//		GoodsPriceOrder goodsPriceOrderxx = new GoodsPriceOrder();
//		GoodsPriceOrder goodsPriceOrderxx1 = new GoodsPriceOrder();
//		goodsPriceOrderxx.setGoodsName("95号汽油");
//		goodsPriceOrderxx.setGoodsCode("#95");
//		goodsPriceOrderxx.setGoodsType(GoodsType.OIL);
//		goodsPriceOrderxx.setGoodsPrice(new Money(15, 20));
//		goodsPriceOrdersxx.add(goodsPriceOrderxx);
//		String goodsInfos = JSON.toJSONString(goodsPriceOrdersxx);
//		goodsPriceOrderxx1.setGoodsName("87号汽油");
//		goodsPriceOrderxx1.setGoodsCode("#87");
//		goodsPriceOrderxx1.setGoodsType(GoodsType.OIL);
//		goodsPriceOrderxx1.setGoodsPrice(new Money(17, 10));
//		goodsPriceOrdersxx.add(goodsPriceOrderxx1);
//		String goodsInfosxx = JSON.toJSONString(goodsPriceOrdersxx);
//		System.out.println(goodsInfos);
//		System.out.println(goodsInfosxx);
//		gasMerchantGoodsPricePlanDO.setGoodsInfo(goodsInfosxx);
//		if (testId == 1006) {
//			gasStationGoodsPricePlanDO.setGoodsInfo(goodsInfos);
//		} else {
//			gasStationGoodsPricePlanDO.setGoodsInfo(goodsInfosxx);
//		}
//		gasStationGoodsPricePlanDO1.setGoodsInfo(goodsInfosxx);
//		if (testId >= 1003) {
//			gasMerchantTestBase.insertGasMerchantGoodsPricePlan(gasMerchantGoodsPricePlanDO);
//			gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDO);
//		}
//		if (testId >= 1004) {
////			gasMerchantTestBase.insertGasMerchantGoodsPricePlan(gasMerchantGoodsPricePlanDO);
//			gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDO1);
//		}
//		// 测试过程
//		Set<String> stationIds = Sets.newHashSet();
//		stationIds.add(gasStationGoodsPricePlanDO.getStationId());
//		if (testId != 1001) {
//			stationIds.add(gasStationGoodsPricePlanDO1.getStationId());
//		}
//		Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
//		goodsPriceOrders.add(goodsPriceOrder);
//		if (testId != 1001) {
//			goodsPriceOrders.add(goodsPriceOrder1);
//		}
//		order.setStationIds(stationIds);
//		order.setGoodsPriceOrders(goodsPriceOrders);
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = merchantGoodsService.manageMerchantPricePlan(order);
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasMerchantGoodsPricePlanDO> merchantGoodsPricePlanS = gasMerchantTestBase.findGasMerchantGoodsPricePlanByPriceName(order.getPriceName());
//		assertEquals(1, merchantGoodsPricePlanS.size());
//		for (GasMerchantGoodsPricePlanDO merchantGoodsPricePlan : merchantGoodsPricePlanS) {
//			assertEquals("Y", merchantGoodsPricePlan.getDeleteFlag());
//			assertEquals(order.getPartnerId(), merchantGoodsPricePlan.getPartnerId());
//			assertEquals(order.getPriceName(), merchantGoodsPricePlan.getPriceName());
//			assertEquals(order.getEffectTime(), merchantGoodsPricePlan.getEffectTime());
////			assertEquals(JSON.toJSONString(goodsPriceOrders), merchantGoodsPricePlan.getGoodsInfo());
//			JSONArray jsonArray = JSONArray.parseArray(merchantGoodsPricePlan.getGoodsInfo());
//			if (testId == 1001) {
//				assertTrue(jsonArray.size() == 1);
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject goodsJson = jsonArray.getJSONObject(i);
//					JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
//					assertEquals(goodsPriceOrder.getGoodsName(), goodsJson.get("goodsName").toString());
//					assertEquals(goodsPriceOrder.getGoodsType().code(), goodsJson.get("goodsType").toString());
//					assertEquals(goodsPriceOrder.getGoodsCode(), goodsJson.get("goodsCode").toString());
//					assertEquals(goodsPriceOrder.getGoodsPrice().toString(), priceJson.get("amount").toString());
//				}
//			} else {
//				assertTrue(jsonArray.size() == 2);
//				List<String> goodsCode = new ArrayList<>();
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject goodsJson = jsonArray.getJSONObject(i);
//					JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
//					goodsCode.add(goodsJson.get("goodsCode").toString());
//					if (goodsPriceOrder.getGoodsCode().equals(goodsJson.get("goodsCode").toString())) {
//						assertEquals(goodsPriceOrder.getGoodsName(), goodsJson.get("goodsName").toString());
//						assertEquals(goodsPriceOrder.getGoodsType().code(), goodsJson.get("goodsType").toString());
//						assertEquals(goodsPriceOrder.getGoodsPrice().toString(), priceJson.get("amount").toString());
//					}
//					if (goodsPriceOrder1.getGoodsCode().equals(goodsJson.get("goodsCode").toString())) {
//						assertEquals(goodsPriceOrder1.getGoodsName(), goodsJson.get("goodsName").toString());
//						assertEquals(goodsPriceOrder1.getGoodsType().code(), goodsJson.get("goodsType").toString());
//						assertEquals(goodsPriceOrder1.getGoodsPrice().toString(), priceJson.get("amount").toString());
//					}
//				}
//				assertTrue(goodsCode.contains(goodsPriceOrder.getGoodsCode()));
//				assertTrue(goodsCode.contains(goodsPriceOrder1.getGoodsCode()));
//			}
//		}
//		List<GasStationGoodsPricePlanDO> stationGoodsPricePlanS = gasMerchantTestBase.findGasStationGoodsPricePlanByMerchantPlanId(merchantGoodsPricePlanS.get(0).getPlanId()).stream().filter(
//				(sta) -> ("Y".equals(sta.getDeleteFlag()))).collect(Collectors.toList());
//		if (testId == 1001) {
//			assertEquals(1, stationGoodsPricePlanS.size());
//		} else {
//			assertEquals(2, stationGoodsPricePlanS.size());
//		}
//		List<String> stationIdsxx = new ArrayList<>();
//		for (GasStationGoodsPricePlanDO stationGoodsPricePlan : stationGoodsPricePlanS) {
//			assertEquals("Y", stationGoodsPricePlan.getDeleteFlag());
//			assertEquals(order.getPartnerId(), stationGoodsPricePlan.getPartnerId());
//			assertEquals(order.getPriceName(), stationGoodsPricePlan.getPriceName());
//			assertEquals(order.getEffectTime(), stationGoodsPricePlan.getEffectTime());
//			assertEquals(merchantGoodsPricePlanS.get(0).getGoodsInfo(), stationGoodsPricePlan.getGoodsInfo());
//			stationIdsxx.add(stationGoodsPricePlan.getStationId());
//		}
////		if (testId==1001) {
////			assertTrue(stationIdsxx.contains("001if9yaxy78g025eh00"));
////		} else {
////			assertTrue(stationIdsxx.contains("001if9yaxy78g025eh00"));
////			assertTrue(stationIdsxx.contains("001if9yazl84g025eh00"));
////		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(gasMerchantGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(order.getPriceName());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByMerchantPlanId(merchantGoodsPricePlanS.get(0).getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO1.getPlanId());
//	}
//}
