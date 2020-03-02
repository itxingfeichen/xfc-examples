package com.xfc.ioc.simple.construntor.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/3/2  19:22
 * @description: 测试Bean实例化
 **/

public class BeanInstantiation extends InstantiationAwareBeanPostProcessorAdapter {



    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("beanName》》》》》" + beanName);
        return true;
    }


}
