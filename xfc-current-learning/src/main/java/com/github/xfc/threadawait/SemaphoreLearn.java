package com.github.xfc.threadawait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  23:14
 * @description: 信号量学习
 */
public class SemaphoreLearn {


    /**
     * 测试信号量
     *
     * @param args
     */
    public static void main(String[] args) {
//        testUnfair();
        testFair();
    }

    /**
     * 测试非公平信号量
     */
    private static void testUnfair() {
        // 初始化信号量允许的个数
        Semaphore semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new SemaphoreLearn.InnerTask("task" + i, semaphore));
        }

        executorService.shutdown();

    }

    /**
     * 测试公平信号量（等待时间越久的线程越先可以获得信号量的许可）
     */
    private static void testFair() {
        // 初始化信号量允许的个数
        Semaphore semaphore = new Semaphore(1, true);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new SemaphoreLearn.InnerTask("task" + i, semaphore));
        }

        executorService.shutdown();

    }


    /**
     * 实现一个任务类
     */
    public static class InnerTask implements Runnable {

        private final String taskName;

        private final Semaphore semaphore;

        public InnerTask(String taskName, Semaphore semaphore) {
            this.taskName = taskName;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放
                semaphore.release();
            }
            System.out.println(Thread.currentThread().getName() + " 完成任务 ，任务名称为：" + taskName);
        }
    }

}
