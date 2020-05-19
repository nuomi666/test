package com.xjy.autotest.allinpay;

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
 * Created on 2019/11/13.
 */
public class ScanPayApiTest extends OpenapiTestBasis{

	@AutoTest(file = "allinpay/scanPayApiTestSuccess.csv")
	@DisplayName("扫码支付--成功用例")
	public void scanPayApiTestSuccess(
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
	        String createUser,
	        String externalOrderNo,
	        String ip,
	        String merchantId,
	        String openId,
	        String payAmount,
	        String payChannel,
	        String payResource,
	        String remark,
	        String shopId,
	        String subPayType,
	        String orderList_amount,
	        String amountType,
	        String typeEntity
			){
		//初始化数据
		service = "scanPay";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
	    //订单手续费信息集合
	    List<Map<Object, Object>> orderList = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> orderListMap = new HashMap<Object, Object>();
	    orderListMap.put("amount", orderList_amount);//单笔收款类型的收款金额(单位:元)
	    orderListMap.put("amountType", amountType);//收款类型
	    orderListMap.put("typeEntity", typeEntity);//收款类型ID
		orderList.add(orderListMap);
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("amount", amount);//订单金额(单位:元)
		dataMap.put("createUser", createUser);//订单创建人
		dataMap.put("externalOrderNo", externalOrderNo);//外部订单号
		dataMap.put("ip", ip);//远程IP
		dataMap.put("merchantId", merchantId);//商户id
		dataMap.put("openId", openId);//openid信息 支付宝userid与微信openid 共用此属性
		dataMap.put("orderList", JSON.toJSONString(orderList));//订单手续费信息集合         
		dataMap.put("payAmount", payAmount);//订单支付总金额(单位:元)(订单金额+额外费用)
		dataMap.put("payChannel", payChannel);//支付渠道
		dataMap.put("payResource", payResource);//订单来源
		dataMap.put("remark", remark);//备注信息
		dataMap.put("shopId", shopId);//门店id
		dataMap.put("subPayType", subPayType);//订单支付具体方式
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("扫码支付response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
