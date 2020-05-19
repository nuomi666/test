package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.UserLeadIntoService;
import com.xyb.merchant.api.order.AllinPaySendVerifyCodeOrder;



/**
 * @author huairen
 * Created on 2020/02/11.
 */
public class UserLeadIntoServiceChannelSendVerifyCodeTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadIntoService userLeadIntoService;

	/**
	 * 1001 渠道发送验证码
	 */
	@AutoTest(file = "merchant/userLeadIntoServiceChannelSendVerifyCodeTestSuccess.csv")
	@DisplayName("渠道发送验证码--成功用例")
	public void userLeadIntoServiceChannelSendVerifyCodeTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			AllinPaySendVerifyCodeOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setPartnerId("S0302002051600092235");
		order.setEntryUserId("S0302002251300092306");
		// 调用接口
		BizResult result = userLeadIntoService.channelSendVerifyCode(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
