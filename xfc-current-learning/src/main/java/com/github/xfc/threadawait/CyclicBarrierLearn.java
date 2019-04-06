package com.github.xfc.threadawait;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  22:48
 * @description: 回环栏栅测试
 */
public class CyclicBarrierLearn {

    /**
     * 初始化
     */
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    /**
     * 等待
     * @return
     * @throws BrokenBarrierException
     * @throws InterruptedException
     */
    public int await() throws BrokenBarrierException, InterruptedException {
        return cyclicBarrier.await();
    }


}
