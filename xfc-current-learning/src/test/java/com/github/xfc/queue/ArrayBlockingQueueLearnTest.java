package com.github.xfc.queue;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenxingfei
 * @date: 2019-04-01  23:28
 * @description:
 */
public class ArrayBlockingQueueLearnTest {

    @Test
    public void add() {

        ArrayBlockingQueueLearn arrayBlockingQueue = new ArrayBlockingQueueLearn();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
//            arrayBlockingQueue.add(Integer.toString(finalI));
            executorService.execute(() -> arrayBlockingQueue.add(Integer.toString(finalI)));
        }
        String poll = arrayBlockingQueue.poll();
        while (poll != null) {
            System.out.println(poll);
            poll = arrayBlockingQueue.poll();
        }
        System.out.println("============================");

    }
}