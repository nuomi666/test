package com.xjy.autotest.test;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import dal.model.promotion.FunLogDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author ychaoyang
 * Created on 18/12/13.
 */
public class MqTest extends SpringBootTestBase {

    @Autowired
    PromotionTestBase promotionTestBase;


    @AutoTest(file = "test/stock01161.csv")
    void stoTest(
            int testId,
            FunLogDO funLogDO,
            FunLogDO funLogDO1

    ) {
        FunLogDO fun = null;
        List<FunLogDO> list = promotionTestBase.findFunLogByCode(funLogDO.getCode());
        if (list.isEmpty()) {
            promotionTestBase.insertFunLog(funLogDO);
        } else {
            fun = list.get(0);
            fun.setNum(fun.getNum() + funLogDO.getNum());
            promotionTestBase.updateFunLogByCode(fun.getCode(), fun);
        }

        FunLogDO fun2 = null;
        List<FunLogDO> list2 = promotionTestBase.findFunLogByCode(funLogDO1.getCode());
        if (list2.isEmpty()) {
            promotionTestBase.insertFunLog(funLogDO1);
        }else {
            fun2 = list2.get(0);
            fun2.setNum(fun2.getNum() + funLogDO1.getNum());
            promotionTestBase.updateFunLogByCode(fun2.getCode(), fun2);
        }


    }
}
