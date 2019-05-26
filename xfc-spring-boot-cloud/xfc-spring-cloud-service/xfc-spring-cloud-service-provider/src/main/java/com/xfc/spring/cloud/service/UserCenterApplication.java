package com.xfc.spring.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:21
 * @description: 用户信息服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserCenterApplication {


    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class);
    }
}
