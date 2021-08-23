package com.xfc.structure.statck;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class LinkedStackTest {


    @Test
    public void testLinkedStack() {
        LinkedStack linkedStack = new LinkedStack(3);
        System.out.println("linkedStack.isEmpty() = " + linkedStack.isEmpty());
        System.out.println("linkedStack.isFull() = " + linkedStack.isFull());
        linkedStack.push(32);
        linkedStack.push(3233);
        linkedStack.push(123);
        linkedStack.push(123);
        linkedStack.list();
        System.out.println("linkedStack.size() = " + linkedStack.size());
        System.out.println("linkedStack.pop() = " + linkedStack.pop());
        System.out.println("linkedStack.size() = " + linkedStack.size());


    }

    @Test
    public void testHashMap() {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", 2);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("1",2);
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
//                System.out.println(map);
//            }).start();
//        }

        DelayQueue<Task> delayQueue = new DelayQueue<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                delayQueue.add(new Task("task" + finalI, System.currentTimeMillis() + finalI * 1000));
            }).start();

        }


        while (true) {
            try {
                Task take = delayQueue.take();
                System.out.println(new Date() + "take = " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Data
    @AllArgsConstructor
    public static class Task implements Delayed {

        private String taskName;

        private Long endTime;

        @Override
        public long getDelay(TimeUnit unit) {

            return unit.convert(endTime, TimeUnit.NANOSECONDS) - unit.convert(System.currentTimeMillis(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this == o) {
                return 1;
            }
            if (o == null) {
                return -1;
            }
            long diff = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
            return diff < 0 ? -1 : (diff == 0 ? 0 : 1);
        }
    }

}
