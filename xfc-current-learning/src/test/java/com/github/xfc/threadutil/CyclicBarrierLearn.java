package com.github.xfc.threadutil;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 回环栅栏
 *
 * @author xf
 * @date 2020/1/7 15:25
 */
public class CyclicBarrierLearn {

    private static final ExecutorService ex = Executors.newFixedThreadPool(3);

    private static final AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            ex.submit(() -> {
                integer.incrementAndGet();
                try {
                    Thread.sleep(3000L);
                    System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                    cyclicBarrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
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
