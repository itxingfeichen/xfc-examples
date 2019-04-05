package com.github.xfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author : chenxingfei
 * @date: 2019-04-05  18:28
 * @description: redis分布式锁配置
 */
@SpringBootApplication
public class RedisLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLockApplication.class);
    }
}
