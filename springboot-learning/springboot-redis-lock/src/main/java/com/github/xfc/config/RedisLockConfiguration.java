package com.github.xfc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author : chenxingfei
 * @date: 2019-04-05  18:28
 * @description: redis分布式锁配置
 */
@Configuration
public class RedisLockConfiguration {

    /**
     * 初始化redisLockRegistry类
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        RedisLockRegistry redisLockRegistry = new RedisLockRegistry(redisConnectionFactory, "redis-lock-test", 5L);

        redisLockRegistry.expireUnusedOlderThan(1000L);
        return redisLockRegistry;
    }
}
