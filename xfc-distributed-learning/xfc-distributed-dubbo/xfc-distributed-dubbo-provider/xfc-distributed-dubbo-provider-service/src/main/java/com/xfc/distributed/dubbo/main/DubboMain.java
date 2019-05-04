package com.xfc.distributed.dubbo.main;

import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:23
 * @description: dubbo服务启动类
 */
public class DubboMain {

    public static void main(String[] args) throws IOException {
//        Main.main(args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/dubbo-provider.xml");
        context.start();
        System.in.read();
        System.out.println("=========dubbo服务启动完成----===========");
    }
}
