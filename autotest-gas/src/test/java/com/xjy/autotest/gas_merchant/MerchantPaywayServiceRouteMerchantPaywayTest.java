package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ApplyGoodsType;
import com.xyb.gas.merchant.api.enums.PaywayActionType;
import com.xyb.gas.merchant.api.enums.PaywayModelType;
import com.xyb.gas.merchant.api.enums.PaywayTerminalType;
import com.xyb.gas.merchant.api.facade.MerchantPaywayService;
import com.xyb.gas.merchant.api.info.payway.MerchantPaywayAttributeInfo;
import com.xyb.gas.merchant.api.info.payway.PaywaySceneInfo;
import com.xyb.gas.merchant.api.info.payway.RouteMerchantPaywayInfo;
import com.xyb.gas.merchant.api.order.payway.RouteMerchantPaywayOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/19.
 */
public class MerchantPaywayServiceRouteMerchantPaywayTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantPaywayService merchantPaywayService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceRouteMerchantPaywayTestSuccess.csv")
    @DisplayName("路由可用支付方式--成功用例")
    public void merchantPaywayServiceRouteMerchantPaywayTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String payWayCode, String payWayName,
            String payWayCode1, String payWayName1,
            String payWayCode2, String payWayName2,
            String payWayType,
            String barCode, ApplyGoodsType applyGoodsType,
            PaywayTerminalType paywayTerminalType, PaywayTerminalType paywayTerminalType1,
            PaywayTerminalType paywayTerminalType2,
            PaywayModelType paywayModelType, PaywayModelType paywayModelType1,
            PaywayModelType paywayModelType2, PaywayActionType paywayActionType,
            String payWayStatus, boolean print,
            RouteMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 准备数据
        //gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, payWayCode,
        //        barCode, null, applyGoodsType,
        //        paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        //2
        //gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode1, payWayName1, null, payWayCode1,
        //        null, null, applyGoodsType,
        //        paywayTerminalType1, paywayModelType1, paywayActionType, payWayStatus, print);
        //3
        //gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode2, payWayName2, null, payWayCode2,
        //        null, null, applyGoodsType,
        //        paywayTerminalType2, paywayModelType2, paywayActionType, payWayStatus, print);
        // 调用接口
        PagedResult<RouteMerchantPaywayInfo> result = merchantPaywayService.routeMerchantPayway(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<RouteMerchantPaywayInfo> payWayInfos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, payWayInfos.size());
        } else if (testId == 1002) {
            assertEquals(2, payWayInfos.size());
        } else {
            assertEquals(1, payWayInfos.size());
        }
        if (testId <= 1003) {//返回的数据无序的，就这么校验了
            for (RouteMerchantPaywayInfo payWayInfo : payWayInfos) {
                if (payWayCode.equals(payWayInfo.getPaywayCode())) {
                    assertEquals(platPartnerId, payWayInfo.getPartnerId());
                    assertEquals(payWayType, payWayInfo.getPaywayType());
                    assertEquals(payWayName, payWayInfo.getPaywayName());
                    assertEquals(null, payWayInfo.getPaywayIcon());
                    assertEquals(null, payWayInfo.getPaywaySmallIcon());
                    PaywaySceneInfo paywaySceneInfo = payWayInfo.getPaywaySceneInfo();
                    paywaySceneInfo.getActionTerminalMap().get(paywayActionType).contains(paywayTerminalType);
                    paywaySceneInfo.getBarCodeList().contains(barCode);
                    paywaySceneInfo.getModelList().contains(paywayModelType);
                    assertEquals(null, paywaySceneInfo.getApiPartnerId());
                    assertEquals(applyGoodsType, paywaySceneInfo.getApplyGoodsType());
                    assertEquals(0, paywaySceneInfo.getStationList().size());
                    MerchantPaywayAttributeInfo paywayAttributeInfo = payWayInfo.getPaywayAttributeInfo();
                    assertEquals(print, paywayAttributeInfo.isPrint());
                }
                if (payWayCode1.equals(payWayInfo.getPaywayCode())) {
                    assertEquals(platPartnerId, payWayInfo.getPartnerId());
                    assertEquals(null, payWayInfo.getPaywayType());
                    assertEquals(payWayName1, payWayInfo.getPaywayName());
                    assertEquals(null, payWayInfo.getPaywayIcon());
                    assertEquals(null, payWayInfo.getPaywaySmallIcon());
                    PaywaySceneInfo paywaySceneInfo = payWayInfo.getPaywaySceneInfo();
                    paywaySceneInfo.getActionTerminalMap().get(paywayActionType).contains(paywayTerminalType1);
                    assertEquals(0, paywaySceneInfo.getBarCodeList().size());
                    paywaySceneInfo.getModelList().contains(paywayModelType1);
                    assertEquals(null, paywaySceneInfo.getApiPartnerId());
                    assertEquals(applyGoodsType, paywaySceneInfo.getApplyGoodsType());
                    assertEquals(0, paywaySceneInfo.getStationList().size());
                    MerchantPaywayAttributeInfo paywayAttributeInfo = payWayInfo.getPaywayAttributeInfo();
                    assertEquals(print, paywayAttributeInfo.isPrint());
                }
                if (payWayCode2.equals(payWayInfo.getPaywayCode())) {
                    assertEquals(platPartnerId, payWayInfo.getPartnerId());
                    assertEquals(null, payWayInfo.getPaywayType());
                    assertEquals(payWayName2, payWayInfo.getPaywayName());
                    assertEquals(null, payWayInfo.getPaywayIcon());
                    assertEquals(null, payWayInfo.getPaywaySmallIcon());
                    PaywaySceneInfo paywaySceneInfo = payWayInfo.getPaywaySceneInfo();
                    paywaySceneInfo.getActionTerminalMap().get(paywayActionType).contains(paywayTerminalType2);
                    assertEquals(0, paywaySceneInfo.getBarCodeList().size());
                    paywaySceneInfo.getModelList().contains(paywayModelType2);
                    assertEquals(null, paywaySceneInfo.getApiPartnerId());
                    assertEquals(applyGoodsType, paywaySceneInfo.getApplyGoodsType());
                    assertEquals(0, paywaySceneInfo.getStationList().size());
                    MerchantPaywayAttributeInfo paywayAttributeInfo = payWayInfo.getPaywayAttributeInfo();
                    assertEquals(print, paywayAttributeInfo.isPrint());
                }
            }
        }
        // 清除数据
        //gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(platPartnerId, payWayCode);
        //gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(platPartnerId, payWayCode1);
        //gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(platPartnerId, payWayCode2);
        //gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(platPartnerId, payWayCode);
        //gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(platPartnerId, payWayCode1);
        //gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(platPartnerId, payWayCode2);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceRouteMerchantPaywayTestFailOne.csv")
    @DisplayName("路由可用支付方式--参数非法")
    public void merchantPaywayServiceRouteMerchantPaywayTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RouteMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 准备数据
        // 调用接口
        PagedResult<RouteMerchantPaywayInfo> result = merchantPaywayService.routeMerchantPayway(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
