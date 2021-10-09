package com.xfc.redis.pubsub.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by on 2019/4/19.
 *
 * @author xf.chen
 */
public class ThreadPoolMonitorTask {


    public static void main(String[] args) throws InterruptedException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        TimeUnit.SECONDS.sleep(100);
    }

}