package com.xfc.structure.statck;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Calendar;
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

    public static void main(String[] args) {
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("1",2);
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
//                System.out.println(map);
//            }).start();
//        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(Calendar.SECOND, 5);
        long timeInMillis = calendar.getTimeInMillis();
        DelayQueue<Task> delayQueue = new DelayQueue<>();
        delayQueue.add(new Task("123", timeInMillis));
        delayQueue.add(new Task("12", timeInMillis));
        delayQueue.add(new Task("13", timeInMillis));
        delayQueue.add(new Task("1", timeInMillis));

        while (true) {
            try {
                Task take = delayQueue.take();
                System.out.println("take = " + take);
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
