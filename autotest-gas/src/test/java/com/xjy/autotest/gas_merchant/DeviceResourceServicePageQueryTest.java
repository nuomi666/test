package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.PageInfo;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.ResourceType;
import com.xyb.gas.merchant.api.facade.DeviceResourceService;
import com.xyb.gas.merchant.api.order.PageQueryDeviceResourceOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/10/14.
 */
public class DeviceResourceServicePageQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    DeviceResourceService deviceResourceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.只传必填项，查询出4条，每页显示10条，显示第一页
     * 1002.只传必填项，查询出4条，每页显示2条，显示第一页
     * 1003.只传必填项，查询出4条，每页显示2条，显示第二页
     * 1004.只传必填项，查询出2条，每页显示2条，显示第一页
     * 1005.传入终端类型和资源类型，查询出3条，每页显示2条，显示第二页
     * 1006.传入所有项，查询出1条，每页显示10条，显示第一页
     */
    @AutoTest(file = "gas_merchant/deviceResourceServicePageQueryTestSuccess.csv")
    @DisplayName("分页查询终端资源--成功用例")
    public void deviceResourceServicePageQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeviceType deviceType, DeviceType deviceType1,
            ResourceType fatherType, ResourceType fatherType1, ResourceType type, ResourceType type1,
            String fatherName, String fatherName1,
            String childName, String childName1, String fatherCode, String fatherCode1, String childCode,
            String childCode1,
            PageQueryDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initDeviceResourceChild(deviceType.code(),
                fatherType.code(), type.code(), fatherName, childName, fatherCode, childCode);
        gasMerchantInitDataBase.initDeviceResourceChild(deviceType1.code(),
                fatherType1.code(), type1.code(), fatherName1, childName1, fatherCode1, childCode1);
        // 测试过程
        order.setGid(GID.newGID());
        if (testId != 1005 && testId != 1006) {
            order.setResourceType(null);
        }
        if (testId != 1006) {
            order.setName(null);
        }
        // 调用接口
        PagedResult result = deviceResourceService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        PageInfo pageInfo = result.getPageInfo();
        assertEquals(order.getPageSize(), pageInfo.getPageSize());
        assertEquals(order.getPageNo(), pageInfo.getPageNo());
        if (testId <= 1003) {
            assertEquals(4, pageInfo.getTotalCount());
        }
        if (testId == 1004) {
            assertEquals(2, pageInfo.getTotalCount());
        }
        if (testId == 1005) {
            assertEquals(3, pageInfo.getTotalCount());
        }
        if (testId == 1006) {
            assertEquals(1, pageInfo.getTotalCount());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode1);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode1);
    }

    /**
     * 1001.deviceType为空
     * 1002.gid为空
     * 1003.order为空
     */
    @AutoTest(file = "gas_merchant/deviceResourceServicePageQueryTestFailOne.csv")
    @DisplayName("分页查询终端资源--参数非法")
    public void deviceResourceServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setDeviceType(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult result = deviceResourceService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
