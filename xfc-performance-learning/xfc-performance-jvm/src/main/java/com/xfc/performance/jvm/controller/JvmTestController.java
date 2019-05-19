package com.xfc.performance.jvm.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author : chenxingfei
 * @date: 2019-05-18  21:51
 * @description: 测试类
 */
@RestController
public class JvmTestController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "你好:" + name;
    }

    @RequestMapping("jvmRun")
    public void jvmRun() {

        while (true) {

        }
    }

    private int i = 0;

    public void rescru(){
        i++;
        if(i<10){
            rescru();
        }
    }


    public static void main(String[] args) {

        byte[] bytes = ProxyGenerator.generateProxyClass("jvmTestController$Proxy", new Class[]{JvmTestController.class});

        try {
            FileOutputStream outputStream = new FileOutputStream("vmTestController$Proxy.class");
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("");

        Object bean = annotationConfigApplicationContext.getBean("");


    }
}
