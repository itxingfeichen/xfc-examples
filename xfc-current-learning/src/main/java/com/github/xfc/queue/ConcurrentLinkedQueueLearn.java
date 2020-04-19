package com.github.xfc.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author : chenxingfei
 * @date: 2019-04-01  23:04
 * @description: 并发linked队列学习
 */
public class ConcurrentLinkedQueueLearn {


    /**
     * 无界非阻塞队列
     */
    private static final ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    /**
     * 向队列中新增元素
     *
     * @param obj
     */
    public Boolean offerOrAdd(String obj) {
//        concurrentLinkedQueue.forEach(System.out::println);
        return concurrentLinkedQueue.add(obj);
    }

    /**
     * 从队列中获取一个元素并从队列中删除该元素
     *
     * @return
     */
    public String poll() {
        return concurrentLinkedQueue.poll();
    }

}
