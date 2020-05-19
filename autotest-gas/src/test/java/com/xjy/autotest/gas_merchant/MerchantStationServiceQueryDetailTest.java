package com.xjy.autotest.gas_merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;



/**
 * @author nuomi@xyb.com
 * Created on 2018/09/28.
 */
public class MerchantStationServiceQueryDetailTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantStationService merchantStationService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_merchant/merchantStationServiceQueryDetailTestSuccess.csv")
	@DisplayName("--成功用例")
	public void merchantStationServiceQueryDetailTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			CommonBaseOrder arg0
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		BizResult result = merchantStationService.queryDetail(arg0);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
