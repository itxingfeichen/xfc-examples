package com.github.xfc.threadlocal;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  22:19
 * @description:
 */
public class MyThreadLocalTest {

    @Test
    public void testThreadLocal() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 测试3个线程并打印hashcode
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                executorService.execute(() -> {
                    MyThreadLocal myThreadLocal = new MyThreadLocal();
                    myThreadLocal.setValue("123");
                    String value = myThreadLocal.getValue();
                    Assert.assertEquals("123", value);
                });
            } else {
                executorService.execute(() -> {
                    MyThreadLocal myThreadLocal = new MyThreadLocal();
                    String value = myThreadLocal.getValue();
                    Assert.assertEquals("123", value);
                });
            }
        }

    }

}