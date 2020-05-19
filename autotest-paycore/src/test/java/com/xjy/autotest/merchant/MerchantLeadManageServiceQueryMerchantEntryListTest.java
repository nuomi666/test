package com.xjy.autotest.merchant;

import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.merchant.api.result.BizListResult;
import com.xyb.merchant.api.service.MerchantLeadManageService;
import com.xyb.merchant.api.order.QueryMerchantEntryListOrder;



/**
 * @author huairen
 * Created on 2020/02/12.
 */
public class MerchantLeadManageServiceQueryMerchantEntryListTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantLeadManageService merchantLeadManageService;

	/**
	 * 1001 查询商户进件列表
	 */
	@AutoTest(file = "merchant/merchantLeadManageServiceQueryMerchantEntryListTestSuccess.csv")
	@DisplayName("查询商户进件列表--成功用例")
	public void merchantLeadManageServiceQueryMerchantEntryListTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryMerchantEntryListOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setPage(new Page());
		// 调用接口
		BizListResult result = merchantLeadManageService.queryMerchantEntryList(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
