package com.github.xfc.web;

import com.github.xfc.web.service.CalculatingService;
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
    }

}
