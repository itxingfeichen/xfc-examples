package com.github.xfc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xf.chen
 * @date 2021/8/24 18:26
 * @since 1.0.0
 */
@Configuration
public class MyBean {

    @Bean(value = "myServerProperties")
    public MyServerProperties myServerProperties(){
        return new MyServerProperties();
    }

}
