package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.MerchantLeadManageService;
import com.xyb.merchant.api.order.QueryMerchantEntryOrder;



/**
 * @author huairen
 * Created on 2020/02/12.
 */
public class MerchantLeadManageServiceQueryMerchantEntryDetailTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantLeadManageService merchantLeadManageService;

	/**
	 * 1001 查询商户进件信息
	 */
	@AutoTest(file = "merchant/merchantLeadManageServiceQueryMerchantEntryDetailTestSuccess.csv")
	@DisplayName("查询商户进件信息--成功用例")
	public void merchantLeadManageServiceQueryMerchantEntryDetailTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryMerchantEntryOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setEntryUserId("S0302002121400092283");
		// 调用接口
		BizResult result = merchantLeadManageService.queryMerchantEntryDetail(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
