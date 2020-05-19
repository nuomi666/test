package com.xjy.autotest.shellmerchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.yc.shell.merchant.api.result.RegisterMerchantResult;
import com.xyb.yc.shell.merchant.api.facade.MerchantService;
import com.xyb.yc.shell.merchant.api.order.RegisterMerchantOrder;



/**
 * @author miantiao
 * Created on 2019/05/18.
 */
public class MerchantServiceRegisterTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantService merchantService;

	/**
	 * 1001
	 */
	@AutoTest(file = "shellmerchant/merchantServiceRegisterTestSuccess.csv",project = "shellmerchant")
	@DisplayName("--成功用例")
	public void merchantServiceRegisterTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			RegisterMerchantOrder registerMerchantOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		RegisterMerchantResult result = merchantService.register(registerMerchantOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
