package com.xjy.autotest.verify;

import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.util.money.Money;
import org.junit.Assert;

/**
 * @author ychaoyang
 * Created on 2020-05-08.
 */
public class MoneyVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {
        if (expected.getClass().isAssignableFrom(Money.class)) {
            if (actual.getClass().isAssignableFrom(Money.class)) {
                Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致", expected, actual);
            } else {
                Assert.assertEquals(StringUtils.isNotBlank(fieldName) ? fieldName : "" + "期望值与实际值不一致", ((Money) expected).getCent(), actual);
            }
            return true;
        }
        return nextHandler.verify(expected, actual, fieldName, notVerify);

    }
}
