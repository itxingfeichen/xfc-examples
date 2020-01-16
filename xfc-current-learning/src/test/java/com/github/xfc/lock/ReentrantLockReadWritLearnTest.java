package com.github.xfc.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-04-06  21:56
 * @description: 读写分离测试
 */
public class ReentrantLockReadWritLearnTest {

    private Map<String, String> map = new HashMap<>();

    /**
     * 声明读写锁
     */
    ReentrantLockReadWritLearn reentrantLockReadWritLearn = new ReentrantLockReadWritLearn();

    /**
     * 读锁测试
     */
    public void readLockTest() {


        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    reentrantLockReadWritLearn.readLock();
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread().getName() + " 获得读锁");
                    String s = map.get("data" + finalI);
                    System.out.println(Thread.currentThread().getName() + "读取到数据" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLockReadWritLearn.unReadLock();
                }
            }).start();
        }


    }


    /**
     * 读锁测试
     */
    public void writeLockTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 尝试获得写锁");
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread.sleep(1000L);
            new Thread(() -> {
                try {
                    reentrantLockReadWritLearn.writeLock();
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread().getName() + " 获得写锁");
                    map.put("data" + finalI, finalI + "");
                    System.out.println("写入数据" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLockReadWritLearn.unWriteLock();
                }
            }).start();

        }


    }

    //    @Test
    public static void main(String[] agts) throws InterruptedException {


        ReentrantLockReadWritLearnTest reentrantLockReadWritLearnTest = new ReentrantLockReadWritLearnTest();
        // 构建线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        executorService.execute(() -> reentrantLockReadWritLearnTest.readLockTest());
//        executorService.execute(() -> reentrantLockReadWritLearnTest.readLockTest());
//
//        Thread.sleep(3000L);
//        executorService.execute(() -> reentrantLockReadWritLearnTest.writeLockTest());
//        executorService.execute(() -> reentrantLockReadWritLearnTest.writeLockTest());
        reentrantLockReadWritLearnTest.writeLockTest();
        reentrantLockReadWritLearnTest.readLockTest();

        Thread.sleep(10000L);

//        executorService.shutdown();

    }
}