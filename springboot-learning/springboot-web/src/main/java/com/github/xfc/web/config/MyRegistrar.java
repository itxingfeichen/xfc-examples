package com.github.xfc.web.config;

import com.github.xfc.web.model.APIDemo;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义注册起
 *
 * @author xf.chen
 * @date 2021/9/15 10:21
 * @since 1.0.0
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        final BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(APIDemo.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("apiDemo",beanDefinition);

        System.out.println("注册回调");

    }

    public static void main(String[] args) {

        retry:
        for (;;){
            System.out.println("循环");
            break retry;
        }

        System.out.println("123");
    }
}
