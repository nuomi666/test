package com.xjy.autotest.testbase.InitData;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.util.money.Money;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.enums.SourceType;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.user.api.enums.RegisterFrom;
import com.xyb.user.api.enums.UserStatus;
import com.xyb.user.api.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author nuomi@xinyebang.com
 * Created on 2019/8/2.
 * 数据应用场景：用于准备加好油商家相关信息。
 * 基础信息包括商家
 * 附加（有可能需要的信息）包括油站、员工、实体卡、商品、油枪、油价、一键加油等信息
 */
public class GasMerchantInitDataBase {
    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;
    //平台商ID
    String PLAT_PARTNER_ID = "S0301806081400000015";

    /**
     * 数据应用场景：造多个或一个未授权商户的情况用这个(最多只造了两个)，不支持一个用例里多次使用此方法来造多个商家
     * 参数设计说明：partnerId不传则不会插入对应商家的信息
     */
    public Map<String, Object> initGasMerchants(String partnerId, String partnerId1,
                                                String partnerName, String partnerName1,
                                                String shortName, String shortName1,
                                                String mobile, String mobile1,
                                                String sourceKey, String sourceKey1,
                                                String merchantStatus, String merchantStatus1,
                                                String model, String model1,
                                                Date rawAddTime, Date rawUpdateTime) {

        //资金账户
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String poolAccountNo = "1jhb00i98ws031hge7p0";
        String accountNo1 = "1jc81da19gs031hge7p8";
        String marketAccountNo1 = "001iys5hlniks0368h00";
        String poolAccountNo1 = "1jhb00i98ws985hge7p0";
        //第一个商家
        if (StringUtils.isNotBlank(partnerId) && StringUtils.isNotBlank(partnerName)) {
            xybUserTestBase.cleanUserByUserId(partnerId);
            xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                    RegisterFrom.INSIDE.code(),
                    UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, partnerName, null, null, null, null,
                    null, null, null, null, null, mobile, null, null,
                    null, partnerId, null, rawAddTime, rawUpdateTime);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId);
            xybUserTestBase.cleanAccountByAccountNo(accountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo, "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
            //插入神马付商户营销账户信息
            xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                    rawAddTime, rawUpdateTime);
            //插入神马付商户资金池账户信息
            xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", rawAddTime, rawUpdateTime);
            //加好油商户
            merchantTestBase.cleanGasMerchantByPartnerId(partnerId);
            merchantTestBase.cleanGasMerchantByPartnerName(partnerName);
            merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, partnerName, shortName, mobile, null,
                    accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                            "*1000", rawAddTime, rawUpdateTime);
            //商户来源信息
            merchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId);
            //merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
            //        sourceKey, Byte.valueOf("0"), null, rawAddTime, rawUpdateTime, null, null, null, null);
            //分析数据
            silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
            silverboltTestBase.insertGasMerchant(0L, partnerId, partnerName, shortName, mobile, null, accountNo,
                    marketAccountNo, merchantStatus, null, null, model, rawAddTime, rawUpdateTime, rawAddTime,
                    rawUpdateTime);
        }
        //第二个商家
        if (StringUtils.isNotBlank(partnerId1) && StringUtils.isNotBlank(partnerName1)) {
            xybUserTestBase.cleanUserByUserId(partnerId1);
            xybUserTestBase.insertUser(0L, partnerId1, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                    RegisterFrom.INSIDE.code(),
                    UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, partnerName, null, null, null, null,
                    null, null, null, null, null, mobile1, null, null,
                    null, partnerId1, null, rawAddTime, rawUpdateTime);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId1);
            xybUserTestBase.cleanAccountByAccountNo(accountNo1);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, accountNo1, null, partnerId1, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo1, "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
            //插入神马付商户营销账户信息
            xybUserTestBase.cleanAccountByAccountNo(marketAccountNo1);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, marketAccountNo1, null, partnerId1, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                    rawAddTime, rawUpdateTime);
            //插入神马付商户资金池账户信息
            xybUserTestBase.cleanAccountByAccountNo(poolAccountNo1);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, poolAccountNo1, null, partnerId1, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", rawAddTime, rawUpdateTime);
            //加好油商户
            merchantTestBase.cleanGasMerchantByPartnerId(partnerId1);
            merchantTestBase.cleanGasMerchantByPartnerName(partnerName1);
            merchantTestBase.insertGasMerchant(0L, partnerId1, partnerId1, partnerName1, shortName1, mobile1, null,
                    accountNo1, marketAccountNo1, merchantStatus1, null, null, model1, "1", "0*60*60*1000+0*60*1000+0" +
                            "*1000", rawAddTime, rawUpdateTime);
            //商户来源信息
            merchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId1);
            //merchantTestBase.insertGasMerchantSourceData(0L, partnerId1, partnerId1, SourceType.WeChat.code(),
            //        sourceKey1, Byte.valueOf("0"), null, rawAddTime, rawUpdateTime, null, null, null, null);
            //分析数据
            silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
            silverboltTestBase.insertGasMerchant(0L, partnerId1, partnerName1, shortName1, mobile1, null, accountNo1,
                    marketAccountNo1, merchantStatus1, null, null, model1, rawAddTime, rawUpdateTime, rawAddTime,
                    rawUpdateTime);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 数据应用场景：同一个平台商下造未授权商户用，可通过改变入参的方式重复使用此方法来造多个商家
     * 参数设计说明：partnerId：商户号，partnerName：商户名称，shortName：商户简称,sourceKey:来源标识
     * accountNo：商户标准户，marketAccountNo：商户营销账户，mobile：商户手机，merchantStatus：商户状态
     */
    public Map<String, Object> initGasMerchant(String partnerId, String partnerName, String sourceKey,
                                               String shortName, String accountNo, String marketAccountNo,
                                               String poolAccountNo, String model,
                                               String mobile, String merchantStatus) {

        //第一个商家
        if (StringUtils.isNotBlank(partnerId) && StringUtils.isNotBlank(partnerName)) {
            xybUserTestBase.cleanUserByUserId(partnerId);
            xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                    RegisterFrom.INSIDE.code(),
                    UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, partnerName, null, null, null, null,
                    null, null, null, null, null, mobile, null, null,
                    null, partnerId, null, null, null);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId);
            xybUserTestBase.cleanAccountByAccountNo(accountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            //插入神马付商户营销账户信息
            xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户", null,
                    null);
            //插入神马付商户资金池账户信息
            xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", null, null);
            //加好油商户
            merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
            merchantTestBase.cleanGasMerchantByPartnerName(partnerName);
            merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, partnerName, shortName, mobile, null,
                    accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                            "*1000", null, null);
            //商户来源信息
            merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
            //merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
            //        sourceKey, Byte.valueOf("0"), null, null, null, null, null, null, null);
            //分析数据
            silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
            silverboltTestBase.insertGasMerchant(0L, partnerId, partnerName, shortName, mobile, null, accountNo,
                    marketAccountNo, merchantStatus, null, null, model, null, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 数据应用场景：一个商家下多个油站，商家基础数据需要预先造好
     * 参数设计说明：platPartnerId：平台商ID，partnerId：签约商ID，stationId：油站ID，stationName：油站名称
     * stationCode：油站编码，stationStatus：油站状态
     * <p>
     * 当油站能独立收银时，平台商ID和签约商ID不一样，对应的商家的数收款模式应为商家油站
     * 返回值：商家ID。可根据需要自行添加
     */
    public Map<String, Object> initStationsWithOneMerchant(String platPartnerId, String platPartnerId1,
                                                           String partnerId, String partnerId1,
                                                           String stationId, String stationId1,
                                                           String stationName, String stationName1,
                                                           String stationCode, String stationCode1,
                                                           String stationStatus, String stationStatus1) {

        //第一个商家
        if (StringUtils.isNotBlank(platPartnerId)) {
            //第一个油站
            if (StringUtils.isNotBlank(stationId)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId);
                merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, platPartnerId, stationName,
                        stationCode, null, stationStatus, null, null, null, null, null, null, null, null, null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
                silverboltTestBase.insertGasMerchantStation(0L, stationId, partnerId, platPartnerId, stationName,
                        stationCode, null, stationStatus, null, null, null, null, null, null, null, null, null, null,
                        null, null, null,
                        null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId != partnerId) {
                xybUserTestBase.cleanUserByUserId(partnerId);
                xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                        RegisterFrom.INSIDE.code(),
                        UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null,
                        null, partnerId, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId);
                xybUserTestBase.cleanAccountByAccountNo("001ik3vtaap8s0555h00");
                xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, "001ik3vtaap8s0555h00", null, partnerId
                        , 0L,
                        0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        if (StringUtils.isNotBlank(platPartnerId1)) {
            //第二个油站
            if (StringUtils.isNotBlank(stationId1)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
                merchantTestBase.insertGasMerchantStation(0L, stationId1, partnerId1, platPartnerId1, stationName1,
                        stationCode1, null, stationStatus1, null, null, null, null, null, null, null, null, null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
                silverboltTestBase.insertGasMerchantStation(0L, stationId1, partnerId1, platPartnerId1, stationName1,
                        stationCode1, null, stationStatus1, null, null, null, null, null, null, null, null, null, null,
                        null, null, null,
                        null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId1 != partnerId1) {
                xybUserTestBase.cleanUserByUserId(partnerId1);
                xybUserTestBase.insertUser(0L, partnerId1, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                        RegisterFrom.INSIDE.code(),
                        UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null,
                        null, partnerId1, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId1);
                xybUserTestBase.cleanAccountByAccountNo("001ik3vtaap8s0666h00");
                xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, "001ik3vtaap8s0666h00", null,
                        partnerId1, 0L, 0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 带有油站经纬度的，一键加油相关接口造数据建议用此方法
     * 参数设计说明：platPartnerId：平台商ID，partnerId：签约商ID，stationId：油站ID，stationName：油站名称
     * stationCode：油站编码，stationStatus：油站状态
     * <p>
     * 当油站能独立收银时，平台商ID和签约商ID不一样，对应的商家的数收款模式应为商家油站
     * 返回值：商家ID。可根据需要自行添加
     */
    public Map<String, Object> initStationsWithLocation(String platPartnerId, String platPartnerId1,
                                                        String partnerId, String partnerId1,
                                                        String stationId, String stationId1,
                                                        String stationName, String stationName1,
                                                        String stationCode, String stationCode1,
                                                        Double longitude, Double longitude1,
                                                        Double latitude, Double latitude1,
                                                        String stationStatus, String stationStatus1) {

        //第一个商家
        if (StringUtils.isNotBlank(platPartnerId)) {
            //第一个油站
            if (StringUtils.isNotBlank(stationId)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId);
                merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, platPartnerId, stationName,
                        stationCode, null, stationStatus, null, null, null, null, null, longitude, latitude, null,
                        null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
                silverboltTestBase.insertGasMerchantStation(0L, stationId, partnerId, platPartnerId, stationName,
                        stationCode, null, stationStatus, null, null, null, null, null, null, null, null, longitude,
                        latitude,
                        null, null, null,
                        null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId != partnerId) {
                xybUserTestBase.cleanUserByUserId(partnerId);
                xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                        RegisterFrom.INSIDE.code(),
                        UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null,
                        null, partnerId, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId);
                xybUserTestBase.cleanAccountByAccountNo("001ik3vtaap8s0555h00");
                xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, "001ik3vtaap8s0555h00", null, partnerId
                        , 0L,
                        0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        if (StringUtils.isNotBlank(platPartnerId1)) {
            //第二个油站
            if (StringUtils.isNotBlank(stationId1)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
                merchantTestBase.insertGasMerchantStation(0L, stationId1, partnerId1, platPartnerId1, stationName1,
                        stationCode1, null, stationStatus1, null, null, null, null, null, longitude1, latitude1, null
                        , null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
                silverboltTestBase.insertGasMerchantStation(0L, stationId1, partnerId1, platPartnerId1, stationName1,
                        stationCode1, null, stationStatus1, null, null, null, null, null, null, null, null,
                        longitude1, latitude1,
                        null, null, null,
                        null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId1 != partnerId1) {
                xybUserTestBase.cleanUserByUserId(partnerId1);
                xybUserTestBase.insertUser(0L, partnerId1, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                        RegisterFrom.INSIDE.code(),
                        UserType.PARTNER.code(), UserStatus.NORMAL.code(), null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null,
                        null, partnerId1, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId1);
                xybUserTestBase.cleanAccountByAccountNo("001ik3vtaap8s0666h00");
                xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, "001ik3vtaap8s0666h00", null,
                        partnerId1, 0L, 0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 数据应用场景：准备终端资源基础数据(父级)
     * 返回参数：parentId父级id。可根据需要自行添加
     */
    public Map<String, Object> initDeviceResource(String deviceType, String resourceType,
                                                  String name, String code) {
        merchantTestBase.cleanGasDeviceResourceByCode(code);
        merchantTestBase.insertGasDeviceResource(0L, deviceType, null, name, code, null, resourceType, null, null,
                null, null, null);
        Long parentId = merchantTestBase.findGasDeviceResourceByName(name).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", parentId);
        return param;
    }

    /**
     * 数据应用场景：准备终端资源基础数据(子级)
     * 返回参数：parentId父级id,childId子级id。可根据需要自行添加
     */
    public Map<String, Object> initDeviceResourceChild(String deviceType, String fatherType, String type,
                                                       String fatherName, String name, String fatherCode, String code) {
        merchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        merchantTestBase.insertGasDeviceResource(0L, deviceType, null, fatherName, fatherCode, null, fatherType,
                null, null, null, null, null);
        Long parentId = merchantTestBase.findGasDeviceResourceByName(fatherName).get(0).getId();
        merchantTestBase.cleanGasDeviceResourceByCode(code);
        merchantTestBase.insertGasDeviceResource(0L, deviceType, parentId, name, code, null, type, null, null
                , null, null, null);
        Long childId = merchantTestBase.findGasDeviceResourceByName(name).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("parentId", parentId);
        param.put("childId", childId);
        return param;
    }

    /**
     * 数据应用场景：准备角色数据，parentName不传，则添加的角色没有上级角色
     * 返回参数：parentId父级id,childId子级id。可根据需要自行添加
     */
    public Map<String, Object> initGasRole(String roleName, String parentName,
                                           String roleType, String parentType) {
        Long parentId = null;
        if (StringUtils.isNotBlank(parentName)) {
            merchantTestBase.cleanGasRoleByRoleName(parentName);
            merchantTestBase.insertGasRole(0L, parentType, null, parentName, null, null, null);
            parentId = merchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
        }
        merchantTestBase.cleanGasRoleByRoleName(roleName);
        merchantTestBase.insertGasRole(0L, roleType, parentId, roleName, null, null, null);
        Long childId = merchantTestBase.findGasRoleByRoleName(roleName).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("parentId", parentId);
        param.put("childId", childId);
        return param;
    }

    /**
     * 数据应用场景：一个角色关联一个或多个资源,roleId必填,资源的终端类型为BOSS
     * 返回值：根据需要自行添加
     */
    public Map<String, Object> initGasRoleResource(Long roleId, Long resourceId,
                                                   Long resourceId1, Long resourceId2) {
        if (resourceId != null && StringUtils.isNotBlank(resourceId.toString())) {
            merchantTestBase.cleanGasMerchantRoleResourceByResourceId(resourceId);
            merchantTestBase.insertGasMerchantRoleResource(0L, roleId, resourceId);
        }
        if (resourceId1 != null && StringUtils.isNotBlank(resourceId1.toString())) {
            merchantTestBase.cleanGasMerchantRoleResourceByResourceId(resourceId1);
            merchantTestBase.insertGasMerchantRoleResource(0L, roleId, resourceId1);
        }
        if (resourceId2 != null && StringUtils.isNotBlank(resourceId2.toString())) {
            merchantTestBase.cleanGasMerchantRoleResourceByResourceId(resourceId2);
            merchantTestBase.insertGasMerchantRoleResource(0L, roleId, resourceId2);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 数据应用场景：一个商户关联一个或多个资源,platPartnerId必填，资源的终端类型为POS
     * 返回值：根据需要自行添加
     */
    public Map<String, Object> initGasMerchantResource(String platPartnerId, Long resourceId,
                                                       Long resourceId1, Long resourceId2) {
        if (resourceId != null && StringUtils.isNotBlank(resourceId.toString())) {
            merchantTestBase.cleanGasMerchantResourceByResourceId(resourceId);
            //merchantTestBase.insertGasMerchantResource(0L, platPartnerId, platPartnerId, resourceId);
        }
        if (resourceId1 != null && StringUtils.isNotBlank(resourceId1.toString())) {
            merchantTestBase.cleanGasMerchantResourceByResourceId(resourceId1);
            //merchantTestBase.insertGasMerchantResource(0L, platPartnerId, platPartnerId, resourceId1);
        }
        if (resourceId2 != null && StringUtils.isNotBlank(resourceId2.toString())) {
            merchantTestBase.cleanGasMerchantResourceByResourceId(resourceId2);
            //merchantTestBase.insertGasMerchantResource(0L, platPartnerId, platPartnerId, resourceId2);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 数据应用场景：一个商户关联一个或多个角色（需要预先造商家、角色数据）
     * 返回值：根据需要自行添加
     */
    public Map<String, Object> initGasMerchantRole(String platPartnerId, Long roleId, Long roleId1, Long roleId2,
                                                   Long roleId3, Long roleId4) {
        merchantTestBase.cleanGasMerchantRoleByPlatPartnerId(platPartnerId);
        if (roleId != null && StringUtils.isNotBlank(roleId.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId);
        }
        if (roleId1 != null && StringUtils.isNotBlank(roleId1.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId1);
        }
        if (roleId2 != null && StringUtils.isNotBlank(roleId2.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId2);
        }
        if (roleId3 != null && StringUtils.isNotBlank(roleId3.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId3);
        }
        if (roleId4 != null && StringUtils.isNotBlank(roleId4.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId4);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 数据应用场景：准备商品基础信息
     * 返回参数：商品id。可根据需要自行添加
     */
    public Map<String, Object> initGasGoods(String goodsCode, String goodsType, String goodsGroupType,
                                            String goodsName, Date rawAddTime, Date rawUpdateTime) {
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        //merchantTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, rawAddTime,
        //        rawUpdateTime);
        Long id = merchantTestBase.findGasGoodsByGoodsCode(goodsCode).get(0).getId();
        //分析数据
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, rawAddTime
                , rawUpdateTime);
        Map<String, Object> param = Maps.newHashMap();
        param.put("goodsId", id);
        return param;
    }

    /**
     * 数据应用场景：准备配有油枪的油站信息,不传油枪号则只会添加油站信息
     * 返回参数：可根据需要自行添加
     */
    public Map<String, Object> initStationsWithOilGun(String partnerId, String stationId, String stationName,
                                                      String stationCode, String phoneNo, String status,
                                                      String goodsCode, String oilGunNo, Date rawAddTime,
                                                      Date rawUpdateTime) {
        //油品信息（目前添加油枪时没校验油枪号对应的油品是否存在，所以可以先不用准备油品数据）
//        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
//        merchantTestBase.insertGasMerchantGoods(0L, partnerId, partnerId, null, goodsCode, GoodsType.OIL.code(),
//        null, null, "ABLE", rawAddTime, rawUpdateTime);
        //油站
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, partnerId, stationName, stationCode,
                phoneNo, status, Byte.valueOf("0"), 2L, 3L, 4L, null, 11.23, 11.24, rawAddTime, rawUpdateTime);
        //油枪
        if (StringUtils.isNotBlank(oilGunNo)) {
            merchantTestBase.cleanGasStationOilGunByStationId(stationId);
            merchantTestBase.insertGasStationOilGun(0L, partnerId, partnerId, stationId, oilGunNo, goodsCode,
                    rawAddTime, rawUpdateTime, 1);
        }
        //分析数据
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.insertGasMerchantStation(0L, partnerId, partnerId, stationId, stationName, stationCode,
                phoneNo, status, Byte.valueOf("0"), 2L, "重庆", 3L, "渝北", 4L, "光电园", null, 11.23, 11.24, rawAddTime,
                rawUpdateTime, rawAddTime, rawUpdateTime);
        Map<String, Object> param = Maps.newHashMap();
//        param.put("goodsId", id);
        return param;
    }

    /**
     * 数据应用场景：准备商家操作员数据
     */
    public void initGasMerchantUser(String platPartnerId, String userId,
                                    Long roleId, String userType,
                                    String mobile, String password, String account) {
        String uqKey = null;
        if (com.xyb.gas.merchant.api.enums.UserType.BOSS.code().equals(userType)) {
            uqKey = account;
        }
        if (com.xyb.gas.merchant.api.enums.UserType.DEVICE.code().equals(userType) || com.xyb.gas.merchant.api.enums.UserType.UNLOGIN.code().equals(userType)) {
            uqKey = String.join("_", platPartnerId, account);
        }
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanGasMerchantUserByUserId(userId);
            merchantTestBase.insertGasMerchantUser(0L, userId, roleId, userType, platPartnerId, platPartnerId, "用户名",
                    mobile, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, null, null, null, null, null);
            //分析
            silverboltTestBase.cleanGasMerchantUserByUserId(userId);
            silverboltTestBase.insertGasMerchantUser(0L, platPartnerId, userId, roleId, userType, "用户名",
                    mobile, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, null, null, null, null, null, null, null);
        }
    }

    /**
     * 准备商城商品数据
     * 适用场景：查询修改商城数据可用，兑换商品不建议使用此方法准备数据
     */
    public Map<String, Object> initMallExchangeGoodsSimple(String platPartnerId, String goodsId,
                                                           String goodsName, String goodsType,
                                                           String goodsImg,
                                                           String gainStyle, String stationId) {

        Long id = 0L;
        if (StringUtils.isNotBlank(goodsId)) {
            merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
            merchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId, platPartnerId, goodsType,
                    goodsName, null, goodsImg, null, null, 100, 100, 0, 1, gainStyle, stationId, 0, null, null);
            id = merchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId).get(0).getId();
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 准备商城商品数据
     * 适用场景：兑换商品准备数据
     */
    public Map<String, Object> initMallExchangeGoods(String platPartnerId, String goodsId,
                                                     String goodsName, String goodsType,
                                                     String goodsImg,
                                                     String gainStyle, String stationId) {

        Long id = 0L;
        if (StringUtils.isNotBlank(goodsId)) {
            merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
            merchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId, platPartnerId, goodsType,
                    goodsName, null, goodsImg, null, null, 100, 100, 0, 1, gainStyle, stationId, 0, null, null);
            id = merchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId).get(0).getId();
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 准备制卡规则数据
     * 适用场景：只适用于分页查询制卡规则,一个商户下多个制卡规则
     */
    public Map<String, Object> initCardRules(String platPartnerId, String accont,
                                             String memo, Integer start, Integer start1, Integer end, Integer end1,
                                             Integer vaildCount, Integer vaildCount1,
                                             Date rawAddTime, Date rawAddTime1) {

        if (start != null && end != null) {
            merchantTestBase.insertGasMerchantCardRule(0L, platPartnerId, platPartnerId, start, end, null,
                    null, vaildCount, accont, memo, rawAddTime, rawAddTime);
        }
        if (start1 != null && end1 != null) {
            merchantTestBase.insertGasMerchantCardRule(0L, platPartnerId, platPartnerId, start1, end1, null,
                    null, vaildCount1, accont, memo, rawAddTime1, rawAddTime1);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备制卡卡号数据
     * 适用场景：一个商户下一个制卡规则生成的多张卡
     */
    public Map<String, Object> initGasMerchantCard(String platPartnerId, Long cardRuleId, String account,
                                                   String cardNo, String cardNo1, String cardNo2, String cardNo3) {

        if (StringUtils.isNotBlank(cardNo)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo, null, cardRuleId, account, null, null);
        }
        if (StringUtils.isNotBlank(cardNo1)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo1);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo1, null, cardRuleId, account, null, null);
        }
        if (StringUtils.isNotBlank(cardNo2)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo2);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo2, null, cardRuleId, account, null, null);
        }
        if (StringUtils.isNotBlank(cardNo3)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo3);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo3, null, cardRuleId, account, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 用户登录日志表
     * 适用场景：只有登录，还未登出
     * 参数：flag用于标识是否需要删除同一操作员的登录记录；当flag为true时，之前造的相同的操作员的登录记录会被删除
     * 反之则不会
     */
    public Map<String, Object> initGasLoginLogWithLogin(boolean flag, String platPartnerId, String partnerName,
                                                        String stationId, String stationName,
                                                        String userId, String userName, String account,
                                                        String deviceCode, Date loginTime) {
        if (StringUtils.isNotBlank(platPartnerId)) {
            if (flag) {
                merchantTestBase.cleanGasLoginLogByUserId(userId);
            }
            merchantTestBase.insertGasLoginLog(0L, DeviceType.POS.code(), userId, account, platPartnerId,
                    platPartnerId, partnerName, stationId, stationName, userName, deviceCode, loginTime, null,
                    loginTime, loginTime);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 用户登录日志表
     * 适用场景：用户已经登出
     * 参数：flag用于标识是否需要删除同一操作员的登录记录；当flag为true时，之前造的相同的操作员的登录记录会被删除
     * 反之则不会
     */
    public Map<String, Object> initGasLoginLogWithLogOut(boolean flag, String platPartnerId, String partnerName,
                                                         String stationId, String stationName,
                                                         String userId, String userName, String account,
                                                         String deviceCode, Date loginTime, Date loginOutTime) {
        if (StringUtils.isNotBlank(platPartnerId)) {
            if (flag) {
                merchantTestBase.cleanGasLoginLogByUserId(userId);
            }
            merchantTestBase.insertGasLoginLog(0L, DeviceType.POS.code(), userId, account, platPartnerId,
                    platPartnerId, partnerName, stationId, stationName, userName, deviceCode, loginTime, loginOutTime,
                    loginTime, loginOutTime);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备商家终端配置信息
     */
    public Map<String, Object> initGasMerchantDevice(String platPartnerId, String userId,
                                                     String deviceCode, String loginStatus) {
        if (StringUtils.isNotBlank(deviceCode)) {
            merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
            merchantTestBase.insertGasMerchantDevice(0L, platPartnerId, platPartnerId,
                    DeviceType.POS.code(), deviceCode, loginStatus, userId, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备终端小票配置信息
     */
    public Map<String, Object> initGasDevicePrint(String platPartnerId, String printId,
                                                  String stationId, String printType,
                                                  String printTitle, int sleepTime) {
        if (StringUtils.isNotBlank(printId)) {
            merchantTestBase.cleanGasDevicePrintByPrintId(printId);
            merchantTestBase.insertGasDevicePrint(0L, printId, platPartnerId, platPartnerId, stationId,
                    DeviceType.POS.code(), printType, printTitle, sleepTime, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备一键加油设置信息
     */
    public Map<String, Object> initGasDeviceFunction(String platPartnerId, String userId,
                                                     String stationId, String deviceCode) {
        if (StringUtils.isNotBlank(stationId)) {
            merchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
            merchantTestBase.insertGasMerchantDeviceFunction(0L, platPartnerId, platPartnerId, stationId, "ONE_KEY",
                    Byte.valueOf("1")
                    , DeviceType.POS.code(), deviceCode, userId, null, null);
        }
        Long id = merchantTestBase.findGasMerchantDeviceFunctionByStationId(stationId).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 会员中心规则说明
     */
    public Map<String, Object> initGasRuleDesc(String platPartnerId, String ruleType,
                                               String dec, String deviceCode) {
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(platPartnerId);
            merchantTestBase.insertGasRuleDescription(0, platPartnerId, platPartnerId, ruleType, null, null, dec);
        }
        Integer id =
                merchantTestBase.findGasRuleDescriptionByPlatPartnerId(platPartnerId).stream().filter(des -> (ruleType.equals(des.getRuleType()))).findFirst().get().getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 商家商品配置表
     */
    public Map<String, Object> initGasMerchantGoods(String platPartnerId,
                                                    String goodsGroupType, String goodsType,
                                                    String goodsName, String goodsCode,
                                                    String goodsGroupType1, String goodsType1,
                                                    String goodsName1, String goodsCode1,
                                                    String goodsGroupType2, String goodsType2,
                                                    String goodsName2, String goodsCode2) {
        if (StringUtils.isNotBlank(goodsCode)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
            //merchantTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, null,
            //        null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
            //merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName, goodsCode, goodsType
            //        , null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
            silverboltTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
            silverboltTestBase.insertGasMerchantGoods(0L, platPartnerId, goodsName, goodsCode, goodsType
                    , null, null, "ABLE", null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
            //merchantTestBase.insertGasGoods(0L, goodsType1, goodsGroupType1, null, goodsName1, goodsCode1, null, null,
            //        null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
            //merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName1, goodsCode1, goodsType1
            //        , null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
            silverboltTestBase.insertGasGoods(0L, goodsType1, goodsGroupType1, null, goodsName1, goodsCode1, null, null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
            silverboltTestBase.insertGasMerchantGoods(0L, platPartnerId, goodsName1, goodsCode1, goodsType1
                    , null, null, "ABLE", null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode2)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
            //merchantTestBase.insertGasGoods(0L, goodsType2, goodsGroupType2, null, goodsName2, goodsCode2, null, null,
            //        null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode2);
            //merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName2, goodsCode2, goodsType2
            //        , null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
            silverboltTestBase.insertGasGoods(0L, goodsType2, goodsGroupType2, null, goodsName2, goodsCode2, null, null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode2);
            silverboltTestBase.insertGasMerchantGoods(0L, platPartnerId, goodsName2, goodsCode2, goodsType2
                    , null, null, "ABLE", null, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 油站商品配置表
     */
    public Map<String, Object> initGasStationGoods(String platPartnerId, String stationId,
                                                   String goodsName, String goodsCode,
                                                   String goodsName1, String goodsCode1,
                                                   String goodsName2, String goodsCode2) {
        if (StringUtils.isNotBlank(goodsCode)) {
            merchantTestBase.cleanGasStationGoodsByGoodsCode(goodsCode);
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName, goodsCode,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            merchantTestBase.cleanGasStationGoodsByGoodsCode(goodsCode1);
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName1, goodsCode1,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode2)) {
            merchantTestBase.cleanGasStationGoodsByGoodsCode(goodsCode2);
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName2, goodsCode2,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 油站油价配置表
     */
    public Map<String, Object> initGasStationGoodsPrice(String platPartnerId, String stationId, String planId,
                                                        String merchantPlanId, Date effectTime,
                                                        String goodsName, String goodsCode,
                                                        Money goodsPrice, Money listedPrice,
                                                        String goodsName1, String goodsCode1,
                                                        Money goodsPrice1, Money listedPrice1,
                                                        String goodsName2, String goodsCode2,
                                                        Money goodsPrice2, Money listedPrice2) {

        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder goodsPriceOrder = new GoodsPriceOrder();
        goodsPriceOrder.setGoodsCode(goodsCode);
        goodsPriceOrder.setGoodsName(goodsName);
        goodsPriceOrder.setGoodsPrice(goodsPrice);
        goodsPriceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrder.setListedPrice(listedPrice);
        GoodsPriceOrder goodsPriceOrder1 = new GoodsPriceOrder();
        goodsPriceOrder1.setGoodsCode(goodsCode1);
        goodsPriceOrder1.setGoodsName(goodsName1);
        goodsPriceOrder1.setGoodsPrice(goodsPrice1);
        goodsPriceOrder1.setGoodsType(GoodsType.OIL);
        goodsPriceOrder1.setListedPrice(listedPrice1);
        GoodsPriceOrder goodsPriceOrder2 = new GoodsPriceOrder();
        goodsPriceOrder2.setGoodsCode(goodsCode2);
        goodsPriceOrder2.setGoodsName(goodsName2);
        goodsPriceOrder2.setGoodsPrice(goodsPrice2);
        goodsPriceOrder2.setGoodsType(GoodsType.OIL);
        goodsPriceOrder2.setListedPrice(listedPrice2);
        if (StringUtils.isNotBlank(goodsCode)) {
            goodsPriceOrders.add(goodsPriceOrder);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            goodsPriceOrders.add(goodsPriceOrder1);
        }
        if (StringUtils.isNotBlank(goodsCode2)) {
            goodsPriceOrders.add(goodsPriceOrder2);
        }
        String goodsInfo = JSON.toJSONString(goodsPriceOrders);
        if (StringUtils.isNotBlank(stationId)) {
            merchantTestBase.cleanGasStationGoodsPricePlanByStationId(stationId);
            merchantTestBase.insertGasStationGoodsPricePlan(0L, planId, merchantPlanId, "测试油价计划", platPartnerId,
                    platPartnerId, stationId, effectTime, null, null, null, null, null, goodsInfo);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 对密码进行MD5加密
     *
     * @param password--密码明文
     * @param slat--随机的6位数
     * @return
     */
    public static String encrypt(String password, String slat) {
        if (org.springframework.util.StringUtils.isEmpty(slat)) {
            return DigestUtil.digestWithMD5(password);
        }
        return DigestUtil.digestWithMD5(password + slat.substring(2));
    }
}
