package com.xjy.autotest.gas.test;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.GasMerchantStationDO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class AddStationWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @AutoTest(file = "gas/addStationWebTestSuccess.csv")
    @DisplayName("新增油站--成功用例")
    public void addStationWebTestSuccess(
            int testId,
            String userName,
            String password,
            String stationCode,
            String stationName,
            String phoneNo,
            String stationAddress
    ) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        //打开浏览器测试页面
        open(testUrlGas);
        //登录并新增油站
        StationManagePage stationManagePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .stationManage()
                .addStation(stationCode, stationName, phoneNo, stationAddress);
        //页面数据验证
        stationManagePage.checkData(stationCode, stationName, phoneNo, stationAddress);
        //数据库数据验证
        GasMerchantStationDO gasMerchantStationDO = gas_merchantTestBase.findGasMerchantStationByStationCode(stationCode).get(0);
        assertEquals(stationName, gasMerchantStationDO.getStationName());
        assertEquals(phoneNo, gasMerchantStationDO.getPhoneNo());
        assertEquals(stationAddress, gasMerchantStationDO.getStationAddress());
        //删除油站
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
    }
}
