package com.xfc.algorithm.interupt;

import java.util.concurrent.*;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/3/7  10:19
 * @description: 线程超时中断原理
 **/
public class TaskInterrupt {

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {

        final ExecutorService exec = Executors.newFixedThreadPool(1);

        Callable<String> call = new Callable<String>() {
            public String call() throws Exception {
                //开始执行耗时操作
                Thread.sleep(1000 * 5);
                System.out.println("阻塞5秒结束啦");
                return "线程执行完成.";
            }
        };

        try {
            Future<String> future = exec.submit(call);
            String obj = future.get(100, TimeUnit.MILLISECONDS); //任务处理超时时间设为 1 秒
            System.out.println("任务成功返回:" + obj);
        } catch (TimeoutException ex) {
            System.out.println("处理超时啦....");
            ex.printStackTrace();
        } catch (Exception e) {
            System.out.println("处理失败.");
            e.printStackTrace();
        }



        Thread.sleep(5000L);
        // 关闭线程池
        exec.shutdown();
    }
}
