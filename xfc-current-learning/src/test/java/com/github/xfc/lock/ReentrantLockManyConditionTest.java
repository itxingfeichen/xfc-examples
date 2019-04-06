package com.github.xfc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  21:17
 * @description: 多个condition测试
 */
public class ReentrantLockManyConditionTest {

    /**
     * 声明锁对象
     */
    private ReentrantLockLearn reentrantLockLearn = new ReentrantLockLearn();

    private Condition condition = reentrantLockLearn.getCondition();
    private Condition condition1 = reentrantLockLearn.getCondition();

    public void method1() {
        try {
            reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "method1获得锁开始等待");
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
            reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "method2获得锁开始等待");
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

    public void method3() {
        try {
            reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "method3获得锁开始等待");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "释放锁");
            // await方法将会释放所
            condition1.await();
            System.out.println(Thread.currentThread().getName() + "我被唤醒啦");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockLearn.unLock();
        }
    }

    public void method4() {
        try {
            reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "获得锁开始唤醒");
            System.out.println(Thread.currentThread().getName() + "method4唤醒method1，method2");
            // await方法将会释放所
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockLearn.unLock();
        }
    }

    public void method5() {
        try {
            reentrantLockLearn.tryLock(5L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "获得锁开始唤醒");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "开始唤醒method3");
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLockLearn.unLock();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockManyConditionTest reentrantLockConditionTest = new ReentrantLockManyConditionTest();
        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> reentrantLockConditionTest.method1());
        executorService.execute(() -> reentrantLockConditionTest.method2());
        executorService.execute(() -> reentrantLockConditionTest.method3());

        TimeUnit.SECONDS.sleep(3);
        // 唤醒method1，2
        executorService.execute(() -> reentrantLockConditionTest.method4());

        TimeUnit.SECONDS.sleep(10);
        executorService.execute(() -> reentrantLockConditionTest.method5());

        executorService.shutdown();
    }

}
