package com.xjy.autotest.verify;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.utils.StringUtils;
import org.junit.Assert;

import java.util.*;

/**
 * @author ychaoyang
 * Created on 2020-05-11.
 */
public class StringVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        //期望值和实际值都为空
        if (null == expected) {
            Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致：", expected, actual);
            return true;
        }
        if (expected.getClass().isAssignableFrom(String.class)) {
            Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致：", expected.toString(), String.valueOf(actual));
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);

    }
}
