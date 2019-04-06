package com.github.xfc.lock;

import org.junit.Test;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  21:56
 * @description: 读写分离测试
 */
public class ReentrantLockReadWritLearnTest {

    /**
     * 声明读写锁
     */
    ReentrantLockReadWritLearn reentrantLockReadWritLearn = new ReentrantLockReadWritLearn();

    /**
     * 读锁测试
     */
    public void readLockTest() {
        try {
            reentrantLockReadWritLearn.readLock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁");
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockReadWritLearn.unReadLock();
        }


    }


    /**
     * 读锁测试
     */
    public void writeLockTest() {
        System.out.println(Thread.currentThread().getName() + " 尝试获得写锁");
        try {
            reentrantLockReadWritLearn.writeLock();
            System.out.println(Thread.currentThread().getName() + " 获得写锁");
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockReadWritLearn.unWriteLock();
        }


    }

//    @Test
    public static void main(String[] agts) throws InterruptedException {

        ReentrantLockReadWritLearnTest reentrantLockReadWritLearnTest = new ReentrantLockReadWritLearnTest();
        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> reentrantLockReadWritLearnTest.readLockTest());
        executorService.execute(() -> reentrantLockReadWritLearnTest.readLockTest());

        Thread.sleep(3000L);
        executorService.execute(() -> reentrantLockReadWritLearnTest.writeLockTest());
        executorService.execute(() -> reentrantLockReadWritLearnTest.writeLockTest());

        executorService.shutdown();

    }
}