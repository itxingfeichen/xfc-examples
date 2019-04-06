package com.github.xfc.lock;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  21:17
 * @description: 使用condition测试
 */
public class ReentrantLockConditionTest {

    /**
     * 声明锁对象
     */
    private ReentrantLockLearn reentrantLockLearn = new ReentrantLockLearn();

    private Condition condition = reentrantLockLearn.getCondition();

    public void method1() {
        try {
            Boolean aBoolean = reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "获得锁开始等待");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "释放锁");
            // await方法将会释放所
            condition.await();
            System.out.println(Thread.currentThread().getName() + "我被唤醒啦");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockLearn.unLock();
        }


    }

    public void method2() {
        try {
            Boolean aBoolean = reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "获得锁");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "开始唤醒");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockLearn.unLock();
        }

    }

    public static void main(String[] args) {
        ReentrantLockConditionTest reentrantLockConditionTest = new ReentrantLockConditionTest();
        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> reentrantLockConditionTest.method1());
        executorService.execute(() -> reentrantLockConditionTest.method2());
//        executorService.execute(() -> reentrantLockConditionTest.method1());

        executorService.shutdown();
    }

}
