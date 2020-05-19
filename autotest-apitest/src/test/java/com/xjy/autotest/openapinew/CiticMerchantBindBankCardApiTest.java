package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychaoyang
 * Created on 2018/12/03.
 */
public class CiticMerchantBindBankCardApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/citicMerchantBindBankCardApiTestSuccess.csv")
    @DisplayName("电商管家绑卡--成功用例")
    public void citicMerchantBindBankCardApiTestSuccess(
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
            String bankAccountType,
            String bankCardName,
            String bankCardNo,
            String bankCode,
            String bankKey,
            String userId
    ) {
        if (testId == 1001) {
            //初始化数据
            service = "citicMerchantBindBankCard";
            partnerId = pId;
            securityCheckCode = secretKey;
            merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

            bankAccountType = "DIFFERENT_BANK_PERSONAL_ACCOUNT";
            bankCardName = "于朝洋";
            bankCardNo = "6226660903688287";
            bankCode = "CEB";
            bankKey = "303653000146";
//            bankAccountType = "DIFFERENT_BANK_BUSINESS_ACCOUNT";
//            bankCardName = "林健";
//            bankCardNo = "6214600180027380539";
//            bankKey = "313707261014";
            //清除数据
            //准备数据
            //测试过程
            //主订单
            Map<String, String> dataMap = new HashMap<String, String>();
            buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
            dataMap.put("bankAccountType", bankAccountType);//银行账户类型
            dataMap.put("bankCardName", bankCardName);//开户人姓名
            dataMap.put("bankCardNo", bankCardNo);//银行卡号
            //dataMap.put("bankCode", bankCode);//银行简称
            dataMap.put("bankKey", bankKey);//联行号
            //签名
            String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.setAll(dataMap);
            map.add("sign", sign);
            print(map);
            //调用接口
            ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
            //结果验证
            print("电商管家绑卡response:" + response.toString());
            JSONObject result = JSONObject.parseObject(response.getBody());
            assertEquals(status, result.getString("status"));
            assertEquals(code, result.getString("code"));
            //数据验证
            //清除数据
        }
    }
}