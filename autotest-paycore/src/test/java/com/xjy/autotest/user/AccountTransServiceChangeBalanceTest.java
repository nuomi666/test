/*
package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import dal.model.user.AccountChangeLogDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountTransService;
import com.xyb.user.api.order.account.AccountBalanceChangeOrder;
import org.springframework.beans.factory.annotation.Autowired;


*/
/**
 * @author huairen
 * Created on 2020/04/01.
 *//*

public class AccountTransServiceChangeBalanceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    */
/**
     * 1001 余额变多
     * 1002 余额变少
     * 1003 余额变为0
     * 1004 余额变为10000
     * 1005 幂等请求
     *//*

    @AutoTest(file = "user/accountTransServiceChangeBalanceTestSuccess.csv")
    @DisplayName("账户余额变更--成功用例")
    public void accountTransServiceChangeBalanceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountBalanceChangeOrder order,
            AccountDO accountDO
    ) {
        // 清除数据
        userTestBase.cleanAccountChangeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        // 测试过程
        if (testId == 1005) {
            accountTransService.changeBalance(order);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.changeBalance(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        AccountDO accountDO1 = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        assertEquals(accountDO1.getBalance(), order.getBalance().getCent());

        AccountChangeLogDO accLogDO = userTestBase.findAccountChangeLogByReqId(order.getReqId()).get(0);
        assertEquals(order.getGid(), accLogDO.getGid());
        assertEquals(order.getPartnerId(), accLogDO.getPartnerId());
        assertEquals(order.getPlatPartnerId(), accLogDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), accLogDO.getPlatMerchantOrderNo());
        assertEquals(order.getMerchantOrderNo(), accLogDO.getMerchantOrderNo());
        assertEquals(order.getBalance().getCent(), accLogDO.getBalance());
        assertEquals(order.getMemo(), accLogDO.getMemo());
        assertEquals(order.getRawAddTime(), accLogDO.getAccountTime());
        // 清除数据
        userTestBase.cleanAccountChangeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }

    */
/**
     * 1001 gid 缺省
     * 1002 reqId 缺省
     * 1003 partnerId 缺省
     * 1004 merchantOrderNo 缺省
     * 1005 accountNo 缺省
     * 1006 balance 缺省
     * 1007 rawAddTime 缺省
     *//*

    @AutoTest(file = "user/accountTransServiceChangeBalanceTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void accountTransServiceChangeBalanceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountBalanceChangeOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.changeBalance(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    */
/**
     * 1001 余额不变
     * 1002 余额变动时间之前的变动
     * 1003 账户不存在
     * 1004 变动余额为负
     *//*

    @AutoTest(file = "user/accountTransServiceChangeBalanceTestFailTwo.csv")
    @DisplayName("账户余额变更--失败用例")
    public void accountTransServiceChangeBalanceTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountBalanceChangeOrder order,
            AccountDO accountDO
    ) {
        // 清除数据
        userTestBase.cleanAccountChangeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        // 准备数据
        if (testId != 1003) {
            userTestBase.insertAccount(accountDO);
        }
        // 测试过程
        if (testId == 1002) {
            accountTransService.changeBalance(order);
            order.setRawAddTime(DateUtil.getStartTimeOfTheDate(order.getRawAddTime()));
            order.setReqId(OID.newID());
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.changeBalance(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        List<AccountChangeLogDO> accLogDOs = userTestBase.findAccountChangeLogByReqId(order.getReqId());
        assertEquals(0, accLogDOs.size());
        if (testId != 1003) {
            AccountDO accountDO1 = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
            assertEquals(accountDO, accountDO1);
        }
        // 清除数据
        //userTestBase.cleanAccountChangeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }
}
*/
