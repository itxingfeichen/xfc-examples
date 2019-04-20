package com.github.xfc.framework.demo.service.impl;

import com.github.xfc.framework.annotation.XfcService;
import com.github.xfc.framework.demo.service.TestXfcService;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  18:29
 * @description:
 */
@XfcService
public class TestXfcServiceImpl implements TestXfcService {
    @Override
    public void myioc() {
        System.out.println("test my ioc");
    }
}
