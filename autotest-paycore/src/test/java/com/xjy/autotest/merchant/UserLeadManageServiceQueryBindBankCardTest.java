package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.user.api.result.merchant.card.QueryMerchantCardListResult;
import com.xyb.merchant.api.service.UserLeadManageService;
import com.xyb.merchant.api.order.QueryLeadIntoOrder;



/**
 * @author huairen
 * Created on 2020/02/12.
 */
public class UserLeadManageServiceQueryBindBankCardTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadManageService userLeadManageService;

	/**
	 * 1001 查询绑卡信息
	 */
	@AutoTest(file = "merchant/userLeadManageServiceQueryBindBankCardTestSuccess.csv")
	@DisplayName("查询绑卡信息--成功用例")
	public void userLeadManageServiceQueryBindBankCardTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryLeadIntoOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setChannelId("yst");
		order.setEntryUserId("S0302002251300092306");
		// 调用接口
		QueryMerchantCardListResult result = userLeadManageService.queryBindBankCard(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
