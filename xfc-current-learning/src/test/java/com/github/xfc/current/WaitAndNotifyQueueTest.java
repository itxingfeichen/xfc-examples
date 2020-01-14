package com.github.xfc.current;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  20:25
 * @description: 测试使用wait和notify模拟队列阻塞
 */
public class WaitAndNotifyQueueTest {

    @Test
    public void takeAndPut() {
        final WaitAndNotifyQueue waitAndNotifyQueue = new WaitAndNotifyQueue(5);
        waitAndNotifyQueue.put("a");
        waitAndNotifyQueue.put("b");
        waitAndNotifyQueue.put("c");
        waitAndNotifyQueue.put("d");
        waitAndNotifyQueue.put("e");

        // 起一个线程去新增元素
        new Thread(() -> {
            System.out.println("新增元素");
            waitAndNotifyQueue.put("f");
            System.out.println("put方法---当前容器元素" + waitAndNotifyQueue.getAllElement());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 开启第二个线程
        new Thread(() -> {
            System.out.println("获取到元素" + waitAndNotifyQueue.take());
            System.out.println("take方法--当前容器元素" + waitAndNotifyQueue.getAllElement());
        }).start();


    }

    /**
     * 通过Thread.join方法可以控制线程执行顺序
     * @throws InterruptedException
     */
    @Test
    public void testThread() throws InterruptedException {
        final Thread thread2 = new Thread(() -> {

            System.out.println("Thread.currentThread().getName()11 = " + Thread.currentThread().getName());
        });
        final Thread thread = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread.currentThread().getName()22 = " + Thread.currentThread().getName());
        });
        thread.start();
        thread2.start();

        Thread.sleep(5000L);

    }

}
