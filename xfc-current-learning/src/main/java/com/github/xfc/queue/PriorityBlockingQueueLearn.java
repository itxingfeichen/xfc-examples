package com.github.xfc.queue;

import com.github.xfc.model.Task;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author : chenxingfei
 * @date: 2019-04-02  22:00
 * @description: 优先级队列学习
 */
public class PriorityBlockingQueueLearn {

    /**
     * 优先级队列测试
     */
    private static final PriorityBlockingQueue<Task> priority = new PriorityBlockingQueue<>();

    /**
     * 添加任务
     *
     * @param task
     * @return
     */
    public boolean offer(Task task) {
        return priority.offer(task);
    }

    /**
     * 获取并删除一个元素
     *
     * @return
     */
    public Task poll() {
        return priority.poll();
    }
}
