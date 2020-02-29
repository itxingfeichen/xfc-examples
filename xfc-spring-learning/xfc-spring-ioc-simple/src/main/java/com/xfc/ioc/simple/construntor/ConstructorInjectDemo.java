package com.xfc.ioc.simple.construntor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 构造器注入测试
 *
 * @author jannik
 * @date 2020-02-29
 */
public class ConstructorInjectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ConstructorInjectDemo.class);
        context.scan("com.xfc.ioc.simple.construntor");

        context.refresh();



        context.close();

    }
}
