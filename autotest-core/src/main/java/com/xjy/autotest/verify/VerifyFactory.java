package com.xjy.autotest.verify;


import com.xyb.adk.common.util.money.Money;
import com.xyb.pay.api.common.enums.TransTagEnum;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;
import dal.model.pay.PaymentInstructionDO;
import org.junit.Assert;

import java.util.HashMap;

/**
 * @author ychaoyang
 * Created on 2020-05-08.
 */
public class VerifyFactory {

    public static void main(String[] args) {

        PaymentOrder expected = new PaymentOrder();
        expected.setPayAmount(new Money(10));

        PaymentInstructionDO actual = new PaymentInstructionDO();
        actual.setPayAmount(1000L);

        String[] notVerify = {"extensionContext"};
        VerifyHandler handler = VerifyFactory.createVerifyHandler();
        handler.verify( expected, actual,null, notVerify);
    }

    private static VerifyHandler first = null;

    public static VerifyHandler createVerifyHandler() {
        //首先验证String类型
        StringVerify stringVerify = new StringVerify();
        LongVerify longVerify = new LongVerify();
        MoneyVerify moneyVerify = new MoneyVerify();
        PrimitiveVerify primitiveVerify = new PrimitiveVerify();
        ListVerify listVerify = new ListVerify();
        EnumVerify enumVerify = new EnumVerify();
        MapVerify mapVerify = new MapVerify();
        JSONObjectVerify jsonObjectVerify = new JSONObjectVerify();
        JSONArrayVerify jsonArrayVerify = new JSONArrayVerify();

        ObjectVerify objectVerify = new ObjectVerify();
        //第一层 String
        first = stringVerify;
        //下一层 Long
        stringVerify.setNextHandler(longVerify);
        //下一层 基本数据类型
        longVerify.setNextHandler(primitiveVerify);
        //下一层 Money
        primitiveVerify.setNextHandler(moneyVerify);
        //下一层 List
        moneyVerify.setNextHandler(listVerify);
        //下一层 枚举
        listVerify.setNextHandler(enumVerify);
        //下一层 Map
        enumVerify.setNextHandler(mapVerify);
        //下一层 JSONObject
        mapVerify.setNextHandler(jsonObjectVerify);
        //下一层 JSONArray
        jsonObjectVerify.setNextHandler(jsonArrayVerify);
        //最后一层 JavaBean
        jsonArrayVerify.setNextHandler(objectVerify);
        return first;
    }
}
