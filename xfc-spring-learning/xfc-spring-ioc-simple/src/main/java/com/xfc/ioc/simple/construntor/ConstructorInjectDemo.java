package com.xfc.ioc.simple.construntor;

import com.xfc.ioc.simple.construntor.service.DService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 构造器注入测试
 *
 * @author jannik
 * @date 2020-02-29
 */
@Configuration
public class ConstructorInjectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ConstructorInjectDemo.class);
        context.scan("com.xfc.ioc.simple.construntor");

//        context.registerBean(BeanInstantiation.class);
        context.refresh();

        DService bean = context.getBean(DService.class);
        bean.test();
        context.close();

    }

}
