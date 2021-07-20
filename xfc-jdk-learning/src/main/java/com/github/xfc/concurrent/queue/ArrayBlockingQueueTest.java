package com.github.xfc.concurrent.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 队列测试
 *
 * @author xf.chen
 * @date 2021/7/20 11:48 上午
 * @since 1.0.0
 */
@DisplayName("ArrayBlockingQueue测试")
public class ArrayBlockingQueueTest {

    private Integer a;

    public ArrayBlockingQueueTest() {
        a = 10000000;
    }


    /**
     * 源码中关于构造对象时候的注释 Lock only for visibility, not mutual exclusion
     * 测试失败，忽略
     */
    @Test
    @DisplayName("构造器测试")
    @SuppressWarnings("all")
    public void testConstructor() {
        final List<Integer> collection = Arrays.asList(1, 2, 3, 4);
        AtomicReference<ArrayBlockingQueue<Integer>> finalBlockingQueue = new AtomicReference<>();
        new Thread(() -> {
            while (true) {
                if (finalBlockingQueue.get() != null) {
                    System.out.println(finalBlockingQueue.get().size());
                }
            }

        }, "Thread A").start();
        new Thread(() -> {
            finalBlockingQueue.set(new ArrayBlockingQueue<>(collection.size(), false, collection));
        }, "Thread B").start();
    }

    @Test
    @DisplayName("测试本地变量和实例变量")
    public void testLocalVariableAndInstanceVariable() {
        testInstanceVariable();
        testLocalVariable();
    }

    /**
     * 测试实例变量
     */
    private void testInstanceVariable() {
        final long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < a; i++) {
            count++;
        }
        System.out.printf("实例变量测试耗时 %d,count=%d\n", System.currentTimeMillis() - start, count);

    }

    /**
     * 测试本地变量
     */
    private void testLocalVariable() {
        final long start = System.currentTimeMillis();
        // 赋值为本地变量
        Integer a = this.a;
        int count = 0;
        for (int i = 0; i < a; i++) {
            count++;
        }
        System.out.printf("本地变量测试耗时 %d,count=%d\n", System.currentTimeMillis() - start, count);

    }
}
