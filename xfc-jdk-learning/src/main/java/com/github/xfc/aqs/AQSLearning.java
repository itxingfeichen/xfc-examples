package com.github.xfc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * aqs流程学习
 * @author xf.chen
 * @date 2021/9/7 15:48
 * @since 1.0.0
 */
public class AQSLearning {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        System.out.println("业务");
        reentrantLock.unlock();


    }
}
