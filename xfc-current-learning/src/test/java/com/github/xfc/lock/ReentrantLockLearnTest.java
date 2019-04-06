package com.github.xfc.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  20:36
 * @description: 重入锁说明，已经获得锁的线程去访问一个需要相同锁的方法，不需要再次获得锁。因此叫做可重入锁
 */
public class ReentrantLockLearnTest {

    /**
     * 声明锁对象
     */
    ReentrantLockLearn reentrantLockLearn = new ReentrantLockLearn();

    @Test
    public void tryLock() {

        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> testLock());
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试锁
     */
    public void testLock() {

        Boolean aBoolean = null;
        try {
            aBoolean = reentrantLockLearn.tryLock(3L, TimeUnit.SECONDS);
            if (aBoolean) {
                testReentranctLock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获得锁
        System.out.println(Thread.currentThread().getName() + " 获得锁结果：" + aBoolean);
    }


    public void testReentranctLock(){
        Boolean aBoolean = null;
        try {
            aBoolean = reentrantLockLearn.tryLock(3L, TimeUnit.SECONDS);
            // 获得锁
            System.out.println(Thread.currentThread().getName() + " 获得锁结果：" + aBoolean);
            System.out.println("重入锁测试" + aBoolean);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}