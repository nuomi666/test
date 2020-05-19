package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.enums.CertTypeEnum;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.merchant.api.service.UserLeadIntoService;
import com.xyb.merchant.api.order.AllinPayEnterpriseRealAuthOrder;



/**
 * @author huairen
 * Created on 2020/02/12.
 */
public class UserLeadIntoServiceAllinPayVerifyEnterpriseInfoTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    UserLeadIntoService userLeadIntoService;

	/**
	 * 1001 通联企业会员信息认证
	 */
	@AutoTest(file = "merchant/userLeadIntoServiceAllinPayVerifyEnterpriseInfoTestSuccess.csv")
	@DisplayName("通联企业会员信息认证--成功用例")
	public void userLeadIntoServiceAllinPayVerifyEnterpriseInfoTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			AllinPayEnterpriseRealAuthOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setEntryUserId("S0302002251400092309");
		// 调用接口
		BizResult result = userLeadIntoService.allinPayVerifyEnterpriseInfo(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
