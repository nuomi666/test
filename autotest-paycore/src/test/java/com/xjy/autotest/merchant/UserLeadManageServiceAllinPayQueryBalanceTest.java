package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.UserLeadManageService;
import com.xyb.merchant.api.order.QueryLeadIntoOrder;



/**
 * @author huairen
 * Created on 2020/02/11.
 */
public class UserLeadManageServiceAllinPayQueryBalanceTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadManageService userLeadManageService;

	/**
	 * 1001 通联会员余额查询
	 */
	@AutoTest(file = "merchant/userLeadManageServiceAllinPayQueryBalanceTestSuccess.csv")
	@DisplayName("通联会员余额查询--成功用例")
	public void userLeadManageServiceAllinPayQueryBalanceTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryLeadIntoOrder queryLeadIntoOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		queryLeadIntoOrder.setEntryUserId("S0302002251300092306");
		// 调用接口
		BizResult result = userLeadManageService.allinPayQueryBalance(queryLeadIntoOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
