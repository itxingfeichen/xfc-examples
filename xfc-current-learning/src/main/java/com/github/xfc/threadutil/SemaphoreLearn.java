package com.github.xfc.threadutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 信号量
 *
 * @author xf
 * @date 2020/1/7 16:23
 */
public class SemaphoreLearn {

    private static final ExecutorService ex = Executors.newFixedThreadPool(3);

    private static final AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        Semaphore cyclicBarrier = new Semaphore(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            ex.submit(() -> {
                try {
                    cyclicBarrier.acquire();
                    System.out.println("工人" + finalI + "占用一个机器在生产...");
                    Thread.sleep(1000L);
                    integer.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cyclicBarrier.release();
                }
            });
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ex.shutdown();
        System.out.println("线程执行完成，result=" + integer.get());
    }
}
