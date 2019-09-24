package com.github.xfc.threadsleep;

import java.util.concurrent.TimeUnit;


public class TestSleep {
    public static void main(String[] args) {

        class Worker extends Thread {

            @Override
            public void run() {

                while (true) {

                    try {

                        System.out.println(Thread.currentThread().getName()+ "   ~~不会阻塞么？");
                        TimeUnit.SECONDS.sleep(1);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            }

        }



        for (int i = 0; i < 10; i++) {

            Worker worker = new Worker();

            worker.start();

        }

    }
}
