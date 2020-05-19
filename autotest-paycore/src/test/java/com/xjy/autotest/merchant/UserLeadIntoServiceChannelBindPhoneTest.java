package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.merchant.api.order.ChannelBindPhoneOrder;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.UserLeadIntoService;



/**
 * @author huairen
 * Created on 2020/02/11.
 */
public class UserLeadIntoServiceChannelBindPhoneTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadIntoService userLeadIntoService;

	/**
	 * 1001 通联绑定手机
	 */
	@AutoTest(file = "merchant/userLeadIntoServiceChannelBindPhoneTestSuccess.csv")
	@DisplayName("通联绑定手机--成功用例")
	public void userLeadIntoServiceChannelBindPhoneTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			ChannelBindPhoneOrder channelBindPhoneOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		channelBindPhoneOrder.setPartnerId("S0302002051600092235");
		channelBindPhoneOrder.setEntryUserId("S0302002251300092306");
		channelBindPhoneOrder.setVerificationCode("174064");
		// 调用接口
		BizResult result = userLeadIntoService.channelBindPhone(channelBindPhoneOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
