package com.xfc.spring.cloud.eureka.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  07:39
 * @description: eureka启动器
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(EurekaClientApplication.class);
        springApplicationBuilder.build().run(args);
    }
}
