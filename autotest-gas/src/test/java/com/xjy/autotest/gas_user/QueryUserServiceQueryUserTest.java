package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.QueryUserService;
import com.xyb.gas.user.api.order.QueryUserByMobileOrder;
import org.junit.jupiter.api.DisplayName;



/**
 * @author nuomi@xyb.com
 * Created on 2018/10/27.
 */
public class QueryUserServiceQueryUserTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION_1)
    QueryUserService queryUserService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_user/queryUserServiceQueryUserTestSuccess.csv")
	@DisplayName("通过手机号和短信验证码查询用户相关信息--成功用例")
	public void queryUserServiceQueryUserTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryUserByMobileOrder arg0
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		BizResult result = queryUserService.queryUser(arg0);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
