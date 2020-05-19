package com.xjy.autotest.verify;

import com.xjy.autotest.utils.StringUtils;
import org.junit.Assert;

/**
 * @author ychaoyang
 * Created on 2020-05-08.
 */
public class EnumVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {

        if (expected.getClass().isEnum()) {
            Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致", expected.toString(), String.valueOf(actual));
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);
    }
}
