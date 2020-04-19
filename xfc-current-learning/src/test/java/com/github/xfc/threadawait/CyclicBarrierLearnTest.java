package com.github.xfc.threadawait;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  22:52
 * @description:
 */
public class CyclicBarrierLearnTest {

    /**
     * 测试栏栅任务（必须所有任务都完成才能一起释放）是一种线程之间的阻塞
     *
     * @param args
     */
    public static void main(String[] args) {
        CyclicBarrierLearn cyclicBarrierLearn = new CyclicBarrierLearn();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Random random = new Random();
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "开始处理");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                try {
                    System.out.println(Thread.currentThread().getName() + "处理完成，开始等待其他线程");
                    cyclicBarrierLearn.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "处理完成。。。。");
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始处理");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                try {
                    System.out.println(Thread.currentThread().getName() + "处理完成，开始等待其他线程");
                    cyclicBarrierLearn.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "处理完成。。。。");
        });

        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始处理");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                try {
                    System.out.println(Thread.currentThread().getName() + "处理完成，开始等待其他线程");
                    cyclicBarrierLearn.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "处理完成。。。。");
        });

        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始处理");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                try {
                    System.out.println(Thread.currentThread().getName() + "处理完成，开始等待其他线程");
                    cyclicBarrierLearn.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "处理完成。。。。");
        });
        executorService.shutdown();

    }


}