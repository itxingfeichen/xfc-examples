package com.github.xfc.queue;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenxingfei
 * @date: 2019-04-01  23:14
 * @description:
 */
public class ConcurrentLinkedQueueLearnTest {


    @Test
    public void offerOrAdd() throws InterruptedException {

        ConcurrentLinkedQueueLearn concurrentLinkedQueueLearn = new ConcurrentLinkedQueueLearn();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> concurrentLinkedQueueLearn.offerOrAdd(Integer.toString(finalI)));
        }
//        TimeUnit.SECONDS.sleep(5000L);

        String poll = concurrentLinkedQueueLearn.poll();
        while (poll != null) {
            System.out.println(poll);
            poll = concurrentLinkedQueueLearn.poll();
        }

        System.out.println("============================");
    }
}