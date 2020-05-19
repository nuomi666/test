package com.xjy.autotest.verify;

import com.alibaba.fastjson.JSONArray;
import com.xjy.autotest.utils.StringUtils;
import org.junit.Assert;


/**
 * @author ychaoyang
 * Created on 2020-05-11.
 */
public class JSONArrayVerify extends VerifyHandler {
    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isAssignableFrom(JSONArray.class)) {
            JSONArray expectJsonArray = (JSONArray) expected;
            JSONArray actualJsonArray = null;
            try {
                actualJsonArray = (JSONArray) actual;
            } catch (ClassCastException e) {
                e.printStackTrace();
                fieldName = StringUtils.isNotBlank(fieldName) ? fieldName : "";
                Assert.assertTrue(fieldName + "实际值并不是JSONArray类型，而是：" + actual.getClass() + " 类型", false);
            }
            if (actual == null) {
                if (expectJsonArray.size() == 0) {
                    return true;
                } else {
                    Assert.assertTrue("实际值中的JSONArray为空,但是期望值不是空", false);
                }
            }
            Assert.assertEquals("期望的JSONArray的大小与实际的不相等", expectJsonArray.size(), actualJsonArray.size());

            VerifyHandler handler = VerifyFactory.createVerifyHandler();
            for (int i = 0; i < expectJsonArray.size(); i++) {
                handler.verify(expectJsonArray.getJSONObject(i), actualJsonArray.getJSONObject(i), fieldName, notVerify);
            }
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);

    }
}
