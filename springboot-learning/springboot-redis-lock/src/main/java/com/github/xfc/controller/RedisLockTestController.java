package com.github.xfc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author : chenxingfei
 * @date: 2019-04-05  18:34
 * @description: redis分布式锁测试
 * 问题:锁无法自动超时
 */
@RestController
@Slf4j
public class RedisLockTestController {

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @GetMapping("/testRedisLock")
    public void testRedisLock(){
        // 加锁
        Lock redisLock = redisLockRegistry.obtain("redisLock");
        try {
            boolean lock = redisLock.tryLock(5, TimeUnit.SECONDS);
            if (lock) {
                // 获得锁
                log.info("开始处理业务");
            }
            log.info(Thread.currentThread().getName()+"get lock flag is : {}",lock);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            redisLock.unlock();
        }

    }

    /**
     * 新起动两个线程去测试分布式锁
     */
    @GetMapping("/test")
    public void test(){

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->testRedisLock());

        executorService.execute(()->testRedisLock());
    }
}
