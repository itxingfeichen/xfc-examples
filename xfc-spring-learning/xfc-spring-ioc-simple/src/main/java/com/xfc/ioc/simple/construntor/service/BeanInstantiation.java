//package com.xfc.ioc.simple.construntor.service;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
//import org.springframework.lang.Nullable;
//
///**
// * @author：jannik
// * @email: jannik@gmail.com
// * @date: 2020/3/2  19:22
// * @description: 测试Bean实例化
// **/
//
//public class BeanInstantiation extends InstantiationAwareBeanPostProcessorAdapter {
//
//    @Override
//    @Nullable
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//
//        System.out.println("postProcessBeforeInstantiation初始化之前调用 " + beanName);
//        return super.postProcessBeforeInstantiation(beanClass, beanName);
//    }
//
//
//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInstantiation -》beanName》》》》》" + beanName);
//        return super.postProcessBeforeInstantiation(beanClass, beanName);
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInstantiation初始化之后调用 " + beanName);
//        return true;
//    }
//
//
//}
