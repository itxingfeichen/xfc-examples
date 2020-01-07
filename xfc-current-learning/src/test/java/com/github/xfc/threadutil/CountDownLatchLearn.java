package com.github.xfc.threadutil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程计数器
 *
 * @author xf
 * @date 2020/1/7 15:19
 */
public class CountDownLatchLearn {

    private static final ExecutorService ex = Executors.newFixedThreadPool(10);

    private static final AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            ex.submit(() -> {
                integer.incrementAndGet();
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ex.shutdown();
        System.out.println("线程执行完成，result=" + integer.get());
    }

}
