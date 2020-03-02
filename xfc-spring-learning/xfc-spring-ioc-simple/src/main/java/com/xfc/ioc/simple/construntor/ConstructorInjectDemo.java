package com.xfc.ioc.simple.construntor;

import com.xfc.ioc.simple.construntor.service.BeanInstantiation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        context.registerBean(BeanInstantiation.class);
        context.refresh();

        context.close();

    }

//    @Bean
//    public BeanInstantiation init(){
//        return new BeanInstantiation();
//    }
}
