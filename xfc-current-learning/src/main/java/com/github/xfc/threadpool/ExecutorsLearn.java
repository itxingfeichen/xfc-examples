package com.github.xfc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenxingfei
 * @date: 2019-04-03  22:57
 * @description: 线程池学习
 */
public class ExecutorsLearn {

    /**
     * 获取一个固定大小线程的线程池
     * 弊端：大量请求时会导致请求堆积，导致OOM
     * @param corePoolSize
     * @return
     */
    public ExecutorService getNewFixedThreadPool(int corePoolSize){
        // 暂时不去自定义实现，先了解Executors的提供
        return Executors.newFixedThreadPool(corePoolSize);
    }


    /**
     * 获取一个只有一个线程的线程池
     * 弊端：大量请求时会导致请求堆积，导致OOM
     * @return
     */
    public ExecutorService getNewSingleThreadExecutor(){
        // 暂时不去自定义实现，先了解Executors的提供
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 获取一个只有一个线程的线程池
     * 弊端：CacheThreadPool使用的是SynchronousQueue队列，最大会创建Integer.MAX_VALUE个线程
     * 过多的线程将会导致服务器资源耗尽，导致OOM
     * @return
     */
    public ExecutorService getNewCachedThreadPool(){
        // 暂时不去自定义实现，先了解Executors的提供
        return Executors.newCachedThreadPool();
    }

    /**
     * 获取一个带有延时的线程池
     * @return
     */
    public ExecutorService getNewScheduleCacheThreadPool(){

        return Executors.newScheduledThreadPool(1);

    }

}
