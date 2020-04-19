package com.xfc.ioc.simple.construntor.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * A
 *
 * @author jannik
 * @date 2020-02-29
 */
@Service
public class AService implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationContextAware {

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct ...");
    }

    public AService() {
        System.out.println("AService：我被初始化了");
    }

    public String helloA() {
        return "hello A";
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean............");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(":DisposableBean....");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware" + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory = " + beanFactory);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

        System.out.println("classLoader = " + classLoader);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext = " + applicationContext);
    }
}
