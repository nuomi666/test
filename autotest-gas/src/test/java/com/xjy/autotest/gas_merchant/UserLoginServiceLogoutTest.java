package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.gas.merchant.api.facade.UserLoginService;
import com.xyb.gas.merchant.api.order.UserLogoutBossOrder;
import org.junit.jupiter.api.DisplayName;



/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class UserLoginServiceLogoutTest extends SpringBootTestBase{

	@Reference(version = "1.0")
    UserLoginService userLoginService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_merchant/userLoginServiceLogoutTestSuccess.csv")
	@DisplayName("--成功用例")
	public void userLoginServiceLogoutTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			UserLogoutBossOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		SimpleResult result = userLoginService.logout(order);
		// 结果验证
		// 数据验证
		// 清除数据
	}
}
