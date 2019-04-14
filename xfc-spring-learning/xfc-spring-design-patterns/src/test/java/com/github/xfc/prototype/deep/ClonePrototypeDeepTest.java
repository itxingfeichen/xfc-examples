package com.github.xfc.prototype.deep;

import org.junit.Test;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  20:42
 * @description:
 */
public class ClonePrototypeDeepTest {

    @Test
    public void testDeepCopy() {
        ClonePrototypeDeep clonePrototypeDeep = new ClonePrototypeDeep();

        try {
            ClonePrototypeDeep clone = (ClonePrototypeDeep) clonePrototypeDeep.clone();

            System.out.println("clone == clonePrototypeDeep = " + (clone == clonePrototypeDeep));

            System.out.println("clone.getArrayList() == clonePrototypeDeep.getArrayList() = " + (clone.getArrayList() == clonePrototypeDeep.getArrayList()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}