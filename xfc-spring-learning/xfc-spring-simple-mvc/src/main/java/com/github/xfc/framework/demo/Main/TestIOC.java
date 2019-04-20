package com.github.xfc.framework.demo.Main;

import com.github.xfc.framework.context.XfcApplicationContext;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  18:38
 * @description:
 */
public class TestIOC {


    public static void main(String[] args) {
        // 启动ioc容器
        XfcApplicationContext xfcApplicationContext = new XfcApplicationContext("classpath:application.properties");

        System.out.println(xfcApplicationContext);


    }
}
