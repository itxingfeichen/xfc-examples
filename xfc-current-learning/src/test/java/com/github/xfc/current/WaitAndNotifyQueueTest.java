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

}
