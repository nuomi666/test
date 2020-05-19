package com.xjy.autotest;

import com.xjy.autotest.generate.GenerateFacadeCase;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import com.xyb.merchant.api.service.MerchantLeadManageService;
import com.xyb.merchant.api.service.MerchantManageService;
import com.xyb.merchant.api.service.UserLeadIntoService;
import com.xyb.merchant.api.service.UserLeadManageService;
import com.xyb.user.api.service.account.AccountTransService;
import org.junit.jupiter.api.Test;

public class Generator {


    String author = "huairen";

    @Test
    public void genFacadeCase() {
        String methodName = "changeBalance";
        String packag = "user";
        new GenerateFacadeCase().generate(AccountTransService.class, methodName, packag, author, Generator.class);
    }

}