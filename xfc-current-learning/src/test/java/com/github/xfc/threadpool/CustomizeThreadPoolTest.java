package com.github.xfc.threadpool;

import com.github.xfc.model.Task;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : chenxingfei
 * @date: 2019-04-05  14:25
 * @description:
 */
public class CustomizeThreadPoolTest {

    /**
     * 初始化线程池构建器
     */
    private static final CustomizeThreadPool customizeThreadPool = new CustomizeThreadPool();

    /**
     * 执行说明：
     * 当前任务id=0 当前任务名称=task1 核心线程池1个执行
     * 当前任务id=4 当前任务名称=task1 队列已满，开启新线程最新最新任务（maxNumPoolSize参数就是最大线程个数控制参数）
     * 当前任务id=2 当前任务名称=task1 阻塞到ArrayBlockingQueue
     * 当前任务id=1 当前任务名称=task1 阻塞到ArrayBlockingQueue
     * 当前任务id=3 当前任务名称=task1 阻塞到ArrayBlockingQueue
     */
    @Test
    public void newCustomizeThreadPool() {

        // 定义一个核心池大小为一个线程，最大线程数为2个，阻塞队列为3个元素，并且线程数大于最大线程数后的空闲线程销毁时间为1秒
        ExecutorService executorService = customizeThreadPool.newCustomizeThreadPool(1, 2, 1000L,
                TimeUnit.MICROSECONDS, new ArrayBlockingQueue(3));

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task(Long.valueOf(i), "task" + 1, "att" + 1));
        }
        // junit主线程结束不会等待子线程，因此sleep等待子线程执行
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * 执行说明：此处使用了自定义线程工厂，名称为customize thread，使用的是无界队列LinkedBlockingDeque，所以此时线程会按照核心池的大小，去LinkedBlockingDeque取出任务执行
     * 此时maxNumPoolSize参数失效，并且会无限往无界队列LinkedBlockingDeque中存储任务，大量请求时会导致请求堆积，导致OOM
     * LinkedBlockingDeque加上容量参数也可以变为有界队列
     * 当前线程customize thread1 当前任务id=0 当前任务名称=task1
     * 当前线程customize thread1 当前任务id=1 当前任务名称=task1
     * 当前线程customize thread1 当前任务id=2 当前任务名称=task1
     * 当前线程customize thread1 当前任务id=3 当前任务名称=task1
     * 当前线程customize thread1 当前任务id=4 当前任务名称=task1
     */
    @Test
    public void newCustomizeThreadPoolWithThreadFactory() {

        // 定义一个核心池大小为一个线程，最大线程数为2个，阻塞队列为3个元素，并且线程数大于最大线程数后的空闲线程销毁时间为1秒
        ExecutorService executorService = customizeThreadPool.newCustomizeThreadPoolWithThreadFactory(2, 100, 1000L,
                TimeUnit.MICROSECONDS, new LinkedBlockingDeque(),CustomizeThreadPool.newCustomizeThreadFactory());

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Task(Long.valueOf(i), "task" + 1, "att" + 1));
        }

        // junit主线程结束不会等待子线程，因此sleep等待子线程执行
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Executors自带的拒绝策略
     * AbortPolicy：直接抛出异常。
     * CallerRunsPolicy：只用调用者所在线程来运行任务。(如果线程池没有足够线程会用主线程来执行被拒绝的任务)
     * DiscardOldestPolicy：丢弃队列里最老的一个任务，并执行当前任务。
     * DiscardPolicy：不处理，丢弃掉。
     */
    @Test
    public void newCustomizeThreadPoolWithThreadFactoryAndReject() {

        // 定义一个核心池大小为一个线程，最大线程数为2个，阻塞队列为3个元素，并且线程数大于最大线程数后的空闲线程销毁时间为1秒
        ExecutorService executorService = customizeThreadPool.
                newCustomizeThreadPoolWithThreadFactoryAndReject(1, 2, 1000L,
                        TimeUnit.MICROSECONDS, new ArrayBlockingQueue(3),
                        CustomizeThreadPool.newCustomizeThreadFactory(),
                        // 自带拒绝策略之直接抛出异常测试
//                        new ThreadPoolExecutor.AbortPolicy());
                        // 自带拒绝策略之只用调用者所在线程来运行任务。(如果线程池没有足够线程会用主线程来执行被拒绝的任务)
//                        new ThreadPoolExecutor.CallerRunsPolicy());
                        // 自带拒绝策略之丢弃队列里最老的一个任务，并执行当前任务。
//                        new ThreadPoolExecutor.DiscardOldestPolicy());
                        // 自带拒绝策略之不处理，丢弃掉。
//                         new ThreadPoolExecutor.DiscardPolicy());
                        // 自定义拒绝策略
                        new CustomizeThreadPool.CustomizeRejectHandler());

        for (int i = 0; i < 6; i++) {
            executorService.submit(new Task(Long.valueOf(i), "task" + 1, "att" + 1));
        }

        // junit主线程结束不会等待子线程，因此sleep等待子线程执行
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}