package com.github.xfc.lock;

/**
 * @author : chenxingfei
 * @date: 2019-09-24  22:43
 * @description:
 */
public class LockTest {

    public void test1(){

        synchronized (this){
            System.out.println("true = " + true);
        }
    }
    public synchronized void test2(){

            System.out.println("true = " + true);
    }

}
