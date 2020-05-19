package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.UserStatus;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.order.CreateMerchantUserOrder;
import dal.model.gas_merchant.GasMerchantUserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class MerchantUserServiceCreateUserTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantUserService merchantUserService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 由于操作员是收银员时，手机号也可以作为登录账号，目前要求的是一个商家下的操作员手机是唯一的。账号在
     * 同一类型的操作员下是要求唯一的。
     * 1001.新增商家管理员
     * 1002.新增地推员
     * 1003.新增站长
     * 1004.新增收银员，手机号为空
     * 1005.商户下存在一个商家管理员，新增一个相同账号的收银员
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateUserTestSuccess.csv")
    @DisplayName("创建商户用户--成功用例")
    public void merchantUserServiceCreateUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateMerchantUserOrder order,
            String stationId
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商户信息
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), null, null, null, null, null, null,
                "Merhcnat", null, "ABLE");
        //角色信息
        Map<String, Object> role = gasMerchantInitDataBase.initGasRole("地推人员", "站长", RoleType.Nonoperation.code(),
                RoleType.Station.code());
        Map<String, Object> roles = gasMerchantInitDataBase.initGasRole("收银员", "商家管理员", RoleType.Terminal.code(),
                RoleType.Supplier.code());
        Long capitorId = Long.valueOf(role.get("parentId").toString());
        Long nonoperationId = Long.valueOf(role.get("childId").toString());
        Long terminalId = Long.valueOf(roles.get("childId").toString());
        Long supplierId = Long.valueOf(roles.get("parentId").toString());
        gasMerchantInitDataBase.initGasMerchantRole(order.getPlatPartnerId(), capitorId, nonoperationId, terminalId,
                supplierId, null);
        //油站信息
        gasMerchantInitDataBase.initStationsWithOneMerchant(order.getPlatPartnerId(), null, order.getPartnerId(),
                null, stationId, null, "测试油站", null, "test001", null, "ABLE", null);
        if (testId == 1005) {
            gasMerchantInitDataBase.initGasMerchantUser(order.getPlatPartnerId(), OID.newID(), supplierId,
                    UserType.BOSS.code(), order.getMobileNo(), "123456", order.getAccount());
        }
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(stationId);
        if (testId != 1001) {
            order.setStationIds(stationIds);
        }
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setRoleId(supplierId);
        }
        if (testId == 1002) {
            order.setRoleId(nonoperationId);
        }
        if (testId == 1003) {
            order.setRoleId(capitorId);
        }
        if (testId >= 1004) {
            order.setRoleId(terminalId);
        }
        // 调用接口
        SimpleResult result = merchantUserService.createUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            gasMerchantRoleAssert(1, order.getPlatPartnerId(), UserType.BOSS.code(), order.getUserName(),
                    order.getMobileNo(), order.getAccount(), order.getPassword(), supplierId, null);
        }
        if (testId == 1002) {
            gasMerchantRoleAssert(1, order.getPlatPartnerId(), UserType.UNLOGIN.code(), order.getUserName(),
                    order.getMobileNo(), order.getAccount(), order.getPassword(), nonoperationId, null);
        }
        if (testId == 1003) {
            gasMerchantRoleAssert(1, order.getPlatPartnerId(), UserType.BOSS.code(), order.getUserName(),
                    order.getMobileNo(), order.getAccount(), order.getPassword(), capitorId, null);
        }
        if (testId == 1004) {
            gasMerchantRoleAssert(1, order.getPlatPartnerId(), UserType.DEVICE.code(), order.getUserName(),
                    order.getMobileNo(), order.getAccount(), order.getPassword(), terminalId, null);
        }
        if (testId == 1005) {
            gasMerchantRoleAssert(2, order.getPlatPartnerId(), UserType.DEVICE.code(), order.getUserName(),
                    order.getMobileNo(), order.getAccount(), order.getPassword(), terminalId, supplierId);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
    }

    @AutoTest(file = "gas_merchant/merchantUserServiceCreateUserTestFailOne.csv")
    @DisplayName("创建商户用户--参数非法")
    public void merchantUserServiceCreateUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateMerchantUserOrder order
    ) {
        // 清除数据

        // 准备数据

        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setUserName(null);
        }
        if (testId != 1002) {
            order.setRoleId(null);
        }
        if (testId == 1003) {
            order.setAccount(null);
        }
        if (testId == 1004) {
            order.setPassword(null);
        }
        if (testId == 1005) {
            order.setMobileNo("fss2123sds");
        }
        if (testId == 1006) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1007) {
            order.setGid(null);
        }
        if (testId == 1008) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantUserService.createUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.商家不存在
     * 1002.商家下无该角色
     * 1003.创建站长时未关联油站
     * 1004.创建收银员时未关联油站
     * 1005.同一角色类型，账号已经存在
     * 1006.创建收银员，同一商家下手机号已存在
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateUserTestFailTwo.csv")
    @DisplayName("创建商户用户--失败用例")
    public void merchantUserServiceCreateUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateMerchantUserOrder order,
            String stationId
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商户信息
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), null, null, null, null, null, null,
                    "Merhcnat", null, "ABLE");
        }
        //角色信息
        Map<String, Object> role = gasMerchantInitDataBase.initGasRole("地推人员", "站长", RoleType.Nonoperation.code(),
                RoleType.Station.code());
        Map<String, Object> roles = gasMerchantInitDataBase.initGasRole("收银员", "商家管理员", RoleType.Terminal.code(),
                RoleType.Supplier.code());
        Long capitorId = Long.valueOf(role.get("parentId").toString());
        Long nonoperationId = Long.valueOf(role.get("childId").toString());
        Long terminalId = Long.valueOf(roles.get("childId").toString());
        Long supplierId = Long.valueOf(roles.get("parentId").toString());
        gasMerchantInitDataBase.initGasMerchantRole(order.getPlatPartnerId(), capitorId, terminalId, null,
                null, null);
        //油站信息
        gasMerchantInitDataBase.initStationsWithOneMerchant(order.getPlatPartnerId(), null, order.getPartnerId(),
                null, stationId, null, "测试油站", null, "test001", null, "ABLE", null);
        if (testId == 1005) {
            gasMerchantInitDataBase.initGasMerchantUser(order.getPlatPartnerId(), OID.newID(), terminalId,
                    UserType.DEVICE.code(), "13325814722", "123456", order.getAccount());
        }
        if (testId == 1006) {
            gasMerchantInitDataBase.initGasMerchantUser(order.getPlatPartnerId(), OID.newID(), terminalId,
                    UserType.DEVICE.code(), order.getMobileNo(), "123456", "aaabbb");
        }
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(stationId);
        order.setGid(GID.newGID());
        if (testId == 1002) {
            order.setRoleId(supplierId);
        } else if (testId == 1003) {
            order.setRoleId(capitorId);
        } else {
            order.setRoleId(terminalId);
        }
        if (testId != 1003 && testId != 1004) {
            order.setStationIds(stationIds);
        }
        // 调用接口
        SimpleResult result = merchantUserService.createUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
    }

    private void gasMerchantRoleAssert(
            int count,
            String platPartnerId,
            String userType,
            String userName,
            String mobile,
            String account,
            String password,
            Long roleId,
            Long roleId1
    ) {
        List<GasMerchantUserDO> gasMerchantUsers =
                gasMerchantTestBase.findGasMerchantUserByPlatPartnerId(platPartnerId);
        if (count <= 0) {
            return;
        } else {
            assertTrue(gasMerchantUsers.size() == count);
            Set<String> roles = Sets.newHashSet();
            Set<String> accounts = Sets.newHashSet();
            Set<String> names = Sets.newHashSet();
            Set<String> mobiles = Sets.newHashSet();
            Set<String> userTypes = Sets.newHashSet();
            for (GasMerchantUserDO userInfo : gasMerchantUsers) {
//			assertEquals(order.getUserName(), userInfo.getUserId());
                roles.add(userInfo.getRoleId().toString());
                accounts.add(userInfo.getAccount());
                names.add(userInfo.getUserName());
                mobiles.add(userInfo.getMobileNo());
                userTypes.add(userInfo.getUserType());
                assertEquals(platPartnerId, userInfo.getPlatPartnerId());
                assertEquals(platPartnerId, userInfo.getPartnerId());
//                assertEquals(order.getUserName(), userInfo.getSalt());随机生成的6位数字
                assertEquals(DigestUtil.digestWithMD5(password + userInfo.getSalt().substring(2)),
                        userInfo.getPassword());
                assertEquals(UserStatus.NORMAL.code(), userInfo.getStatus());
                if (UserType.BOSS.code().equals(userInfo.getUserType())) {
                    assertEquals(account, userInfo.getUqKey());
                }
                if (UserType.DEVICE.code().equals(userInfo.getUserType()) || UserType.UNLOGIN.code().equals(userInfo.getUserType())) {
                    assertEquals(String.join("_", platPartnerId, account), userInfo.getUqKey());
                }
                assertEquals(0, userInfo.getLoginErrorCount().intValue());
                assertEquals(5, userInfo.getLoginErrorLimit());
                assertEquals(null, userInfo.getLastLoginTime());
                assertEquals(null, userInfo.getLastLoginSuccessTime());
                assertEquals(null, userInfo.getLastLogoutSuccessTime());
                assertNotNull(userInfo.getRawAddTime());
                assertEquals(userInfo.getRawAddTime(), userInfo.getRawUpdateTime());
            }
            if (roleId != null) {
                assertTrue(roles.contains(roleId));
            }
            if (roleId1 != null) {
                assertTrue(roles.contains(roleId1));
            }
            assertTrue(accounts.contains(account));
            assertTrue(names.contains(userName));
            assertTrue(mobiles.contains(mobile));
            assertTrue(userTypes.contains(userType));
        }
    }
}
