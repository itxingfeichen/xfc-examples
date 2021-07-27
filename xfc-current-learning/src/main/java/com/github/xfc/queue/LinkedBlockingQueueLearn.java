package com.github.xfc.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列测试
 *
 * @author xf.chen
 * @date 2021/7/27 10:02 上午
 * @since 1.0.0
 */
public class LinkedBlockingQueueLearn {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {

        final LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>();
        new Thread(() -> {
            try {
                objects.put(1);
                objects.put(2);
                objects.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " " + objects.take());
                System.out.println(Thread.currentThread().getName() + " " + objects.take());
                System.out.println(Thread.currentThread().getName() + " " + objects.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }


}
