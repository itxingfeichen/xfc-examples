package com.github.xfc.web.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义组件
 *
 * @author xf.chen
 * @date 2021/9/16 11:07
 * @since 1.0.0
 */
@Component
public class MyComponent {

    public MyComponent() {
        System.out.println("初始化");
    }


}

