package com.github.xfc.web.registrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * 自定义后置处理器
 *
 * @author xf.chen
 * @date 2021/9/17 11:30
 * @since 1.0.0
 */
public class MyBeanWithOrderedDefinitionRegistrarPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("MyBeanWithOrderedDefinitionRegistrarPostProcessor->postProcessBeanDefinitionRegistry test");
        final BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(MyBeanGeneralDefinitionRegistrarPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("MyBeanGeneralDefinitionRegistrarPostProcessor",
                beanDefinitionBuilder.getBeanDefinition());

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanWithOrderedDefinitionRegistrarPostProcessor->postProcessBeanFactory test");
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
