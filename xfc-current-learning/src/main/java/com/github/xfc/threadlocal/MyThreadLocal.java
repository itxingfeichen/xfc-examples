package com.github.xfc.threadlocal;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  22:13
 * @description: ThreadLocal用法和测试(ThreadLocal作为一种无锁的并发解决方案 ， 主要用于提高并发安全性)
 */
public class MyThreadLocal {

    /**
     * 初始化threadLocal
     */
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 提供set方法
     *
     * @param obj
     */
    public void setValue(String obj) {
        threadLocal.set(obj);
    }

    /**
     * 提供get方法
     *
     * @return
     */
    public String getValue() {
        String result = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + " " + result);
        return result;
    }


}
