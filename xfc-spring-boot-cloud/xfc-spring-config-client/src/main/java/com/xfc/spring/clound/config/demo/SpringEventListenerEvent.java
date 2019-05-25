package com.xfc.spring.clound.config.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  09:18
 * @description: spring事件
 */
public class SpringEventListenerEvent {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("event = " + event.getSource());
            }
        });
        context.refresh();
        context.publishEvent(new CustomApplicationListener("hello"));

    }

    public static class CustomApplicationListener extends ApplicationEvent {

        public CustomApplicationListener(Object source) {
            super(source);
        }
    }
}
