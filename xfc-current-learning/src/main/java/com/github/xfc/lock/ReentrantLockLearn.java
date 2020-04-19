package com.github.xfc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  20:19
 * @description: ReentrantLock用法
 */
public class ReentrantLockLearn {

    /**
     * 声明锁
     */
    private static final ReentrantLock reentrantLock = new ReentrantLock();


    /**
     * 尝试获得锁
     *
     * @return
     */
    public Boolean tryLock(Long timeout, TimeUnit timeUnit) throws InterruptedException {
        reentrantLock.lock();
        return false;
    }

    /**
     * 释放锁
     */
    public void unLock() {
        reentrantLock.unlock();
    }

    /**
     * 获取Condition对象
     *
     * @return
     */
    public Condition getCondition() {

        return reentrantLock.newCondition();
    }


}
