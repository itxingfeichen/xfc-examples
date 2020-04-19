package com.github.xfc.volatiletest;

public class VolatileDemo extends Thread {
    //设置类静态变量,各线程访问这同一共享变量
    private static volatile boolean flag = false;

    //无限循环,等待flag变为true时才跳出循环;
    @Override
    public void run() {

        flag = true;
    }

    public static void main(String[] args) throws Exception {
        new VolatileDemo().start();
        new VolatileDemo().start();
        new VolatileDemo().start();
        //sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了
        Thread.sleep(100);
        System.out.println("当前flag是" + flag);
    }
}