package com.github.xfc.threadpool;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : chenxingfei
 * @date: 2019-04-05  14:12
 * @description: 自定义线程池
 */
public class CustomizeThreadPool {


    /**
     * 自定义普通线程池
     *
     * @return
     */
    public ExecutorService newCustomizeThreadPool(Integer corePoolSize, Integer maxNumPoolSize, Long keepALiveTime, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        return new ThreadPoolExecutor(corePoolSize, maxNumPoolSize, keepALiveTime, timeUnit, blockingQueue);
    }

    /**
     * 自定义线程池,自定义线程工厂
     *
     * @return
     */
    public ExecutorService newCustomizeThreadPoolWithThreadFactory(Integer corePoolSize, Integer maxNumPoolSize, Long keepALiveTime, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(corePoolSize, maxNumPoolSize, keepALiveTime, timeUnit, blockingQueue, threadFactory);
    }

    /**
     * 自定义线程池,自定义线程工厂并自定义拒绝策略
     *
     * @return
     */
    public ExecutorService newCustomizeThreadPoolWithThreadFactoryAndReject(Integer corePoolSize, Integer maxNumPoolSize, Long keepALiveTime, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(corePoolSize, maxNumPoolSize, keepALiveTime, timeUnit, blockingQueue, threadFactory, handler);
    }

    /**
     * 自定义线程池测试
     */
    public static class CustomizeThreadFactory implements ThreadFactory {

        public static final AtomicInteger atomicInteger = new AtomicInteger(1);

        private final ThreadGroup group;

        public CustomizeThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            this.group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    "customize thread" + atomicInteger.getAndIncrement(),
                    0);
            return t;
        }
    }

    /**
     * 构建自定义线程工厂对象
     *
     * @return
     */
    public static CustomizeThreadFactory newCustomizeThreadFactory() {
        return new CustomizeThreadFactory();
    }

    /**
     * 自定义拒绝策略
     */
    public static class CustomizeRejectHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            FutureTask r1 = (FutureTask) r;
            System.out.println("当前拒绝的任务为：" + r.toString());
            System.out.println("进入自定义拒绝策略");
            System.out.println("队列剩余个数" + executor.getQueue().remainingCapacity());
        }
    }


    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "周期任务 "+ new Date());
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);


        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "周期任务1 " + new Date());
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }, 2, 3, TimeUnit.SECONDS);
    }

}
