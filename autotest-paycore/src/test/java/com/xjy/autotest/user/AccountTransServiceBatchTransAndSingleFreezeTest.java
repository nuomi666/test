package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountTransService;
import com.xyb.user.api.order.account.AccountBatchBaseOrder;
import com.xyb.user.api.order.account.BatchTransAndSingleFreezeOrder;



/**
 * @author huairen
 * Created on 2020/03/23.
 */
public class AccountTransServiceBatchTransAndSingleFreezeTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

	/**
	 * 1001 批量转账且指定单个用户进行冻结解冻
	 */
	@AutoTest(file = "user/accountTransServiceBatchTransAndSingleFreezeTestSuccess.csv")
	@DisplayName("批量转账且指定单个用户进行冻结解冻--成功用例")
	public void accountTransServiceBatchTransAndSingleFreezeTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			BatchTransAndSingleFreezeOrder order,
			AccountBatchBaseOrder batchOrder,
			AccountBatchBaseOrder batchOrder1
	) {
		// 清除数据
		// 准备数据
		// 测试过程
        List<AccountBatchBaseOrder> orders = new ArrayList<AccountBatchBaseOrder>();
        orders.add(batchOrder);
        orders.add(batchOrder1);
        order.setOrders(orders);
		// 调用接口
		BizResult result = accountTransService.batchTransAndSingleFreeze(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
