package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
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
import com.xyb.gas.merchant.api.order.CreateRoleAuthorityOrder;
import dal.model.gas_merchant.GasMerchantRoleResourceDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/09/17.
 */
public class MerchantUserServiceSaveAuthorityTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    MerchantUserService merchantUserService;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceSaveAuthorityTestSuccess.csv")
    @DisplayName("添加角色权限--成功用例")
    public void merchantUserServiceSaveAuthorityTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateRoleAuthorityOrder order,
            Long roleId,
            Long resourceId,
            Long resourceId1
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> roles = gasMerchantInitDataBase.initGasRole("角色名", null,
                RoleType.Supplier.code(), null);
        roleId = Long.valueOf(String.valueOf(roles.get("childId")));
        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(roleId);
        Map<String, Object> resources = gasMerchantInitDataBase.initDeviceResourceChild(DeviceType.BOSS.code(),
                ResourceType.FUNCTION.code(), ResourceType.FUNCTION.code(),
                null, "油价编辑权限", null, "oil_price_edit");
        resourceId = Long.valueOf(String.valueOf(resources.get("childId")));
        Map<String, Object> resources1 = gasMerchantInitDataBase.initDeviceResourceChild(DeviceType.BOSS.code(),
                ResourceType.FUNCTION.code(), ResourceType.FUNCTION.code(),
                null, "油价编辑权限", null, "oil_price_edit");
        resourceId1 = Long.valueOf(String.valueOf(resources1.get("childId")));
        if (testId == 1003) {
            gasMerchantInitDataBase.initGasRoleResource(roleId, resourceId, null, null);
        }
        // 测试过程
        Long[] resourceIds = new Long[1];
        Long[] resourceIds1 = new Long[2];
        resourceIds[0] = resourceId;
        resourceIds1[0] = resourceId;
        resourceIds1[1] = resourceId1;
        order.setRoleId(roleId);
        if (testId == 1002) {
            order.setResourceIds(resourceIds);
        }
        if (testId >= 1003) {
            order.setResourceIds(resourceIds1);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantUserService.saveAuthority(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            gasRoleResourceAssert(1, roleId, null, null);
        }
        if (testId == 1002) {
            gasRoleResourceAssert(1, roleId, resourceId, null);
        }
        if (testId == 1003 || testId == 1004) {
            gasRoleResourceAssert(2, roleId, resourceId, resourceId1);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(roleId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceSaveAuthorityTestFailOne.csv")
    @DisplayName("添加角色权限--参数非法")
    public void merchantUserServiceSaveAuthorityTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateRoleAuthorityOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setRoleId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantUserService.saveAuthority(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.角色不存在
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceSaveAuthorityTestFailTwo.csv")
    @DisplayName("添加角色权限--失败用例")
    public void merchantUserServiceSaveAuthorityTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateRoleAuthorityOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(order.getRoleId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantUserService.saveAuthority(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(order.getRoleId());
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
