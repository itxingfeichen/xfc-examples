package com.github.xfc.signleton;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  21:53
 * @description:
 */
public class SignletonTest {


    @Test
    public void getInstance() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 测试3个线程并打印hashcode
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> System.out.println("hashcode=" + Singleton.getInstance().hashCode()));
        }

    }

}