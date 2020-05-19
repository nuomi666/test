package com.xjy.autotest.gateway;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gateway.api.base.GatewayOrder;
import com.xyb.gateway.api.service.GatewayService;
import dal.dao.pay.PaymentInstructionMapper;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ychaoyang
 * Created on 22.
 */
public class Test extends SpringBootTestBase {

    @Autowired
    PaymentInstructionMapper paymentInstructionMapper;

    @Reference(version = DUBBO_VERSION, group = "zbank_trans_log")
    GatewayService gatewayService;

    @Reference(version = DUBBO_VERSION, group = "MerchantEntryInitChannelTranTask")
    ScheduleCallBackService scheduleCallBackService;

    @AutoTest(file = "pay/test.csv")
    public void test(
            // 基本参数
            int testId,
            GatewayOrder gatewayOrder
    ) {

        new Thread(new Runnable() {
            public void run() {
                print("执行网关通知");
                gatewayService.gatewayNotity(gatewayOrder);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                print("执行定时任务");
                scheduleCallBackService.justDoIT();
            }
        }).start();
    }
}
