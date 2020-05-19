package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.CashierTestBase;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xyb.adk.common.lang.id.OID;
import dal.model.cashier.RouteMappingDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychaoyang
 * Created on 2018/08/22.
 */
public class OrderPayUnionApiTest extends OpenapiTestBasis {

    @Autowired
    CashierTestBase cashierTestBase;

    @AutoTest(file = "openapinew/orderPayUnionApiTestSuccess.csv")
    @DisplayName("统一订单支付--成功用例")
    public void orderPayUnionApiTestSuccess(
            int testId,
            String status,
            String code,
            // 基本参数
            String protocol,
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
            String authCode,
            String memo,
            String openId,
            String payAmount,
            String payChannelId,
            String redirectUrl,
            String remoteIp,
            String transTag,
            String userId,
            String terminalId,
            String routeStrategyId,
            String routeExpression,
            String expressionData
    ) {
        //if (testId <= 1028) {
        //    return;
        //}
        //初始化数据
        service = "orderPay";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + OID.newID();
        //清除数据
        //准备数据
        RouteMappingDO routeMappingDO = cashierTestBase.findRouteMappingByPartnerId(partnerId).get(0);
        RouteMappingDO routeMappingDO1 = new RouteMappingDO();
        BeanUtils.copyProperties(routeMappingDO, routeMappingDO1);
        routeMappingDO1.setRouteStrategyId(routeStrategyId);
        routeMappingDO1.setRouteExpression(routeExpression);
        routeMappingDO1.setExpressionData(expressionData);
        cashierTestBase.updateRouteMappingByPartnerId(partnerId, routeMappingDO1);
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("authCode", authCode);//条码支付必传
        dataMap.put("memo", "memo");//描述
        dataMap.put("openId", openId);//微信公众号必传
        dataMap.put("payAmount", payAmount);//支付金额
        dataMap.put("payChannelId", payChannelId);//支付渠道ID
        dataMap.put("remoteIp", remoteIp);//远程IP
        dataMap.put("transTag", transTag);//交易标签
        dataMap.put("userId", userId);//支付宝服务窗支付必传
        dataMap.put("terminalId", terminalId);//终端号
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("统一订单支付response:" + response.getBody());
        JSONObject result = JSONObject.parseObject(response.getBody());
        JSONObject info = JSONObject.parseObject(result.getString("info"));
        print(info);
        print(info.get("bizNo"));
        print(info.get("merchantOrderNo"));
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        if ("wechat_public_pay".equals(payChannelId) && testId != 1029) {
            JSONObject prePayInfo = info.getJSONObject("prePayInfo");
            assertTrue(!prePayInfo.getString("timeStamp").isEmpty());
            assertTrue(!prePayInfo.getString("package").isEmpty());
            assertTrue(!prePayInfo.getString("paySign").isEmpty());
            assertTrue(!prePayInfo.getString("appId").isEmpty());
            assertTrue(!prePayInfo.getString("signType").isEmpty());
            assertTrue(!prePayInfo.getString("nonceStr").isEmpty());
        }
        if (testId == 1003) {
            String prePayInfo = info.getString("prePayInfo");
            assertTrue(prePayInfo.startsWith("https://qr.95516.com"));
        }
        if (payChannelId.contains("code_pay") && testId >= 1005) {
            assertTrue(result.getString("message").contains("重新"));
            assertTrue(result.getString("description").contains("重新"));
        }
        if ("alipay_public_pay".equals(payChannelId) && testId != 1003 && testId != 1030) {
            JSONObject prePayInfo = info.getJSONObject("prePayInfo");
            assertTrue(!prePayInfo.getString("tradeNO").isEmpty());
        }
        if (testId == 1029 || testId == 1030) {
            String prePayInfo = info.getString("prePayInfo");
            assertTrue(prePayInfo.startsWith("https://dhjt-test.chinaums.com/queryService/UmsWebPayPlugins"));
        }
        //数据验证
        //清除数据
        //路由数据还原
        cashierTestBase.updateRouteMappingByPartnerId(partnerId, routeMappingDO);
    }
}
