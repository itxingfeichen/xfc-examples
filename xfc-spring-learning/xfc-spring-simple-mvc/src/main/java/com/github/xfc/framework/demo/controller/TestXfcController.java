package com.github.xfc.framework.demo.controller;

import com.github.xfc.framework.annotation.XfcAutowired;
import com.github.xfc.framework.annotation.XfcController;
import com.github.xfc.framework.annotation.XfcRequestMapping;
import com.github.xfc.framework.demo.service.TestXfcService;
import com.github.xfc.framework.demo.service.impl.TestXfcWithNameServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  18:34
 * @description: testController
 */
@XfcController
public class TestXfcController {

    @XfcAutowired
    private TestXfcService testXfcService;

    @XfcAutowired(value = "customName")
    private TestXfcWithNameServiceImpl testXfcWithNameService;

    @XfcRequestMapping("/test")
    public void testRequestUrl(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("test");
    }

}
