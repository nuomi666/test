package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.CollectionModel;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.ManageMerchantStationOrder;
import com.xyb.gas.merchant.api.order.OilGunOrder;
import dal.model.gas_merchant.GasMerchantStationDO;
import dal.model.gas_merchant.GasStationOilGunDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/28.
 */
public class MerchantStationServiceManageTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 新增的油站根据商家的模式来决定是否可以独立收银：Merchant-商户（统一商家收银）；MerchantAndStation-商户和油站（油站可以独立收银）
     * 1001新增不能独立收银的油站，不带油枪信息
     * 1002新增可以独立收银的油站，带油枪信息
     * 1003对不能独立收银的油站进行修改
     * 1004对可以独立收银的油站进行修改
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageTestSuccess.csv")
    @DisplayName("商户管理油站--成功用例")
    public void merchantStationServiceManageTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageMerchantStationOrder order,
            CollectionModel model,
            OilGunOrder oilGunOrder,
            OilGunOrder oilGunOrder1
    ) {
        // 清除数据

        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPartnerId(), null, null, null, null, null, null,
                model.code(), null, "ABLE");
        if (testId >= 1003) {
            gasMerchantInitDataBase.initStationsWithOilGun(order.getPartnerId(), order.getStationId(), null, null,
                    null, EnableStatus.ABLE.code(), null, null, null, null);
        }
        //干扰数据

        // 测试过程
        if (testId == 1001 || testId == 1002) {
            order.setStationId(null);
        }
        Set<OilGunOrder> oilGunOrders = Sets.newHashSet();
        oilGunOrders.add(oilGunOrder);
        if (testId == 1004) {
            oilGunOrders.add(oilGunOrder1);
        }
        if (testId == 1002 || testId == 1004) {
            //order.setOilGunOrders(oilGunOrders);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantStationService.manage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //油站信息
        Map<String, String> param = gasMerchantStationAssert(1, order.getPlatPartnerId(), order.getPartnerId(),
                order.getStationCode(), order.getStationName(), order.getCityId(), order.getDistrictId(),
                order.getProvinceId(), order.getStationAddress(), order.getPhoneNo(), "ABLE");
        //分析数据
        silverboltStationAssert(1, order.getPlatPartnerId(), order.getPartnerId(),
                order.getStationCode(), order.getStationName(), order.getCityId(), order.getDistrictId(),
                order.getProvinceId(), order.getStationAddress(), order.getPhoneNo(), "ABLE");
        //油枪信息
        if (testId == 1002) {
            oilGunAssert(1, order.getPlatPartnerId(), null, param.get("stationId"),
                    oilGunOrder.getOilGunNo(), oilGunOrder1.getOilGunNo(), oilGunOrder.getGoodsCode(),
                    oilGunOrder1.getGoodsCode(), oilGunOrder.getSortNo(), oilGunOrder1.getSortNo());
        }
        if (testId == 1004) {
            oilGunAssert(2, order.getPlatPartnerId(), order.getPartnerId(), order.getStationId(),
                    oilGunOrder.getOilGunNo(), oilGunOrder1.getOilGunNo(), oilGunOrder.getGoodsCode(),
                    oilGunOrder1.getGoodsCode(), oilGunOrder.getSortNo(), oilGunOrder1.getSortNo());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(order.getPartnerId());
        if (testId <= 1002) {
            gasMerchantTestBase.cleanGasMerchantStationByStationId(param.get("stationId"));
            gasMerchantTestBase.cleanGasStationOilGunByStationId(param.get("stationId"));
        } else {
            gasMerchantTestBase.cleanGasMerchantStationByStationId(order.getStationId());
            gasMerchantTestBase.cleanGasStationOilGunByStationId(order.getStationId());
        }
    }

    @AutoTest(file = "gas_merchant/merchantStationServiceManageTestFailOne.csv")
    @DisplayName("商户管理油站--参数非法")
    public void merchantStationServiceManageTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageMerchantStationOrder order
    ) {
        // 清除数据

        // 准备数据

        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setStationCode(null);
        }
        if (testId == 1002) {
            order.setStationName(null);
        }
        if (testId == 1003) {
            order.setPhoneNo(null);
        }
        if (testId == 1004) {
            order.setStationAddress(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantStationService.manage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.添加油站时，商户不存在
     * 1002.修改油站时，油站不存在
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageTestFailTwo.csv")
    @DisplayName("商户管理油站--失败用例")
    public void merchantStationServiceManageTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageMerchantStationOrder order,
            CollectionModel model,
            OilGunOrder oilGunOrder,
            OilGunOrder oilGunOrder1
    ) {
        // 清除数据

        // 准备数据
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasMerchant(order.getPartnerId(), null, null, null, null, null, null,
                    "Merchant", null, "ABLE");
        }
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setStationId(null);
        }
        // 调用接口
        SimpleResult result = merchantStationService.manage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(order.getPartnerId());
    }

    /**
     * 商家油站
     *
     * @param count
     * @param platPartnerId
     * @param partnerId
     * @param stationCode
     * @param stationName
     * @param cityId
     * @param districtId
     * @param provinceId
     * @param stationAddress
     * @param phoneNo
     * @param status
     * @return
     */
    private Map<String, String> gasMerchantStationAssert(
            int count,
            String platPartnerId,
            String partnerId,
            String stationCode,
            String stationName,
            Long cityId,
            Long districtId,
            Long provinceId,
            String stationAddress,
            String phoneNo,
            String status
    ) {
        List<GasMerchantStationDO> stations = gasMerchantTestBase.findGasMerchantStationByStationCode(stationCode);
        if (count > 0) {
            assertTrue(stations.size() == count);
            for (GasMerchantStationDO station : stations) {
                assertEquals(stationCode, station.getStationCode());
                assertEquals(stationName, station.getStationName());
                assertEquals(cityId, station.getCityId());
                assertEquals(districtId, station.getDistrictId());
                assertEquals(platPartnerId, station.getPlatPartnerId());
                assertEquals(partnerId, station.getPartnerId());
                assertEquals(phoneNo, station.getPhoneNo());
                assertEquals(provinceId, station.getProvinceId());
                assertEquals(stationAddress, station.getStationAddress());
                //assertEquals(order.getStationId(), station.getStationId());
                assertEquals(status, station.getStatus());
                assertEquals((byte) 0, station.getConnectOilMachine());
//                assertEquals(stationAddress, station.getLatitude());
//                assertEquals(stationAddress, station.getLongitude());
            }
        }
        Map<String, String> param = Maps.newHashMap();
        param.put("stationId",
                gasMerchantTestBase.findGasMerchantStationByStationCode(stationCode).get(0).getStationId());
        return param;
    }

    /**
     * 商家油站
     *
     * @param count
     * @param platPartnerId
     * @param partnerId
     * @param stationCode
     * @param stationName
     * @param cityId
     * @param districtId
     * @param provinceId
     * @param stationAddress
     * @param phoneNo
     * @param status
     * @return
     */
    private Map<String, String> silverboltStationAssert(
            int count,
            String platPartnerId,
            String partnerId,
            String stationCode,
            String stationName,
            Long cityId,
            Long districtId,
            Long provinceId,
            String stationAddress,
            String phoneNo,
            String status
    ) {
        List<dal.model.gas_silverbolt.GasMerchantStationDO> stations =
                silverboltTestBase.findGasMerchantStationByStationCode(stationCode);
        if (count > 0) {
            assertTrue(stations.size() == count);
            for (dal.model.gas_silverbolt.GasMerchantStationDO station : stations) {
                assertEquals(stationCode, station.getStationCode());
                assertEquals(stationName, station.getStationName());
                assertEquals(cityId, station.getCityId());
                assertEquals(districtId, station.getDistrictId());
                assertEquals(platPartnerId, station.getPlatPartnerId());
                assertEquals(partnerId, station.getPartnerId());
                assertEquals(phoneNo, station.getPhoneNo());
                assertEquals(provinceId, station.getProvinceId());
                assertEquals(stationAddress, station.getStationAddress());
                //assertEquals(order.getStationId(), station.getStationId());
                assertEquals(status, station.getStatus());
                assertEquals((byte) 0, station.getConnectOilMachine());
//                assertEquals(stationAddress, station.getLatitude());
//                assertEquals(stationAddress, station.getLongitude());
            }
        }
        Map<String, String> param = Maps.newHashMap();
        param.put("stationId",
                gasMerchantTestBase.findGasMerchantStationByStationCode(stationCode).get(0).getStationId());
        return param;
    }

    /**
     * 油枪
     *
     * @param count
     * @param platPartnerId
     * @param partnerId
     * @param stationId
     * @param oilGunNo
     * @param oilGunNo1
     * @param goodsCode
     * @param goodsCode1
     * @param sortNo
     * @param sortNo1
     */
    private void oilGunAssert(
            int count,
            String platPartnerId,
            String partnerId,
            String stationId,
            String oilGunNo,
            String oilGunNo1,
            String goodsCode,
            String goodsCode1,
            int sortNo,
            int sortNo1
    ) {
        List<GasStationOilGunDO> oilGuns = gasMerchantTestBase.findGasStationOilGunByStationId(stationId);
        assertTrue(oilGuns.size() == count);
        if (count > 0) {
            for (GasStationOilGunDO oilGun : oilGuns) {
                assertEquals(platPartnerId, oilGun.getPlatPartnerId());
                assertEquals(partnerId, oilGun.getPartnerId());
                if (oilGunNo != null && oilGunNo.equals(oilGun.getOilGunNo())) {
                    assertEquals(goodsCode, oilGun.getGoodsCode());
                    assertEquals(sortNo, oilGun.getSortNo());
                }
                if (oilGunNo1 != null && oilGunNo1.equals(oilGun.getOilGunNo())) {
                    assertEquals(goodsCode1, oilGun.getGoodsCode());
                    assertEquals(sortNo1, oilGun.getSortNo());
                }
            }
        }
    }
}
