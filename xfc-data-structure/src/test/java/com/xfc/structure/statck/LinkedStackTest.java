package com.xfc.structure.statck;

import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

public class LinkedStackTest {


    @Test
    public void testLinkedStack(){
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
    public void testHashMap(){

        HashMap<Object, Object> map = new HashMap<>();
        map.put("1",2);
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }).start();
        }
    }

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1",2);
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }).start();
        }
    }

}
