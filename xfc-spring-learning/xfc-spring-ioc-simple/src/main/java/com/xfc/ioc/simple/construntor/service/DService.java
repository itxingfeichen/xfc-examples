package com.xfc.ioc.simple.construntor.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/3/3  22:13
 * @description: factoryBean测试
 **/
public class DService {

    @PostConstruct
    public void init() {
        System.out.println("@@@@@@@@@@@DService init");
    }

    public DService() {
        System.out.println("@@@@@@@@@@@DService construct");
    }

    public void test(){
        System.out.println("FactoryBean 创建的Bean竟然不经历SpringBean的声明周期");
    }

    @PreDestroy
    public void destory() {
        System.out.println("@@@@@@@@@@@DService destory");

    }
}
