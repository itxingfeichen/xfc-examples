package com.github.xfc.queue;

import com.github.xfc.model.Task;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-02  22:11
 * @description:
 */
public class PriorityBlockingQueueLearnTest {

    @Test
    public void offer() {
        PriorityBlockingQueueLearn priorityBlockingQueueLearn = new PriorityBlockingQueueLearn();

        Task task = new Task();
        task.setId(18L);
        task.setName("任务12");
        Task task1 = new Task();
        task1.setId(2L);
        task1.setName("任务3");
        Task task2 = new Task();
        task2.setId(12L);
        task2.setName("任务3");
        priorityBlockingQueueLearn.offer(task);
        priorityBlockingQueueLearn.offer(task1);
        priorityBlockingQueueLearn.offer(task2);


        Task poll = priorityBlockingQueueLearn.poll();

        System.out.println(poll.toString());

        Task poll1 = priorityBlockingQueueLearn.poll();

        System.out.println(poll1.toString());
        Task poll2 = priorityBlockingQueueLearn.poll();

        System.out.println(poll2.toString());
    }
}