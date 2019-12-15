package com.xfc.structure.statck;

import org.junit.Test;

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

}
