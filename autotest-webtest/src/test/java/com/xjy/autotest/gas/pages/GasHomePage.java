package com.xjy.autotest.gas.pages;

import com.codeborne.selenide.Selectors;
import com.xjy.autotest.gas.pages.station.StationCenterPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * 加好油商户首页
 *
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class GasHomePage {

    /**
     * 营业分析
     *
     * @return
     */
    public GasHomePage businessAnalysis() {
        $(byText("营业分析")).click();
        return this;
    }


    /**
     * 油站中心
     *
     * @return
     */
    public StationCenterPage stationCenter() {
        $(byText("油站中心")).click();
        return new StationCenterPage();
    }


}
