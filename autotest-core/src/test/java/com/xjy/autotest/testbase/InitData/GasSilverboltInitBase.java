package com.xjy.autotest.testbase.InitData;

import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nuomi@xinyebang.com
 * Created on 2019/11/21.
 */
@Service
public class GasSilverboltInitBase {
    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 支付方式字典表
     */
    public void initGasPaywayDict(String paywayCode, String paywayType,
                                  String paywayName, String paywayIcon,
                                  String paywaySmallIcon, String channelCode,
                                  String channelFunction) {
        if (StringUtils.isNotBlank(paywayCode)) {
            silverboltTestBase.cleanGasPayWayDictByPayWayCode(paywayCode);
            silverboltTestBase.insertGasPayWayDict(0L, paywayType, paywayCode, paywayName, paywayIcon,
                    paywaySmallIcon, channelCode, channelFunction, null, null);
        }
    }
}
