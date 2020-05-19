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
public class RegisterUserAndValidateApiTest extends OpenapiTestBasis {

    @AutoTest(file = "merchant/registerUserAndValidateApiTestSuccess.csv")
    @DisplayName("注册用户并校验真实信息--成功用例")
    public void registerUserAndValidateApiTestSuccess(
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
            String certNo,
            String certType,
            String memo,
            String merchantUserId,
            String mobile,
            String realName
    ) {
        //初始化数据
        service = "registerUserAndValidate";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        merchantUserId = "merchantUserId" + System.currentTimeMillis();
        //merchantUserId = "merchantUserId1577758571689";
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("certNo", certNo);//证件号
        dataMap.put("certType", certType);//证件类型
        dataMap.put("memo", memo);//备注
        dataMap.put("merchantUserId", merchantUserId);//外部用户ID
        dataMap.put("mobile", mobile);//手机
        dataMap.put("realName", realName);//用户真实姓名
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("注册用户并校验真实信息response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
