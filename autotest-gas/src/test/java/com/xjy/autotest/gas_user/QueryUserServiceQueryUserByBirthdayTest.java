//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.PagedResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.QueryUserService;
//import com.xyb.gas.user.api.order.QueryUserByBirthdayOrder;
//import com.xyb.gas.user.api.result.info.SimpleUserInfo;
//import dal.model.gas_user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/27.
// */
//public class QueryUserServiceQueryUserByBirthdayTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    QueryUserService queryUserService;
//
//	@Autowired
//	Gas_userTestBase gasUserBase;
//
//	/**
//	 * 生日(MM-dd,如：09-10)
//	 */
//	@AutoTest(file = "gas_user/queryUserServiceQueryUserByBirthdayTestSuccess.csv")
//	@DisplayName("根据生日查询会员信息--成功用例")
//	public void queryUserServiceQueryUserByBirthdayTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			QueryUserByBirthdayOrder order,
//			//会员信息
//			UserDO userDO,
//			UserDO userDO1,
//			UserDO userDO2
//	) {
//		// 清除数据
//		gasUserBase.cleanUserByUserId(userDO.getUserId());
//		gasUserBase.cleanUserByUserId(userDO1.getUserId());
//		gasUserBase.cleanUserByUserId(userDO2.getUserId());
//		// 准备数据
//		gasUserBase.insertUser(userDO);
//		gasUserBase.insertUser(userDO1);
//		gasUserBase.insertUser(userDO2);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		PagedResult<SimpleUserInfo> result = queryUserService.queryUserByBirthday(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		if (testId == 1003) {
//			assertEquals(order.getPageNo(), result.getPageInfo().getPageNo());
//			assertEquals(order.getPageSize(), result.getPageInfo().getPageSize());
//			assertEquals(3l, result.getPageInfo().getTotalCount());
//		} else if(testId==1004){
//			assertEquals(null, result.getPageInfo());
//		}else {
//			assertEquals(order.getPageNo(), result.getPageInfo().getPageNo());
//			assertEquals(order.getPageSize(), result.getPageInfo().getPageSize());
//			assertEquals(2l, result.getPageInfo().getTotalCount());
//		}
//		List<SimpleUserInfo> userInfos = result.getInfoList();
//		if(testId==1003){
//			assertTrue(userInfos.size() == 1);
//			assertEquals(userDO1.getUserId(),userInfos.get(0).getUserId());
//			assertEquals(userDO1.getPartnerId(),userInfos.get(0).getPartnerId());
//			assertEquals(userDO1.getMobile(),userInfos.get(0).getMobile());
//			assertEquals(userDO1.getBirthday(),userInfos.get(0).getBirthday());
//			assertEquals(userDO1.getNickName(),userInfos.get(0).getNickName());
//			assertEquals(userDO1.getHeadImgUrl(),userInfos.get(0).getHeadImgUrl());
//			assertEquals(userDO1.getSex(),userInfos.get(0).getSex().code());
//			assertEquals(userDO1.getMemberType(),userInfos.get(0).getMemberType().code());
//			assertEquals(Boolean.valueOf(userDO1.getPayed()).booleanValue(),userInfos.get(0).isPayed());
//		}
//		if(testId==1001||testId==1002){
//			assertTrue(userInfos.size() == 2);
//			assertEquals(userDO2.getUserId(),userInfos.get(0).getUserId());
//			assertEquals(userDO2.getPartnerId(),userInfos.get(0).getPartnerId());
//			assertEquals(userDO2.getMobile(),userInfos.get(0).getMobile());
//			assertEquals(userDO2.getBirthday(),userInfos.get(0).getBirthday());
//			assertEquals(userDO2.getNickName(),userInfos.get(0).getNickName());
//			assertEquals(userDO2.getHeadImgUrl(),userInfos.get(0).getHeadImgUrl());
//			assertEquals(userDO2.getSex(),userInfos.get(0).getSex().code());
//			assertEquals(userDO2.getMemberType(),userInfos.get(0).getMemberType().code());
//			assertEquals(Boolean.valueOf(userDO2.getPayed()).booleanValue(),userInfos.get(0).isPayed());
//
//			assertEquals(userDO1.getUserId(),userInfos.get(1).getUserId());
//			assertEquals(userDO1.getPartnerId(),userInfos.get(1).getPartnerId());
//			assertEquals(userDO1.getMobile(),userInfos.get(1).getMobile());
//			assertEquals(userDO1.getBirthday(),userInfos.get(1).getBirthday());
//			assertEquals(userDO1.getNickName(),userInfos.get(1).getNickName());
//			assertEquals(userDO1.getHeadImgUrl(),userInfos.get(1).getHeadImgUrl());
//			assertEquals(userDO1.getSex(),userInfos.get(1).getSex().code());
//			assertEquals(userDO1.getMemberType(),userInfos.get(1).getMemberType().code());
//			assertEquals(Boolean.valueOf(userDO1.getPayed()).booleanValue(),userInfos.get(1).isPayed());
//		}
//		// 清除数据
//		gasUserBase.cleanUserByUserId(userDO.getUserId());
//		gasUserBase.cleanUserByUserId(userDO1.getUserId());
//		gasUserBase.cleanUserByUserId(userDO2.getUserId());
//	}
//}
