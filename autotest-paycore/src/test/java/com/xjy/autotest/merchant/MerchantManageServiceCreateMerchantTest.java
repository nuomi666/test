package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.user.UserResultInfo;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.MerchantManageService;
import com.xyb.user.api.order.user.RegisterUserAndAccountOrder;



/**
 * @author huairen
 * Created on 2020/02/14.
 */
public class MerchantManageServiceCreateMerchantTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantManageService merchantManageService;

	/**
	 * 1001 注册商户和账户
	 */
	@AutoTest(file = "merchant/merchantManageServiceCreateMerchantTestSuccess.csv")
	@DisplayName("注册商户和账户--成功用例")
	public void merchantManageServiceCreateMerchantTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			RegisterUserAndAccountOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setPartnerId("S0302002051600092235");
		order.setParentUserId("S0302002051600092235");
		order.setPlatPartnerId("S0302002051600092235");
		// 调用接口
		BizResult<UserResultInfo> result = merchantManageService.createMerchant(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
