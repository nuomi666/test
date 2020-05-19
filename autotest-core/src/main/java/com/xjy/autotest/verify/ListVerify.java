package com.xjy.autotest.verify;

import com.xjy.autotest.utils.StringUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ychaoyang
 * Created on 2020-05-09.
 */
public class ListVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isAssignableFrom(List.class)
                || expected.getClass().isAssignableFrom(ArrayList.class)
                || expected.getClass().isAssignableFrom(LinkedList.class)) {

            List<?> expectList = (List<?>) expected;
            List<?> actualList = null;
            try {
                actualList = (List<?>) actual;
            } catch (ClassCastException e) {
                e.printStackTrace();
                fieldName = StringUtils.isNotBlank(fieldName) ? fieldName : "";
                Assert.assertTrue(fieldName + "返回值类型错误" + actual.getClass(), false);
            }

            if (actual == null) {
                if (expectList.size() == 0) {
                    return true;
                } else {
                    Assert.assertTrue(" 实际值为空，期望值List不为空", false);
                }
            }
            Assert.assertEquals("List 的大小不等", expectList.size(), actualList.size());

            VerifyHandler handler = VerifyFactory.createVerifyHandler();
            for (int i = 0; i < expectList.size(); i++) {
                handler.verify(expectList.get(i), actualList.get(i), fieldName, notVerify);
            }
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);
    }
}
