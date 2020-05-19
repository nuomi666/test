package com.xjy.autotest.merchant;

import java.text.ParseException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xyb.adk.common.util.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2020/01/13.
 */
public class ApplyCouponApiTest extends OpenapiTestBasis {

    @AutoTest(file = "merchant/applyCouponApiTestSuccess.csv")
    @DisplayName("核销优惠券--成功用例")
    public void applyCouponApiTestSuccess(
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
            String couponIds,
            String memo,
            String transAmount,
            String validTime
    ) throws ParseException {
        //初始化数据
        service = "applyCoupon";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        couponIds = "[\"1jysqc75gws101bqoyaa\"]";
        transAmount = "220";
		validTime = DateUtil.simpleFormat(DateUtil.tomorrow());
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("couponIds", couponIds);//券id列表
        dataMap.put("memo", memo);//备注
        dataMap.put("transAmount", transAmount);//交易金额
        dataMap.put("validTime", validTime);//有效时间【核销券的时间】
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("核销优惠券response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
