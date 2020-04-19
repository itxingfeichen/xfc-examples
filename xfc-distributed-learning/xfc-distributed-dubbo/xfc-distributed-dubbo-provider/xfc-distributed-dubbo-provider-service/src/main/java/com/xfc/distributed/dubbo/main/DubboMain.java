package com.xfc.distributed.dubbo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:23
 * @description: dubbo服务启动类
 */
@ImportResource(locations = "classpath:META-INF/spring/dubbo-provider.xml")
@ComponentScan(basePackages = "com.xfc.distributed.dubbo")
public class DubboMain {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DubboMain.class);
//        Main.main(args);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/dubbo-provider.xml");
//        context.start();
        System.in.read();
        System.out.println("=========dubbo服务启动完成----===========");
    }
}
