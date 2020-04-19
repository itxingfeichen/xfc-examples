package com.xfc.structure.statck;

import org.junit.Test;

public class ArrayStackTest {

    @Test
    public void testStack() {
        ArrayStack stack = new ArrayStack(3);

        stack.push(10);
        stack.push(12);
        stack.push(13);


        stack.list();
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

    }

}
