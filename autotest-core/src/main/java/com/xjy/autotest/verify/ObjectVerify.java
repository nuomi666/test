package com.xjy.autotest.verify;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @author ychaoyang
 * Created on 2020-05-08.
 */
public class ObjectVerify extends VerifyHandler {

    @Override
    public Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify) {

        Field[] expectedFields = FieldUtils.getAllFields(expected.getClass());
        Field[] actualFields = FieldUtils.getAllFields(actual.getClass());
        VerifyHandler handler = VerifyFactory.createVerifyHandler();
        for (int i = 0; i < expectedFields.length; i++) {
            Field ef = expectedFields[i];
            ef.setAccessible(true);
            if (ArrayUtils.contains(notVerify, ef.getName()) ||
                    "serialVersionUID".equals(ef.getName())) {
                continue;
            }
            for (int j = 0; j < actualFields.length; j++) {
                Field af = actualFields[j];
                af.setAccessible(true);
                if (ef.getName().equals(af.getName())) {
                    try {
                        handler.verify(ef.get(expected), af.get(actual), ef.getName(), notVerify);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}
