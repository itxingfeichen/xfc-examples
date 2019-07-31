package com.github.xfc.web.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * @author : chenxingfei
 * @date: 2019-07-31  23:21
 * @description: 测试
 */
//@
public class AsyncTest {

//    private static LinkedBlockingQueue queue = new LinkedBlockingQueue<Runnable>();
    private static LinkedBlockingQueue queue = new LinkedBlockingQueue<Runnable>(2);
//    private static final ExecutorService pool = Executors.newFixedThreadPool(2);
    private static final ExecutorService pool = new ThreadPoolExecutor(2, 2,
        0L, TimeUnit.MILLISECONDS,
        queue);


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            dataConsumer("myData" + i);
        }
    }

    private static void dataConsumer(String data) throws ExecutionException, InterruptedException {

        System.out.println("queue.size() = " + queue.size());


//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                System.out.println("数据消费 " + data+ " time="+ Instant.now().toEpochMilli());
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, pool);
        pool.submit(()->{
            try {
                System.out.println(Thread.currentThread().getName() +" 数据消费 " + data+ " time="+ Instant.now().toEpochMilli());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



//        voidCompletableFuture.get();

    }
}
