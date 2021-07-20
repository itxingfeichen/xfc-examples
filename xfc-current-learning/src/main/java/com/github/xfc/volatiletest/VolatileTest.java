package com.github.xfc.volatiletest;

public class VolatileTest {

//    volatile boolean stop = false;
    boolean stop = false;

    public static void main(String[] args) throws Exception {
        VolatileTest v = new VolatileTest();
        Thread ta = new Thread(() -> v.execute(),"A");
        ta.start();
        Thread.sleep(2000);
        Thread tb = new Thread(() -> v.shutdown(),"B");
        tb.start();
        Thread.sleep(2000);
    }

    public void execute() {
        while (!stop) {
            //  会多次打印
			System.out.print("exit ？");
        }
    }

    public void shutdown() {
        System.out.println("do stop");
        stop = true;
    }
}

