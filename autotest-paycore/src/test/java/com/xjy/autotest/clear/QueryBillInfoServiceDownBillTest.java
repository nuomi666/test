package com.xjy.autotest.clear;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.clear.api.result.bill.BillDownResult;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import com.xyb.clear.api.order.bill.BillDownOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/11/13.
 */
public class QueryBillInfoServiceDownBillTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    QueryBillInfoService queryBillInfoService;

	@Autowired
	ClearTestBase clearTestBase;

	/**
	 * 1001
	 */
	@AutoTest(file = "clear/queryBillInfoServiceDownBillTestSuccess.csv")
	@DisplayName("--成功用例")
	public void queryBillInfoServiceDownBillTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			BillDownOrder billDownOrder
			//

	) {
		// 清除数据
		// 准备数据
		clearTestBase.findBillReconciliationDetailById(22L);
		// 测试过程
		// 调用接口
		BillDownResult result = queryBillInfoService.downBill(billDownOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
