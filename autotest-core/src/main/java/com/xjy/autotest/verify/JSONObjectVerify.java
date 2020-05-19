package com.xjy.autotest.verify;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.utils.StringUtils;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;


/**
 * @author ychaoyang
 * Created on 2020-05-09.
 */
public class JSONObjectVerify extends VerifyHandler {
    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isAssignableFrom(JSONObject.class)) {
            JSONObject expectJson = (JSONObject) expected;
            JSONObject actualJson = null;
            try {
                actualJson = (JSONObject) actual;
            } catch (ClassCastException e) {
                e.printStackTrace();
                fieldName = StringUtils.isNotBlank(fieldName) ? fieldName : "";
                Assert.assertTrue(fieldName + "实际值并不是Json类型，而是：" + actual.getClass() + " 类型", false);
            }
            if (actual == null) {
                if (expectJson.size() == 0) {
                    return true;
                } else {
                    Assert.assertTrue(" 实际值中的Json为空,但是预期值不是", false);
                }
            }
            Assert.assertEquals("输入的Json 的大小与返回的不等", expectJson.size(), actualJson.size());

            VerifyHandler handler = VerifyFactory.createVerifyHandler();
            for (String key : expectJson.keySet()) {
                if (!ArrayUtils.contains(notVerify, key)) {
                    handler.verify(expectJson.get(key), actualJson.get(key), key, notVerify);
                }
            }
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);

    }
}
