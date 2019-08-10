package com.github.xfc.autoconfigure.formatter.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xfc.autoconfigure.formatter.DefaultFormatter;
import com.github.xfc.autoconfigure.formatter.Formatter;
import com.github.xfc.autoconfigure.formatter.JsonFormatter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenxingfei
 * @date: 2019-08-09  07:22
 * @description: formatter auto configuration
 */
@Configuration
// 添加这个注解可以解决FormatterAutoConfiguration比JacksonAutoConfiguration优先初始化的问题
//@AutoConfigureAfter(value = {JacksonAutoConfiguration.class})
public class FormatterAutoConfiguration {

    /**
     * init bean from default formatter
     * @return
     */
    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter defaultFormatter(){
        return new DefaultFormatter();
    }

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter jsonFormatter(){
        return new JsonFormatter();
    }

    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public Formatter objectMapperFormatter(ObjectMapper objectMapper){
        return new JsonFormatter(objectMapper);
    }



}
