package com.github.xfc.thread;

/**
 * 线程优先级测试
 *
 * @author xf.chen
 * @date 2021/7/22 10:03 下午
 * @since 1.0.0
 */
public class ThreadPriorityTest {

    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            final Thread thread = new Thread(() -> {

                while (notStart) {
                    Thread.yield();
                }
                System.out.println(finalI);
            }, i + "");
            thread.setPriority(i);
            thread.start();
            notStart = false;


        }
    }
}
