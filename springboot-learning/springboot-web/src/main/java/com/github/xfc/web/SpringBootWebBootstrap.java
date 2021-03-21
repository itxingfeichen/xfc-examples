package com.github.xfc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.yeauty.annotation.EnableWebSocket;

/**
 * @author : chenxingfei
 * @date: 2019-07-18  07:52
 * @description: 启动类
 */
@EnableWebSocket
@SpringBootApplication
public class SpringBootWebBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootWebBootstrap.class);
//
//        CalculatingService bean = run.getBean(CalculatingService.class);
//
//        System.out.println("求和结果" + bean.doSum(1, 2, 3, 4, 5));
//
//        Java12CalculatingService java12CalculatingService = run.getBean(Java12CalculatingService.class);
//
//        System.out.println(java12CalculatingService.doSum(1, 2, 3, 4, 5));

//        Map<String, Formatter> beansOfType = run.getBeansOfType(Formatter.class);
//
//        beansOfType.forEach((beanName, formatter) -> {
//
//            System.out.println("formatter execute beanName=" + beanName +
//                    " result = " + formatter.format(new User("zhagnsan", 1)));
//
//        });


//        run.addApplicationListener(applicationEvent -> {
//            System.out.println("监听到事件，线程号："+Thread.currentThread().getId()+" 事件源："+applicationEvent.getSource());
//        });
//        String event = "failure";
//
//        run.publishEvent(new ApplicationEvent(event) {
//            /**
//             * The object on which the Event initially occurred.
//             *
//             * @return The object on which the Event initially occurred.
//             */
//            @Override
//            public Object getSource() {
//                System.out.println("发布事件，线程号："+Thread.currentThread().getId()+" 发布事件源："+event);
//                return event;
//            }
//
//            /**
//             * Returns a String representation of this EventObject.
//             *
//             * @return A a String representation of this EventObject.
//             */
//            @Override
//            public String toString() {
//                return super.toString();
//            }
//        });




    }


}
