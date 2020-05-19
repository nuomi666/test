//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.user.api.enums.UserGrade;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserLevelTaskDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/11/28
// */
//public class ScheduleCallBackServiceLevelTaskTest extends SpringBootTestBase {
//    @Reference(group = "com.xyb.gas.user.biz.schedule.UserLevelTaskScheduleService", version = "1.0")
//    ScheduleCallBackService updateTask;
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//
//    @AutoTest(file = "gas_user/scheduleCallBackServiceLevelTaskTestSuccess.csv")
//    @DisplayName("等级更新--成功用例")
//    public void scheduleCallBackServiceLevelTaskTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            GasMerchantDO gasMerchantDO,
//            GasMerchantDO gasMerchantDO1,
//            UserDO userDO,
//            UserDO userDO1,
//            UserDO userDO2,
//            UserLevelTaskDO userLevelTaskDO,
//            UserLevelTaskDO userLevelTaskDO1
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
//        gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO2.getUserId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
//        // 准备数据
//        Date rawTime = DateUtils.parseDate("2018-10-27");
//        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//        gasUserTestBase.insertUser(userDO);
//        gasUserTestBase.insertUser(userDO1);
//        gasUserTestBase.insertUser(userDO2);
////        gasUserTestBase.insertUserLevelTask(userLevelTaskDO);
////        gasUserTestBase.insertUserLevelTask(userLevelTaskDO1);
//        // 测试过程
//        // 第一次
//        updateTask.justDoIT();
//        // 数据验证
//        //任务
//        UserLevelTaskDO task = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO.getPartnerId()).get(0);
//        assertEquals("PROCESSING", task.getExecutionStatus());
//        assertEquals(1, task.getSubscript().intValue());
//        UserLevelTaskDO task1 = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO1.getPartnerId()).get(0);
//        assertEquals("PROCESSING", task1.getExecutionStatus());
//        assertEquals(1, task1.getSubscript().intValue());
//        //等级
//        List<UserDO> userInfos = gasUserTestBase.findUserByUserId("S0301811271500000015");
//        assertEquals(1, userInfos.size());
//        for (UserDO userInfo : userInfos) {
//            assertEquals(UserGrade.GRADE_COMMON.code(), userInfo.getGrade());
//        }
//        List<UserDO> userInfos1 = gasUserTestBase.findUserByUserId("S0301811271500000016");
//        assertEquals(1, userInfos1.size());
//        for (UserDO userInfo : userInfos1) {//第一次没更新
//            assertEquals(userDO1.getGrade(), userInfo.getGrade());
//        }
//        List<UserDO> userInfos2 = gasUserTestBase.findUserByUserId("S0301811271500000018");
//        assertEquals(1, userInfos2.size());
//        for (UserDO userInfo : userInfos1) {
//            assertEquals(UserGrade.GRADE_SILVER.code(), userInfo.getGrade());
//        }
//        // 第二次
//        updateTask.justDoIT();
//        // 数据验证
//        UserLevelTaskDO taskxx = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO.getPartnerId()).get(0);
//        assertEquals("SUCCESS", taskxx.getExecutionStatus());
//        assertEquals(2, taskxx.getSubscript().intValue());
//        UserLevelTaskDO task1xx = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO1.getPartnerId()).get(0);
//        //等级
//        List<UserDO> userInfosxx = gasUserTestBase.findUserByUserId("S0301811271500000016");
//        assertEquals(1, userInfos1.size());
//        for (UserDO userInfo : userInfos1) {//第一次没更新
//            assertEquals(UserGrade.GRADE_SILVER.code(), userInfo.getGrade());
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
//        gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO2.getUserId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
//    }
//}
