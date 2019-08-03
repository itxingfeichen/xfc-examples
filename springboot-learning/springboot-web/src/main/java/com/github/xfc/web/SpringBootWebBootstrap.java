package com.github.xfc.web;

import com.github.xfc.web.service.CalculatingService;
import com.github.xfc.web.service.Java12CalculatingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : chenxingfei
 * @date: 2019-07-18  07:52
 * @description: 启动类
 */
@SpringBootApplication
public class SpringBootWebBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootWebBootstrap.class);

        CalculatingService bean = run.getBean(CalculatingService.class);

        System.out.println("求和结果" + bean.doSum(1, 2, 3, 4, 5));

        Java12CalculatingService java12CalculatingService = run.getBean(Java12CalculatingService.class);

        // 为了测试spring.profiles.active多个值用法
        System.out.println(java12CalculatingService.doSum(1, 2, 3, 4, 5));

    }

}
