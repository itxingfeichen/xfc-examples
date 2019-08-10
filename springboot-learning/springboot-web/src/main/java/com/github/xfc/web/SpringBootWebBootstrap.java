package com.github.xfc.web;

import com.github.xfc.autoconfigure.formatter.Formatter;
import com.github.xfc.web.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-07-18  07:52
 * @description: 启动类
 */
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

        Map<String, Formatter> beansOfType = run.getBeansOfType(Formatter.class);

        beansOfType.forEach((beanName,formatter)->{

            System.out.println("formatter execute beanName=" + beanName+
                    " result = " + formatter.format(new User("zhagnsan", 1)));

        });


    }


}
