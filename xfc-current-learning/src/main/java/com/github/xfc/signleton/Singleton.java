package com.github.xfc.signleton;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  21:46
 * @description: 懒汉式单例模式
 */
public class Singleton {

    /**
     * 懒汉式对象需要在使用的时候再创建
     */
    private static Singleton signleton = null;

    /**
     * 1:需要私话构造方法，避免使用者功过new关键字创建
     */
    private Singleton() {

    }

    /**
     * 获取单例对象
     * 如果去除第二层判断，比如多线程的情况下，有两个线程同时经过了第一次判断，第一个线程加了类锁，第二个线程等待，等待第一个线程释放锁，不加第二层判断的情况下，第二个线程同样会创建一个对象，这明显违背了单例模式模式的原则
     *
     * @return
     */
    public static Singleton getInstance() {
        if (signleton == null) {
//            try {
//                // 等待三秒，方便测试多线程时会导致多个对象创建
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (Singleton.class) {
                if (signleton == null) {
                    signleton = new Singleton();
                }
            }
        }
        return signleton;
    }


}
