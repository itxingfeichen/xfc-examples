package com.github.xfc.threadawait;

import com.github.xfc.model.Task;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  23:08
 * @description: 携带Runnable参数测试
 */
public class CyclicBarrierWithRunnableTest {

    /**
     * 传入new Task()代表在4个任务完成的时候进行额外的操作
     *
     * @param args
     */
    public static void main(String[] args) {
        CyclicBarrier teaks = new CyclicBarrier(4, new Task(1L, "teaks", "332"));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Random random = new Random();
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "开始处理");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                try {
                    System.out.println(Thread.currentThread().getName() + "处理完成，开始等待其他线程");
                    teaks.await();
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
                    teaks.await();
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
                    teaks.await();
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
                    teaks.await();
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
