package com.xjy.autotest.verify;

import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.util.money.Money;
import org.junit.Assert;

/**
 * @author ychaoyang
 * Created on 2020-05-08.
 */
public class LongVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isAssignableFrom(Long.class)
                || "long".equals(expected.getClass().getTypeName())
        ) {
            if (actual == null) {
                Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致", expected, 0L);
                return true;
            } else if (actual.getClass().isAssignableFrom(Money.class)) {
                Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致", expected, ((Money) actual).getCent());
                return true;
            } else {
                Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致：", expected, actual);
                return true;
            }
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);

    }
}
