package com.xjy.autotest.openapinew.payaccounting;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 *@ClassName PayAccountingSuit
 *@Author noodles
 *@Date 2019/9/3 11:09
 *@Version 1.0
 * 服务应用场景：该服务是在用户在电商平台完成额度申请审核通过后，接着在电商平台成功下单需要支付时，跳到支付机构收银台，点击所显示“白条支付”按钮，
 * 会调该服务完成贷款申请， 贷款申请成功后完成交易订单支付。
 *
 * 开发实现逻辑：订单幂等性校验=>校验用户是否存在=>校验消金公司保证金是否足额=>校验用户授信余额是否充足=>过风控审核=>减少信用额度=>
 * 持久化订单并返回=>异步同步数据至数据中心（不影响成功） 计息公式xxxx；
 *
 * 用例整体设计：（非用例项设计）该用例执行需开发的基础数据xxxx.sql；该用例的xxx数据采用sql/动态插入数据准备；
 *
 * 涉及系统（表名）：系统英文名{表名（作用）}
 *
 * 特别注意：
 *
 **/

@RunWith(JUnitPlatform.class)
@SelectClasses({
        QueryProfitPayDetailApiTest.class,QueryBankCardApiTest.class,QueryBalanceApiTest.class
})
public class PayAccountingSuit {

}
