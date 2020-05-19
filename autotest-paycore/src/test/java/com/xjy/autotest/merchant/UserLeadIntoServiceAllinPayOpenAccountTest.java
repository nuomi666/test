package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.merchant.api.result.info.MerchantEntryInfo;
import com.xyb.user.api.enums.MerchantProperty;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.UserLeadIntoService;
import com.xyb.merchant.api.order.AllinPayEntryOrder;



/**
 * @author huairen
 * Created on 2020/02/10.
 */
public class UserLeadIntoServiceAllinPayOpenAccountTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadIntoService userLeadIntoService;

	/**
	 * 1001 通联进件
	 */
	@AutoTest(file = "merchant/userLeadIntoServiceAllinPayOpenAccountTestSuccess.csv")
	@DisplayName("通联进件--成功用例")
	public void userLeadIntoServiceAllinPayOpenAccountTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			AllinPayEntryOrder allinPayEntryOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		allinPayEntryOrder.setPartnerId("S0302002251400092309");
		allinPayEntryOrder.setSubMerchantProperty(MerchantProperty.NATURAL_PERSON);
		allinPayEntryOrder.setEntryUserId("S0302002251300092306");
		allinPayEntryOrder.setSubMerchantProperty(MerchantProperty.ENTERPRISE_LEGAL_PERSON);
		allinPayEntryOrder.setEntryUserId("S0302002251400092309");
		// 调用接口
		BizResult<MerchantEntryInfo> result = userLeadIntoService.allinPayOpenAccount(allinPayEntryOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
