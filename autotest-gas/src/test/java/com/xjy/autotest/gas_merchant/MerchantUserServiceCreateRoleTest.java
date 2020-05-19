package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.ResourceType;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.order.CreateRoleOrder;
import dal.model.gas_merchant.GasMerchantRoleResourceDO;
import dal.model.gas_merchant.GasRoleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/09/16.
 */
public class MerchantUserServiceCreateRoleTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    MerchantUserService merchantUserService;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001.添加无上级角色，不关联资源的角色，角色类型为商家
     * 1002.添加有上级角色，不关联资源的角色，角色类型为非操作员
     * 1003.添加无上级角色，关联了资源的角色，角色类型为第三方
     * 1004.添加有上级角色，关联了资源的角色，角色类型为油站
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateRoleTestSuccess.csv")
    @DisplayName("创建角色--成功用例")
    public void merchantUserServiceCreateRoleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateRoleOrder order,
            String parentName,
            Long parentId,
            Long resourceId,
            Long resourceId1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
        // 准备数据
        if (testId == 1002 || testId == 1004) {//上级角色信息
            Map<String, Object> param = gasMerchantInitDataBase.initGasRole(parentName, null,
                    RoleType.Supplier.code(), null);
            parentId = Long.valueOf(String.valueOf(param.get("childId")));
        }
        if (testId >= 1003) {//资源信息
            Map<String, Object> param = gasMerchantInitDataBase.initDeviceResourceChild(DeviceType.BOSS.code(),
                    ResourceType.FUNCTION.code(), ResourceType.FUNCTION.code(),
                    null, "油价编辑权限", null, "oil_price_edit");
            resourceId = Long.valueOf(String.valueOf(param.get("childId")));
            Map<String, Object> param1 = gasMerchantInitDataBase.initDeviceResourceChild(DeviceType.BOSS.code(),
                    ResourceType.FUNCTION.code(), ResourceType.FUNCTION.code(),
                    null, "油价新增权限", null, "oil_price_add");
            resourceId1 = Long.valueOf(String.valueOf(param1.get("childId")));
        }
        // 测试过程
        order.setGid(GID.newGID());
        Set<Long> resourceIds = Sets.newHashSet();
        if (testId >= 1003) {
            resourceIds.add(resourceId);
        }
        if (testId == 1004) {
            resourceIds.add(resourceId1);
        }
        if (testId == 1002 || testId == 1004) {
            order.setParentId(parentId);
        }
        // 调用接口
        SimpleResult result = merchantUserService.createRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        Map<String, Object> param = gasRoleAssert(1, order.getRoleName(), order.getRoleType().code(),
                order.getParentId(), order.getMemo());
        if (testId == 1003) {
            gasRoleResourceAssert(1, Long.valueOf(param.get("roleId").toString()), resourceId, null);
        }
        if (testId == 1004) {
            gasRoleResourceAssert(2, Long.valueOf(param.get("roleId").toString()), resourceId, resourceId1);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateRoleTestFailOne.csv")
    @DisplayName("创建角色--参数非法")
    public void merchantUserServiceCreateRoleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateRoleOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
        // 准备数据

        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setRoleName(null);
        }
        if (testId == 1002) {
            order.setRoleType(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantUserService.createRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
    }

    /**
     * 1001.添加角色对应的资源信息不存在
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateRoleTestFailTwo.csv")
    @DisplayName("创建角色--失败用例")
    public void merchantUserServiceCreateRoleTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateRoleOrder order,
            Long resourceId
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
        gasMerchantTestBase.cleanGasDeviceResourceById(resourceId);
        // 准备数据

        // 测试过程
        order.setGid(GID.newGID());
        Set<Long> resourceIds = Sets.newHashSet();
        resourceIds.add(resourceId);
        // 调用接口
        SimpleResult result = merchantUserService.createRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
        gasMerchantTestBase.cleanGasDeviceResourceById(resourceId);
    }

    /**
     * 角色信息
     *
     * @param count
     * @param roleName
     * @param roleType
     * @param parentId
     * @param memo
     * @return
     */
    private Map<String, Object> gasRoleAssert(
            int count,
            String roleName,
            String roleType,
            Long parentId,
            String memo
    ) {
        List<GasRoleDO> gasRoles = gasMerchantTestBase.findGasRoleByRoleName(roleName);
        if (count <= 0) {
            return null;
        } else {
            assertTrue(gasRoles.size() == count);
            for (GasRoleDO gasRole : gasRoles) {
                assertEquals(roleName, gasRole.getRoleName());
                assertEquals(roleType, gasRole.getRoleType());
                assertEquals(parentId, gasRole.getParentId());
                assertEquals(memo, gasRole.getMemo());
//                assertEquals(stationAddress, station.getLatitude());
//                assertEquals(stationAddress, station.getLongitude());
            }
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("roleId",
                gasMerchantTestBase.findGasRoleByRoleName(roleName).get(0).getId());
        return param;
    }

    /**
     * 角色资源关系表
     *
     * @param count
     * @param roleId
     * @param resourceId
     * @param resourceId1
     */
    private void gasRoleResourceAssert(
            int count,
            Long roleId,
            Long resourceId,
            Long resourceId1
    ) {
        List<GasMerchantRoleResourceDO> roleResources = gasMerchantTestBase.findGasMerchantRoleResourceByRoleId(roleId);
        if (count <= 0) {
            return;
        } else {
            assertTrue(roleResources.size() == count);
            Set<Long> resourceIds = Sets.newHashSet();
            for (GasMerchantRoleResourceDO roleResource : roleResources) {
                assertEquals(roleId, roleResource.getRoleId());
                resourceIds.add(roleResource.getResourceId());
            }
            if (resourceId != null && StringUtils.isNotBlank(resourceId.toString())) {
                assertTrue(resourceIds.contains(resourceId));
            }
            if (resourceId1 != null && StringUtils.isNotBlank(resourceId1.toString())) {
                assertTrue(resourceIds.contains(resourceId1));
            }
        }
    }
}
