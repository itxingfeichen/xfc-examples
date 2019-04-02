package com.github.xfc.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author : chenxingfei
 * @date: 2019-04-01  23:22
 * @description: 基于数组的阻塞队列
 */
public class ArrayBlockingQueueLearn {

    /**
     * 声明有界限队列
     */
    private static final ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);



    /**
     * 新增元素
     * @param obj
     * @return
     */
    public Boolean add(String obj){
        return arrayBlockingQueue.offer(obj);
    }

    /**
     * 获取元素
     * @return
     */
    public String poll(){

        return arrayBlockingQueue.poll();
    }
}
