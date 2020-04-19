package com.github.xfc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  21:52
 * @description: 读写锁测试
 */
public class ReentrantLockReadWritLearn {

    /**
     * 读写锁实例子
     */
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     * 读锁
     */
    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    /**
     * 写锁
     */
    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    /**
     * 增加读锁
     */
    public void readLock() {
        readLock.lock();
    }

    /**
     * 释放读锁
     */
    public void unReadLock() {
        readLock.unlock();
    }

    /**
     * 增加写锁
     */
    public void writeLock() {
        writeLock.lock();
    }

    /**
     * 释放写锁
     */
    public void unWriteLock() {
        writeLock.unlock();
    }


}
