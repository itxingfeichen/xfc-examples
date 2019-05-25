package com.com.xfc.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  16:08
 * @description: config启动类
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class);
        System.out.println("app start");
    }
}
