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
 * Created on 2020/04/13.
 */
public class OnlyTransferApiTest extends OpenapiTestBasis{

	@AutoTest(file = "merchant/onlyTransferApiTestSuccess.csv")
	@DisplayName("单笔转账--成功用例")
	public void onlyTransferApiTestSuccess(
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
	        String memo,
	        String payAmount,
	        String payeeUserId,
	        String payeeUserTag,
	        String payerUserId,
	        String payerUserTag
			){
		//初始化数据
		service = "onlyTransfer";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		payerUserId = "S0301912250900092129";
		//payerUserId = "S0302001101500092204";
		payerUserTag = "SETTLEMENT";
		payeeUserId = "S0301912311000092151";
		//payeeUserId = "S0302004101700096515";
		payeeUserTag = "SETTLEMENT";
		payAmount = "0.1";
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("memo", memo);//描述
		dataMap.put("payAmount", payAmount);//转账金额
		dataMap.put("payeeUserId", payeeUserId);//收款方会员ID
		dataMap.put("payeeUserTag", payeeUserTag);//收款方会员tag
		dataMap.put("payerUserId", payerUserId);//付款方会员ID
		dataMap.put("payerUserTag", payerUserTag);//付款方会员tag
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("单笔转账response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
