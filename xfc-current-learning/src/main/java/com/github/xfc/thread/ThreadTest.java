package com.github.xfc.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程测试
 * Thread Id=5,Thread Name=Monitor Ctrl-Break
 * Thread Id=4,Thread Name=Signal Dispatcher
 * Thread Id=3,Thread Name=Finalizer
 * Thread Id=2,Thread Name=Reference Handler
 * Thread Id=1,Thread Name=main
 *
 * @author xf.chen
 * @date 2021/7/22 9:49 下午
 * @since 1.0.0
 */
public class ThreadTest {


    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        final ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("12");
        });
        for (ThreadInfo threadInfo : threadInfos) {

            System.out.printf("Thread Id=%s,Thread Name=%s\n", threadInfo.getThreadId(), threadInfo.getThreadName());
        }
    }
}
