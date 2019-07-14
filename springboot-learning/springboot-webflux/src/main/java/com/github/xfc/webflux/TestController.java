package com.github.xfc.webflux;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenxingfei
 * @date: 2019-07-14  20:49
 * @description:
 */
@RestController
public class TestController {


    @Value("${user.id:123}")
    private String value;


    @RequestMapping(value = "test")
    public String test(){

        return value;
    }
}
