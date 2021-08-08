package com.github.xfc.threadpool;

import com.github.xfc.model.Task;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-03  23:22
 * @description:
 */
public class ExecutorsLearnTest {

    private static ExecutorsLearn executorsLearn = new ExecutorsLearn();

    @Test
    public void getNewFixedThreadPool() throws InterruptedException {
        ExecutorService newFixedThreadPool = executorsLearn.getNewFixedThreadPool(3);
        newFixedThreadPool.execute(new Task(1L, "task1", "aaa"));
        newFixedThreadPool.execute(new Task(2L, "task2", "bbb"));
        newFixedThreadPool.execute(new Task(3L, "task3", "bbb"));
        newFixedThreadPool.execute(new Task(4L, "task4", "bbb"));
        newFixedThreadPool.execute(new Task(5L, "task5", "bbb"));
        newFixedThreadPool.execute(new Task(6L, "task6", "bbb"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//            newFixedThreadPool.shutdown();

        final ThreadPoolExecutor newFixedThreadPool1 = (ThreadPoolExecutor) newFixedThreadPool;
        // 动态修改核心线程数
        newFixedThreadPool1.setCorePoolSize(5);

        for (int i = 0; i < 10; i++) {
            newFixedThreadPool1.execute(new Task((long) i, "1taska" + i, "aaa"));

        }

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getNewSingleThreadExecutor() {

        ExecutorService newFixedThreadPool = executorsLearn.getNewSingleThreadExecutor();
        newFixedThreadPool.execute(new Task(1L, "task1", "aaa"));
        newFixedThreadPool.execute(new Task(2L, "task2", "bbb"));
        newFixedThreadPool.execute(new Task(3L, "task3", "bbb"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();
    }

    @Test
    public void getNewCachedThreadPool() throws InterruptedException {

        /*
         * CacheThreadPool的特点
         *  核心线程池为0，最大线程数为Integer.MAX_VALUE，适合处理高并发低延迟任务，线程均不会永久存活，在线程处理完成任务以后，会缓存60s，如果
         *  60秒内无新任务，线程则释放以节省资源，如果60s内有新任务，则使用缓存的线程进行处理，没有空闲线程，则新建线程处理
         *  如果任务处理时间久，并且负责的话，可能会导致系统崩溃。因为此线程池在没有空闲线程可利用的情况下，会无限创建线程，导致cpu变100%或OOM
         */
        ExecutorService newFixedThreadPool = executorsLearn.getNewCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            newFixedThreadPool.execute(new Task(Long.valueOf(i + ""), "task" + i, "aaa" + i));
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();
    }

    @Test
    public void getNewScheduleCacheThreadPool() {

        ScheduledExecutorService newFixedThreadPool = Executors.newScheduledThreadPool(8);
        for (int i = 0; i < 1000; i++) {
            newFixedThreadPool.schedule(new Task((long) i, "task" + i, "aaa"), 5, TimeUnit.SECONDS);
        }

//        newFixedThreadPool.schedule(new Task(3L,"task3","bbb"));
        // 周期性执行，任务发布1秒后开始，每个4秒钟执行一次
//        newFixedThreadPool.scheduleAtFixedRate(new Task(4L, "task4", "bbb"), 1, 4, TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();

    }

    @Test
    public void testThreadOrder() {
        final ExecutorService service = executorsLearn.getNewSingleThreadExecutor();

        service.submit(() -> {
            System.out.println("service A");
        });
        service.submit(() -> {
            System.out.println("service B");
        });
        service.submit(() -> {
            System.out.println("service C");
        });
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}