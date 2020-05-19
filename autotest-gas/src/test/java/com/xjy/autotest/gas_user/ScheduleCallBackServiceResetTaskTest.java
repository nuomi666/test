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
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserIntegralResetTaskDO;
//import dal.model.promotion.PointsDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/11/27
// */
//public class ScheduleCallBackServiceResetTaskTest extends SpringBootTestBase {
//    @Reference(group = "com.xyb.gas.user.biz.schedule.UserIntegralResetTaskScheduleService", version = "1.0")
//    ScheduleCallBackService resetTask;
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
//    @AutoTest(file = "gas_user/scheduleCallBackServiceResetTaskTestSuccess.csv")
//    @DisplayName("积分清零--成功用例")
//    public void scheduleCallBackServiceResetTaskTestSuccess(
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
//            UserIntegralResetTaskDO userIntegralResetTaskDO,
//            UserIntegralResetTaskDO userIntegralResetTaskDO1,
//            PointsDO pointsDO,
//            PointsDO pointsDO1,
//            PointsDO pointsDO2
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
//        gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO2.getUserId());
////        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(userIntegralResetTaskDO.getPartnerId());
////        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(userIntegralResetTaskDO1.getPartnerId());
////        promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
////        promotionTestBase.cleanPointsByUserId(pointsDO1.getUserId());
////        promotionTestBase.cleanPointsByUserId(pointsDO2.getUserId());
////        promotionTestBase.cleanPointsLogByUserId(pointsDO.getUserId());
////        promotionTestBase.cleanPointsLogByUserId(pointsDO1.getUserId());
////        promotionTestBase.cleanPointsLogByUserId(pointsDO2.getUserId());
//        // 准备数据
//        Date rawTime = DateUtils.parseDate("2018-10-27");
//        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//        gasUserTestBase.insertUser(userDO);
//        gasUserTestBase.insertUser(userDO1);
//        gasUserTestBase.insertUser(userDO2);
////        gasUserTestBase.insertUserIntegralResetTask(userIntegralResetTaskDO);
////        gasUserTestBase.insertUserIntegralResetTask(userIntegralResetTaskDO1);
//        // 测试过程
//        // 第一次
//        resetTask.justDoIT();
//        // 数据验证
//        sleep(3);
//        //任务
//        UserIntegralResetTaskDO task = gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO.getPartnerId()).get(0);
//        assertEquals("PROCESSING", task.getExecutionStatus());
//        assertEquals(1, task.getSubscript().intValue());
//        UserIntegralResetTaskDO task1 = gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId()).get(0);
//        assertEquals("PROCESSING", task1.getExecutionStatus());
//        assertEquals(1, task1.getSubscript().intValue());
//        // 第二次
//        resetTask.justDoIT();
//        // 数据验证
//        sleep(3);
//        UserIntegralResetTaskDO taskxx = gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO.getPartnerId()).get(0);
//        assertEquals("SUCCESS", taskxx.getExecutionStatus());
//        assertEquals(2, taskxx.getSubscript().intValue());
//        UserIntegralResetTaskDO task1xx = gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId()).get(0);
//        //积分
//        List<PointsDO> points = promotionTestBase.findPointsByUserId(userDO.getUserId());
//        assertEquals(1, points.size());
//        for (PointsDO point : points) {
//            assertEquals(0L, point.getPoints());
//        }
//        List<PointsDO> points1 = promotionTestBase.findPointsByUserId(userDO1.getUserId());
//        assertEquals(1, points1.size());
//        for (PointsDO point : points1) {
//            assertEquals(0L, point.getPoints());
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
//        gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO2.getUserId());
////        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(gasMerchantDO.getPartnerId());
////        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId());
//        promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
//        promotionTestBase.cleanPointsByUserId(pointsDO1.getUserId());
//        promotionTestBase.cleanPointsByUserId(pointsDO2.getUserId());
//        promotionTestBase.cleanPointsLogByUserId(pointsDO.getUserId());
//        promotionTestBase.cleanPointsLogByUserId(pointsDO1.getUserId());
//        promotionTestBase.cleanPointsLogByUserId(pointsDO2.getUserId());
//    }
//}
