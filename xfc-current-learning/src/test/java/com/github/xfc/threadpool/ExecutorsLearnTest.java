package com.github.xfc.threadpool;

import com.github.xfc.model.Task;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-03  23:22
 * @description:
 */
public class ExecutorsLearnTest {

    private static ExecutorsLearn executorsLearn = new ExecutorsLearn();

    @Test
    public void getNewFixedThreadPool() {
        ExecutorService newFixedThreadPool = executorsLearn.getNewFixedThreadPool(3);
        newFixedThreadPool.execute(new Task(1L,"task1","aaa"));
        newFixedThreadPool.execute(new Task(2L,"task2","bbb"));
        newFixedThreadPool.execute(new Task(3L,"task3","bbb"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();
    }

    @Test
    public void getNewSingleThreadExecutor() {

        ExecutorService newFixedThreadPool = executorsLearn.getNewSingleThreadExecutor();
        newFixedThreadPool.execute(new Task(1L,"task1","aaa"));
        newFixedThreadPool.execute(new Task(2L,"task2","bbb"));
        newFixedThreadPool.execute(new Task(3L,"task3","bbb"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();
    }

    @Test
    public void getNewCachedThreadPool() {

        ExecutorService newFixedThreadPool = executorsLearn.getNewCachedThreadPool();
        newFixedThreadPool.execute(new Task(1L,"task1","aaa"));
        newFixedThreadPool.execute(new Task(2L,"task2","bbb"));
        newFixedThreadPool.execute(new Task(3L,"task3","bbb"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();
    }

    @Test
    public void getNewScheduleCacheThreadPool() {

        ScheduledExecutorService newFixedThreadPool = (ScheduledExecutorService) executorsLearn.getNewScheduleCacheThreadPool();
        newFixedThreadPool.schedule(new Task(1L,"task1","aaa"),1, TimeUnit.SECONDS);
        newFixedThreadPool.schedule(new Task(2L,"task2","bbb"),1, TimeUnit.SECONDS);
        newFixedThreadPool.schedule(new Task(3L,"task3","bbb"),4, TimeUnit.SECONDS);
//        newFixedThreadPool.schedule(new Task(3L,"task3","bbb"));
        newFixedThreadPool.scheduleAtFixedRate(new Task(4L,"task4","bbb"),1,1,TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newFixedThreadPool.shutdown();
    }
}