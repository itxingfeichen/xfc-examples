package com.xfc.spring.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  19:16
 * @description: 配置服务测试
 */
@RestController
@RefreshScope
public class ServerController {

    @Value("${my.name}")
    private String myName;

    @GetMapping("/test")
    public String index(){
        return myName;
    }
}
