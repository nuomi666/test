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
 * Created on 2020/01/06.
 */
public class BindingBankCardApiTest extends OpenapiTestBasis {

    @AutoTest(file = "merchant/bindingBankCardApiTestSuccess.csv")
    @DisplayName("绑定银行卡--成功用例")
    public void bindingBankCardApiTestSuccess(
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
            String bankCardPhone,
            String bankId,
            String bankKey,
            String bankName,
            String certNo,
            String certType,
            String city,
            String province,
            String subBankName,
            String userId
    ) {
        //初始化数据
        service = "bindingBankCard";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        bankAccountType = "DIFFERENT_BANK_PERSONAL_ACCOUNT";
        userId = "S0302003271500092436";
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("bankAccountType", bankAccountType);//银行账户类型
        dataMap.put("bankCardName", bankCardName);//开户人姓名
        dataMap.put("bankCardNo", bankCardNo);//银行卡号
        dataMap.put("bankCardPhone", bankCardPhone);//开户人银行预留手机
        dataMap.put("bankId", bankId);//开户银行编码( 开户行总行联行号)
        dataMap.put("bankKey", bankKey);//开户行联行,联行号
        dataMap.put("bankName", bankName);//开户银行名称
        dataMap.put("certNo", certNo);//开户人证件号
        dataMap.put("certType", certType);//开户人证件类型
        dataMap.put("city", city);//开户市
        dataMap.put("province", province);//开户省
        dataMap.put("subBankName", subBankName);//支行名称
        dataMap.put("userId", userId);//用户ID
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("绑定银行卡response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
