package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.BaseUtil;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.PrintType;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.facade.UserLoginService;
import com.xyb.gas.merchant.api.info.UserWorkStatisticsInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkFavourInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkGoodsInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkOilInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkTradeInfo;
import com.xyb.gas.merchant.api.order.UserLogoutPosOrder;
import dal.model.gas_merchant.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi@xyb.com
 * Created on 2018/10/23.
 */
public class UserLoginServiceLogoutPosTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserLoginService userLoginService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLogoutPosTestSuccess.csv")
    @DisplayName("登出pos机--成功用例")
    public void userLoginServiceLogoutPosTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserLogoutPosOrder order,
            GasMerchantDO gasMerchantDO,
            GasMerchantUserDO gasMerchantUserDO,
            GasRoleDO gasRoleDO,
            GasDeviceResourceDO gasDeviceResourceDO,
            GasMerchantSourceDataDO gasMerchantSourceDataDO,
            GasMerchantStationDO gasMerchantStationDO,
            GasGoodsDO gasGoodsDO
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
        gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDO.getRoleName());
        gasMerchantTestBase.cleanGasDeviceResourceByCode(gasDeviceResourceDO.getCode());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantStationByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasStationOilGunByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(gasGoodsDO.getGoodsCode());
        gasMerchantTestBase.cleanGasMerchantGoodsByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantDeviceByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasDevicePrintByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasLoginLogByUserId(gasMerchantUserDO.getUserId());
        // 准备数据
        Date loginTime = DateUtils.parseDate2("2018-10-24 14:38:56");
        //商户数据
        String passwordEnum = BaseUtil.encrypt("123456", gasMerchantUserDO.getSalt());
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
        //角色
        gasMerchantTestBase.insertGasRole(gasRoleDO);
        List<GasRoleDO> roles = gasMerchantTestBase.findGasRoleByRoleName(gasRoleDO.getRoleName());
        //商户用户
        gasMerchantUserDO.setRoleId(roles.get(0).getId());
        gasMerchantUserDO.setPassword(passwordEnum);
        gasMerchantTestBase.insertGasMerchantUser(gasMerchantUserDO);
        //商户角色关联
        GasMerchantRoleDO gasMerchantRoleDO = new GasMerchantRoleDO();
        gasMerchantRoleDO.setRoleId(roles.get(0).getId());
        gasMerchantRoleDO.setPlatPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.insertGasMerchantRole(gasMerchantRoleDO);
        //配置终端资源
        gasMerchantTestBase.insertGasDeviceResource(gasDeviceResourceDO);
        List<GasDeviceResourceDO> deviceResources =
                gasMerchantTestBase.findGasDeviceResourceByCode(gasDeviceResourceDO.getCode());
        //资源角色关联表
        GasMerchantRoleResourceDO gasMerchantRoleResourceDO = new GasMerchantRoleResourceDO();
        gasMerchantRoleResourceDO.setResourceId(deviceResources.get(0).getId());
        gasMerchantRoleResourceDO.setRoleId(roles.get(0).getId());
        gasMerchantTestBase.insertGasMerchantRoleResource(gasMerchantRoleResourceDO);
        //资源商户关联（pos机专用？？？）
        GasMerchantResourceDO gasMerchantResourceDO = new GasMerchantResourceDO();
        gasMerchantResourceDO.setResourceId(deviceResources.get(0).getId());
        gasMerchantResourceDO.setPlatPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.insertGasMerchantResource(gasMerchantResourceDO);
        //油站
        gasMerchantTestBase.insertGasMerchantStation(gasMerchantStationDO);
        //商品
        gasMerchantTestBase.insertGasGoods(gasGoodsDO);
        GasMerchantGoodsDO gasMerchantGoodsDO = new GasMerchantGoodsDO();
        gasMerchantGoodsDO.setGoodsCode(gasGoodsDO.getGoodsCode());
        gasMerchantGoodsDO.setGoodsName(gasGoodsDO.getGoodsName());
        gasMerchantGoodsDO.setGoodsType(gasGoodsDO.getGoodsType());
        gasMerchantGoodsDO.setGroupId(gasGoodsDO.getGroupId());
        gasMerchantGoodsDO.setPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.insertGasMerchantGoods(gasMerchantGoodsDO);
        //配置油枪
        GasStationOilGunDO gasStationOilGunDO = new GasStationOilGunDO();
        gasStationOilGunDO.setOilGunNo("900");
        gasStationOilGunDO.setGoodsCode(gasGoodsDO.getGoodsCode());
        gasStationOilGunDO.setStationId(gasMerchantStationDO.getStationId());
        gasStationOilGunDO.setPartnerId(gasMerchantDO.getPartnerId());
        if (testId == 1003) {
            gasMerchantTestBase.insertGasStationOilGun(gasStationOilGunDO);
        }
        //关联油站
        GasMerchantUserStationDO gasMerchantUserStationDO = new GasMerchantUserStationDO();
        gasMerchantUserStationDO.setUserId(gasMerchantUserDO.getUserId());
        gasMerchantUserStationDO.setStationId(gasMerchantStationDO.getStationId());
        gasMerchantTestBase.insertGasMerchantUserStation(gasMerchantUserStationDO);
        //商户来源
        if (testId == 1001) {
            gasMerchantTestBase.insertGasMerchantSourceData(gasMerchantSourceDataDO);
        }
        //商家终端配置
        GasMerchantDeviceDO gasMerchantDeviceDO = new GasMerchantDeviceDO();
        gasMerchantDeviceDO.setPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantDeviceDO.setDeviceType(DeviceType.POS.code());
        gasMerchantDeviceDO.setDeviceCode("8a7ffd5b");
        gasMerchantDeviceDO.setLoginUserId(order.getUserId());//只有登录时才有userid
        gasMerchantDeviceDO.setLoginStatus(UserLoginStatus.login.code());
        gasMerchantTestBase.insertGasMerchantDevice(gasMerchantDeviceDO);
        //终端小票配置
        GasDevicePrintDO gasDevicePrintDO = new GasDevicePrintDO();
        gasDevicePrintDO.setPrintId(OID.newID());
        gasDevicePrintDO.setPartnerId(gasMerchantDO.getPartnerId());
        gasDevicePrintDO.setStationId(gasMerchantStationDO.getStationId());
        gasDevicePrintDO.setDeviceType(DeviceType.POS.code());
        gasDevicePrintDO.setPrintType(PrintType.Cashier.code());
        gasDevicePrintDO.setPrintSleep(5);
        gasDevicePrintDO.setPrintTitle("糯米测试小票打印");
        gasMerchantTestBase.insertGasDevicePrint(gasDevicePrintDO);
        //登录日志
        GasLoginLogDO gasLoginLogDO = new GasLoginLogDO();
        gasLoginLogDO.setPartnerId(gasMerchantDO.getPartnerId());
        gasLoginLogDO.setUserId(gasMerchantUserDO.getUserId());
        gasLoginLogDO.setUserName(gasMerchantUserDO.getUserName());
        gasLoginLogDO.setAccount(gasMerchantUserDO.getAccount());
        gasLoginLogDO.setDeviceCode(gasMerchantDeviceDO.getDeviceCode());
        gasLoginLogDO.setDeviceType(gasMerchantDeviceDO.getDeviceType());
        gasLoginLogDO.setRawAddTime(loginTime);
        gasMerchantTestBase.insertGasLoginLog(gasLoginLogDO);
        // 测试过程
        order.setUserId(gasMerchantUserDO.getUserId());
        order.setDeviceCode(gasMerchantDeviceDO.getDeviceCode());
        order.setGid(GID.newGID());
        // 调用接口
        BizResult<UserWorkStatisticsInfo> result = userLoginService.logoutPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        assertEquals(gasMerchantUserDO.getUserName(), result.getInfo().getUserName());
        assertEquals(gasMerchantStationDO.getStationName(), result.getInfo().getStationName());
        assertEquals(gasMerchantDO.getPartnerName(), result.getInfo().getSupplierName());
//		assertEquals(DeviceType.POS,result.getInfo().getDeviceType());
//		assertEquals(gasMerchantDeviceDO.getDeviceCode(),result.getInfo().getDeviceCode());
        assertEquals(loginTime, result.getInfo().getLoginTime());
//		assertEquals(DateUtils.getSqlDate(),result.getInfo().getLogoutTime());
        //班结优惠券优惠
        List<OperatorWorkFavourInfo> favourInfoList = result.getInfo().getFavourInfoList();
        assertEquals(2, favourInfoList.size());
        for (OperatorWorkFavourInfo favourInfo : favourInfoList) {
            if (favourInfo.getFavourName().equals("001ilnp1vnacg045ek00")) {
                assertEquals(2L, favourInfo.getFavourCount());
                assertEquals(new Money(15, 00), favourInfo.getFavourAmount());
                assertEquals("周年庆活动", favourInfo.getFavourName());
                assertEquals("CAMPAIGN_FAVOUR", favourInfo.getFavourType());
            }
            if (favourInfo.getFavourName().equals("001ilnp1vnacg045ek01")) {
                assertEquals(2L, favourInfo.getFavourCount());
                assertEquals(new Money(1, 56), favourInfo.getFavourAmount());
                assertEquals("日常活动", favourInfo.getFavourName());
                assertEquals("CAMPAIGN_FAVOUR", favourInfo.getFavourType());
            }
        }
        //班结核销商品
        List<OperatorWorkGoodsInfo> goodsInfoList = result.getInfo().getGoodsInfoList();
        assertEquals(1, favourInfoList.size());
        for (OperatorWorkGoodsInfo goodsInfo : goodsInfoList) {
            assertEquals(new Money(100, 00), goodsInfo.getGoodsAmount());
            assertEquals("默认商品", goodsInfo.getGoodsName());
            assertEquals(2L, goodsInfo.getGoodsCount());
        }
        //班结收银加油油号
        List<OperatorWorkOilInfo> oilInfoList = result.getInfo().getOilInfoList();
        assertEquals(2, oilInfoList.size());
        for (OperatorWorkOilInfo oilInfo : oilInfoList) {
            if (oilInfo.getOilName().equals("95号汽油")) {
                assertEquals(new Money(100, 00), oilInfo.getOilAmount());
                assertEquals(1L, oilInfo.getOilCount());
                assertEquals(5.56, oilInfo.getOilLiter());
            }
            if (oilInfo.getOilName().equals("93号汽油")) {
                assertEquals(new Money(100, 40), oilInfo.getOilAmount());
                assertEquals(1L, oilInfo.getOilCount());
                assertEquals(4.00, oilInfo.getOilLiter());
            }
        }
        //班结收银交易方式
        List<OperatorWorkTradeInfo> tradeInfoList = result.getInfo().getTradeInfoList();
        assertEquals(3, tradeInfoList.size());
        for (OperatorWorkTradeInfo tradeInfo : tradeInfoList) {
            if (tradeInfo.getTradePayType().equals("ALI")) {
                assertEquals(1L, tradeInfo.getTradeTypeCount());
                assertEquals(new Money(150, 00), tradeInfo.getPayAmount());
            }
            if (tradeInfo.getTradePayType().equals("REMAINING")) {
                assertEquals(1L, tradeInfo.getTradeTypeCount());
                assertEquals(new Money(144, 44), tradeInfo.getPayAmount());
            }
            if (tradeInfo.getTradePayType().equals("CASH")) {
                assertEquals(1L, tradeInfo.getTradeTypeCount());
                assertEquals(new Money(13, 90), tradeInfo.getPayAmount());
            }
        }
        //班结退款订单数据
//        OperatorWorkRefundInfo refundInfoList=result.getInfo().getRefundInfo();
        //assertEquals(0,favourInfoList.size());
        // 数据验证
        GasMerchantDeviceDO deviceInfo =
                gasMerchantTestBase.findGasMerchantDeviceByDeviceCode(gasMerchantDeviceDO.getDeviceCode()).get(0);
        assertEquals(gasMerchantDO.getPartnerId(), deviceInfo.getPartnerId());
        assertEquals(null, deviceInfo.getLoginUserId());
        assertEquals(UserLoginStatus.logout.code(), deviceInfo.getLoginStatus());
        assertEquals(DeviceType.POS.code(), deviceInfo.getDeviceType());
        assertEquals(gasMerchantDeviceDO.getDeviceCode(), deviceInfo.getDeviceCode());
        List<GasLoginLogDO> loginlogs = gasMerchantTestBase.findGasLoginLogByUserId(order.getUserId());
        assertEquals(2, loginlogs.size());
        List<String> loginStatus = new ArrayList<String>();
        for (GasLoginLogDO loginlog : loginlogs) {
            assertEquals(DeviceType.POS.code(), loginlog.getDeviceType());
            assertEquals(gasMerchantUserDO.getUserId(), loginlog.getUserId());
            assertEquals(gasMerchantUserDO.getAccount(), loginlog.getAccount());
            assertEquals(gasMerchantUserDO.getPartnerId(), loginlog.getPartnerId());
            assertEquals(gasMerchantUserDO.getUserName(), loginlog.getUserName());
            assertEquals(order.getDeviceCode(), loginlog.getDeviceCode());
        }
        assertTrue(loginStatus.contains(UserLoginStatus.login.code()));
        assertTrue(loginStatus.contains(UserLoginStatus.logout.code()));
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
        gasMerchantTestBase.cleanGasRoleByRoleName(gasRoleDO.getRoleName());
        gasMerchantTestBase.cleanGasDeviceResourceByCode(gasDeviceResourceDO.getCode());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantStationByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasStationOilGunByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserStationByUserId(gasMerchantUserDO.getUserId());
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(gasGoodsDO.getGoodsCode());
        gasMerchantTestBase.cleanGasMerchantGoodsByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantDeviceByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasDevicePrintByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasLoginLogByUserId(gasMerchantUserDO.getUserId());
    }
}
