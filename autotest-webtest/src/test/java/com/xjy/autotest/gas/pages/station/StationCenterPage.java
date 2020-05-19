package com.xjy.autotest.gas.pages.station;

import com.xjy.autotest.gas.pages.GasHomePage;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * 油站中心页面
 *
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class StationCenterPage {

    /**
     * 油站管理
     *
     * @return
     */
    public StationManagePage stationManage() {
        $(byLinkText("油站管理")).click();
        return new StationManagePage();
    }

    /**
     * 站长管理
     *
     * @return
     */
    public StationCenterPage stationManager() {
        $(byText("站长管理")).click();
        return this;
    }


}
