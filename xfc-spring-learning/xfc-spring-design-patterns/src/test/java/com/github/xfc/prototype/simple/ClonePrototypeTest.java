package com.github.xfc.prototype.simple;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  20:45
 * @description:
 */
public class ClonePrototypeTest {

    @Test
    public void testClonePrototype(){
        ClonePrototype clonePrototype = new ClonePrototype();
        try {
            ClonePrototype clone = (ClonePrototype) clonePrototype.clone();
            System.out.println(clonePrototype == clone);
            System.out.println("list是否相等="+ (clonePrototype.getArrayList() == clone.getArrayList()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}