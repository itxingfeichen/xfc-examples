package com.github.xfc.webflux.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author : chenxingfei
 * @date: 2019/7/17  14:23
 * @description: mq配置
 */
@Configuration
@ConditionalOnProperty("${config.flag.rabbitmq}")
public class RabbitMQConfig {


    @Bean
    public Queue queue() {
        return new Queue("someQueue");
    }

    @Bean
    public Exchange defaultExchange() {
        return new DirectExchange("some_exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(defaultExchange()).with("some_routeKey").noargs();
    }
}
