package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.merchant.SingContractInfo;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.UserLeadIntoService;
import com.xyb.merchant.api.order.AllinPaySignContractOrder;



/**
 * @author huairen
 * Created on 2020/02/11.
 */
public class UserLeadIntoServiceAllinPaySignContractTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadIntoService userLeadIntoService;

	/**
	 * 1001 通联会员电子协议签约
	 */
	@AutoTest(file = "merchant/userLeadIntoServiceAllinPaySignContractTestSuccess.csv")
	@DisplayName("通联会员电子协议签约--成功用例")
	public void userLeadIntoServiceAllinPaySignContractTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			AllinPaySignContractOrder allinPaySignContractOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		allinPaySignContractOrder.setPartnerId("S0302002051600092235");
		allinPaySignContractOrder.setEntryUserId("S0302002251300092306");
		// 调用接口
		BizResult<SingContractInfo> result = userLeadIntoService.allinPaySignContract(allinPaySignContractOrder);
		// 结果验证
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        print(result.getInfo().getUrl());
		// 数据验证
		// 清除数据
	}
}
