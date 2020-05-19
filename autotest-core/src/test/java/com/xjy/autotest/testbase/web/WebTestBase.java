package com.xjy.autotest.testbase.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created by ychaoyang on 2017/7/24.
 */
public class WebTestBase extends WebTestParameters {

    private static String OS = System.getProperty("os.name").toLowerCase();

    @BeforeAll
    static void init() {
        if (OS.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", Thread.currentThread().getContextClassLoader()
                    .getResource("webdriver/" + "chromedriver").getPath());
        } else {
            System.setProperty("webdriver.chrome.driver", Thread.currentThread().getContextClassLoader()
                    .getResource("webdriver/" + "chromedriver.exe").getPath());
        }
        //去掉浏览器驱动提示
        System.setProperty("chromeoptions.args", "disable-infobars");
        //chrome浏览器
        Configuration.browser = "chrome";
        //最小化浏览器运行
        //Configuration.headless = true;
        //设置浏览器大小
        // Configuration.browserSize = "1920x1080";
        //设置页面超时时间
        //Configuration.timeout = 6000;
        //错误页面截图
        Configuration.screenshots = false;
    }

    @AfterEach
    void tearDown() {
        close();
    }

}
