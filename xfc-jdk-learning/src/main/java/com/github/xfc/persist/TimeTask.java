package com.github.xfc.persist;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 * save 900 1              #在900秒(15分钟)之后，如果至少有1个key发生变化，则dump内存快照。
 * <p>
 * save 300 10            #在300秒(5分钟)之后，如果至少有10个key发生变化，则dump内存快照。
 * <p>
 * save 60 10000        #在60秒(1分钟)之后，如果至少有10000个key发生变化，则dump内存快照。
 *
 * @author xf.chen
 * @date 2021/8/10 14:18
 * @since 1.0.0
 */
public class TimeTask {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    private static ConcurrentLinkedQueue<String> taskQueues = new ConcurrentLinkedQueue<>();

    public void start() {
        executorService.scheduleWithFixedDelay(() -> {
            if (taskQueues.size() > 1) {
                System.out.println("taskQueues.size() > 1");
            }
        }, 0, 900, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(() -> {
            if (taskQueues.size() > 10) {
                System.out.println("taskQueues.size() > 10");
            }

        }, 0, 300, TimeUnit.MILLISECONDS);

        executorService.scheduleWithFixedDelay(() -> {
            if (taskQueues.size() > 10000) {
                System.out.println("taskQueues.size() > 10000");
            }

        }, 0, 60, TimeUnit.MILLISECONDS);

    }

    public static void main(String[] args) throws InterruptedException {
        final TimeTask timeTask = new TimeTask();
        timeTask.start();
        for (int i = 0; i < 100000; i++) {
            taskQueues.add("i"+i);
            TimeUnit.MILLISECONDS.sleep(20);
        }
    }

}
