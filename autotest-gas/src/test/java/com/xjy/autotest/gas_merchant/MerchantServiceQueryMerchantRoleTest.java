package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.FindByRoleTypeOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;



/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantServiceQueryMerchantRoleTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantService merchantService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_merchant/merchantServiceQueryMerchantRoleTestSuccess.csv")
	@DisplayName("--成功用例")
	public void merchantServiceQueryMerchantRoleTestSuccess(
			// 基本参数
			int testId,
			Status status,
			String code,
			// 业务参数
			FindByRoleTypeOrder arg0
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		BizCollectionResult result = merchantService.queryMerchantRole(arg0);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
