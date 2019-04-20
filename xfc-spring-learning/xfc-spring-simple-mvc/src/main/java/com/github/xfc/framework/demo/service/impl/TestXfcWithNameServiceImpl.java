package com.github.xfc.framework.demo.service.impl;

import com.github.xfc.framework.annotation.XfcService;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  18:29
 * @description:
 */
@XfcService("customName")
public class TestXfcWithNameServiceImpl {


    public void myiocWithName() {
        System.out.println("test my ioc with name");
    }
}
