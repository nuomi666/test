package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.SmsService;
import com.xyb.gas.user.api.order.SendValidateCodeOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * @author nuomi@xyb.com
 * Created on 2018/10/27.
 */
public class SmsServiceSendTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION_1)
    SmsService smsService;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_user/smsServiceSendTestSuccess.csv")
	@DisplayName("发送验证码给用户--成功用例")
	public void smsServiceSendTestSuccess(
			// 基本参数
			int testId,
			Status status,
			String code,
			// 业务参数
			SendValidateCodeOrder order
	) {
		// 清除数据
		// 准备数据
		String key = order.getPartnerId() + order.getMobile();
		redisTemplate.opsForValue().set(key, "2587");
		// 测试过程
		order.setGid(GID.newGID());
		// 调用接口
		SimpleResult result = smsService.send(order);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_user/smsServiceSendTestFailOne.csv")
	@DisplayName("发送验证码给用户--成功用例")
	public void smsServiceSendTestFailOne(
			// 基本参数
			int testId,
			Status status,
			String code,
			// 业务参数
			SendValidateCodeOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		SimpleResult result = smsService.send(order);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_user/smsServiceSendTestFailTwo.csv")
	@DisplayName("发送验证码给用户--失败用例")
	public void smsServiceSendTestFailTwo(
			// 基本参数
			int testId,
			Status status,
			String code,
			// 业务参数
			SendValidateCodeOrder order
	) {
		// 清除数据
		// 准备数据
		String key = order.getPartnerId() + order.getMobile();
		// 测试过程
		// 调用接口
		SimpleResult result = smsService.send(order);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
