package com.github.xfc.volatiletest;

import java.util.concurrent.TimeUnit;

public class VolatileDemo1 {
    private volatile Integer a = 0;

    public void add() {
        a++;
    }

    public static void main(String[] args) throws Exception {
        final VolatileDemo1 volatileDemo1 = new VolatileDemo1();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 20; i1++) {
                    volatileDemo1.add();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1L);
        System.out.println(volatileDemo1.a);
    }
}