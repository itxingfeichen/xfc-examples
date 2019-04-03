package com.github.xfc.threadpool;

import com.github.xfc.model.Task;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-03  23:22
 * @description:
 */
public class ExecutorsLearnTest {

    private ExecutorsLearn executorsLearn = new ExecutorsLearn();

    @Test
    public void getNewFixedThreadPool() {
        ExecutorService newFixedThreadPool = executorsLearn.getNewFixedThreadPool(2);
        newFixedThreadPool.execute(new Task(1L,"task1","aaa"));
        newFixedThreadPool.execute(new Task(2L,"task2","bbb"));
        newFixedThreadPool.execute(new Task(2L,"task2","bbb"));

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNewSingleThreadExecutor() {
    }

    @Test
    public void getNewCachedThreadPool() {
    }

    @Test
    public void getNewScheduleCacheThreadPool() {
    }
}