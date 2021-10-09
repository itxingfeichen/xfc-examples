package com.github.xfc.web.config;

import com.github.xfc.web.annotation.MyAnnotation1;
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
    @MyAnnotation1
    public MyServerProperties myServerProperties(){
        return new MyServerProperties();
    }

    @Bean(value = "myServerProperties1")
    public MyServerProperties myServerProperties2(){
        return new MyServerProperties();
    }


}
