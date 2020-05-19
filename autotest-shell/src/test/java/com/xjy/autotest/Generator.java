package com.xjy.autotest;

import com.xyb.gas.merchant.api.facade.MerchantService;
import org.junit.jupiter.api.Test;

import com.xjy.autotest.generate.GenerateFacadeCase;
import com.xyb.yc.shell.user.api.UserService;

public class Generator {


        String author = "nuomi";

@Test
public void genFacadeCase() {
        String methodName = "register";
        String packag = "gas_merchant";
        new GenerateFacadeCase().generate(MerchantService.class, methodName, packag, author, Generator.class);
        }

        }