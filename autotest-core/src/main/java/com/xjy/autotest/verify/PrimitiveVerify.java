package com.xjy.autotest.verify;

import com.xjy.autotest.utils.StringUtils;
import org.junit.Assert;

import java.util.Date;

/**
 * @author ychaoyang
 * Created on 2020-05-08.
 */
public class PrimitiveVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isPrimitive()
                || expected.getClass().isAssignableFrom(Boolean.class)
                || expected.getClass().isAssignableFrom(Double.class)
                || expected.getClass().isAssignableFrom(Float.class)
                || expected.getClass().isAssignableFrom(Long.class)
                || expected.getClass().isAssignableFrom(Short.class)
                || expected.getClass().isAssignableFrom(Integer.class)
                || expected.getClass().isAssignableFrom(Byte.class)
                || expected.getClass().isAssignableFrom(Date.class)
        ) {
            Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致：", expected, actual);
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);

    }
}
