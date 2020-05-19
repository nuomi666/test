package com.xjy.autotest.openapinew;

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
 * Created on 2020/03/13.
 */
public class BusinessPayChangeApiTest extends OpenapiTestBasis{

	@AutoTest(file = "openapinew/businessPayChangeApiTestSuccess.csv")
	@DisplayName("微信企业支付--成功用例")
	public void businessPayChangeApiTestSuccess(
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
	        String externalMetaData,
	        String fee,
	        String feeUserId,
	        String feeUserTag,
	        String memo,
	        String payerUserId,
	        String payerUserTag,
	        String realName,
	        String receiveId,
	        String remoteIp,
	        String unFreezeCode
			){
		//初始化数据
		service = "businessPayChange";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        //merchantOrderNo = "merchantOrderNo1584068830207";
		//清除数据
		//准备数据
		fee = "0";
		amount = "1";
		//unFreezeCode = "WITHDRAW";
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("amount", amount);//支付金额（包含手续费）
		dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
		dataMap.put("fee", fee);//手续费
		dataMap.put("feeUserId", feeUserId);//手续费不为0时必填，手续费收款人userId
		dataMap.put("feeUserTag", feeUserTag);//手续费不为0时必填，手续费收款人账户Tag
		dataMap.put("memo", memo);//描述
		dataMap.put("payerUserId", payerUserId);//付款人userId
		dataMap.put("payerUserTag", payerUserTag);//付款人账户Tag
		dataMap.put("realName", realName);//真实姓名
		dataMap.put("receiveId", receiveId);//收款人ID（微信：openId）
		dataMap.put("remoteIp", remoteIp);//远程IP
		dataMap.put("unFreezeCode", unFreezeCode);//解冻码
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("微信企业支付response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
