package com.xjy.autotest.verify;

import com.xjy.autotest.utils.StringUtils;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;

import java.util.*;

/**
 * @author ychaoyang
 * Created on 2020-05-09.
 */
public class MapVerify extends VerifyHandler {
    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isAssignableFrom(Map.class)
                || expected.getClass().isAssignableFrom(HashMap.class)
                || expected.getClass().isAssignableFrom(LinkedHashMap.class)) {
            Map<String, ?> expectMap = (Map<String, ?>) expected;
            Map<String, ?> actualMap = null;
            try {
                actualMap = (Map<String, ?>) actual;
            } catch (ClassCastException e) {
                e.printStackTrace();
                fieldName = StringUtils.isNotBlank(fieldName) ? fieldName : "";
                Assert.assertTrue(fieldName + "类型错误：" + actual.getClass(), false);
            }
            if (actual == null) {
                if (expectMap.size() == 0) {
                    return true;
                } else {
                    Assert.assertTrue("实际值为空，期望值Map不为空", false);
                }
            }
            Assert.assertEquals("Map的大小不等", expectMap.size(), actualMap.size());

            VerifyHandler handler = VerifyFactory.createVerifyHandler();
            for (String key : expectMap.keySet()) {
                if (!ArrayUtils.contains(notVerify, key)) {
                    handler.verify(expectMap.get(key), actualMap.get(key), key, notVerify);
                }
            }
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);
    }
}
