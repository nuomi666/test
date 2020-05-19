//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MallExchangeService;
//import com.xyb.gas.merchant.api.order.CheckExchangeGoodsOrder;
//import dal.model.gas_merchant.GasMallExchangeGoodsDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/08.
// */
//public class MallExchangeServiceCheckExchangeTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    MallExchangeService mallExchangeService;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/mallExchangeServiceCheckExchangeTestSuccess.csv")
//	@DisplayName("核销商品--成功用例")
//	public void mallExchangeServiceCheckExchangeTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			CheckExchangeGoodsOrder order,
//			GasMallExchangeGoodsDO gasMallExchangeGoodsDO,
//			GasMallExchangeGoodsDO gasMallExchangeGoodsDO1
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO1.getPartnerId());
//		// 准备数据
//		//	gasMallExchangeGoodsDO.setGainStation("[\"001if9yazl84g025eh00\",\"001if9yaxy78g025eh00\"]");
//		gasMallExchangeGoodsDO1.setGainStation("[\"001if9yazl84g025eh00\"]");
//		gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO);
//		gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO1);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = mallExchangeService.checkExchange(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO1.getPartnerId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/mallExchangeServiceCheckExchangeTestFailTwo.csv")
//	@DisplayName("核销商品--失败用例")
//	public void mallExchangeServiceCheckExchangeTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			CheckExchangeGoodsOrder order,
//			GasMallExchangeGoodsDO gasMallExchangeGoodsDO,
//			GasMallExchangeGoodsDO gasMallExchangeGoodsDO1
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO1.getPartnerId());
//		// 准备数据
//		if (testId != 1002) {
//			//	gasMallExchangeGoodsDO.setGainStation("[\"001if9yazl84g025eh00\",\"001if9yaxy78g025eh00\"]");
//			gasMallExchangeGoodsDO1.setGainStation("[\"001if9yazl84g025eh00\"]");
//		}
//		gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO);
//		gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO1);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = mallExchangeService.checkExchange(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO.getPartnerId());
//		gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO1.getPartnerId());
//	}
//}
