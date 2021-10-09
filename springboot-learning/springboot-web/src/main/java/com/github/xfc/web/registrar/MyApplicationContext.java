package com.github.xfc.web.registrar;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自定义后置处理器
 *
 * @author xf.chen
 * @date 2021/9/17 11:30
 * @since 1.0.0
 */
public class MyApplicationContext extends AnnotationConfigApplicationContext {

    public MyApplicationContext(Class<?>... annotatedClasses) {
        super(annotatedClasses);
    }

    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        final DefaultListableBeanFactory beanFactory1 = (DefaultListableBeanFactory)beanFactory;
        final BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(MyBeanWithPriorityOrderedDefinitionRegistrarPostProcessor.class);
        beanFactory1.registerBeanDefinition("myBeanDefinitionRegistrarPostProcessor",beanDefinitionBuilder.getBeanDefinition());

    }
}
