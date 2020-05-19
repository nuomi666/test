package com.xjy.autotest.verify;

/**
 * @author ychaoyang
 * Created on 2020-05-07.
 */
public abstract class VerifyHandler {

    /**
     * 下一个需要处理的Handler
     */
    protected VerifyHandler nextHandler;

    /**
     * @param expected  期望值
     * @param actual    实际值
     * @param fieldName 字段名
     * @param notVerify 不需要校验的字段
     * @return
     */
    public abstract Boolean verify(Object expected, Object actual, String fieldName, String[] notVerify);

    public VerifyHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(VerifyHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
