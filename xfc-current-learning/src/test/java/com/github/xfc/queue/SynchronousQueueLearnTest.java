package com.github.xfc.queue;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-03  23:15
 * @description:
 */
public class SynchronousQueueLearnTest {

    @Test
    public void put() {
        SynchronousQueueLearn synchronousQueueLearn = new SynchronousQueueLearn();

        // 声明一个含有两个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(()->{
            synchronousQueueLearn.put("put a ele");

            System.out.println("test  cas end....");
        });

        // 睡眠两秒测试阻塞
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.execute(()->{
            System.out.println(synchronousQueueLearn.take());

            System.out.println(" take  test  cas end....");
        });


    }
}