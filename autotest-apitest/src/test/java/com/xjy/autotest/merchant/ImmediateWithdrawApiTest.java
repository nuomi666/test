package com.xjy.autotest.merchant;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2019/12/31.
 */
public class ImmediateWithdrawApiTest extends OpenapiTestBasis{

	@AutoTest(file = "merchant/immediateWithdrawApiTestSuccess.csv")
	@DisplayName("实时提现--成功用例")
	public void immediateWithdrawApiTestSuccess(
			int testId,
			String status,
			String code,
			// 基本参数
			String service,
			String version,
			String partnerId,
			String securityCheckCode,
			String signType,
			String merchantOrderNo,
			String context,
			String returnUrl,
			String notifyUrl,
			// 业务参数
	        String amount,
	        String bankCard,
	        String externalMetaData,
	        String memo,
	        String withdrawUserId
			){
		//初始化数据
		service = "immediateWithdraw";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		withdrawUserId = "S0301912250900092129";
		amount = "10";
		bankCard = "6226660903688287";
		bankCard = "6216613200019257401";
		//清除数据
		//准备数据
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("amount", amount);//提现金额
		dataMap.put("bankCard", bankCard);//银行卡号，即子商户结算账户
		dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
		dataMap.put("memo", memo);//描述
		dataMap.put("withdrawUserId", withdrawUserId);//提现人userId，不传默认partnerId
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("实时提现response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
