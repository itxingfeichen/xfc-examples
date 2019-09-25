package com.github.xfc.volatileandatomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  11:01
 * @description: volatiletest 会拒绝编译器对其修饰的变量进行优化。也就不会存在重排序的问题。volatile只会影响可见性，不会影响原子性。
 */
public class VolatileLearn {


//    static volatiletest int a = 1;

    static AtomicInteger a = new AtomicInteger(0);
    boolean ready;

    public class PrintA extends Thread {
        @Override
        public void run() {
//            a++;
            a.incrementAndGet();
//            System.out.println(Thread.currentThread().getName() + " result=" + a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileLearn t = new VolatileLearn();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            try {
                t.new PrintA().start();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
        countDownLatch.await();

        System.out.println(a.get());

    }
}

