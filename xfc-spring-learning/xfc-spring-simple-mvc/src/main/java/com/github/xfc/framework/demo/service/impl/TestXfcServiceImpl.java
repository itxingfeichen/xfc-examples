package com.github.xfc.framework.demo.service.impl;

import com.github.xfc.framework.annotation.XfcService;
import com.github.xfc.framework.demo.service.TestXfcService;
import org.junit.Test;

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

    public static void main(String[] args) {
        TestXfcServiceImpl testXfcService = new TestXfcServiceImpl();

        Class<?>[] interfaces = testXfcService.getClass().getInterfaces();

        System.out.println(interfaces[0].getSimpleName());

    }
}
