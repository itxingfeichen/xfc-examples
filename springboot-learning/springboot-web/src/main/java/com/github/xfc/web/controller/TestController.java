package com.github.xfc.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenxingfei
 * @date: 2019-07-18  07:53
 * @description: 测试
 */
@RestController
public class TestController {

    public TestController() {

        System.out.println("test");
    }

    /**
     * servlet异步（错误示范）
     *
     * @param request
     * @return
     */
    @GetMapping("asyncTest")
    public String asyncTest(HttpServletRequest request) {

        AsyncContext asyncContext = request.getAsyncContext();

        asyncContext.start(() -> {
            try {
                asyncContext.getResponse().getWriter().write("hello async");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "???";
    }


//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        // CompletableFuture.runAsync(()-> System.out.println(getCurrentName()+" 测试1"),pool).thenRunAsync(()-> System.out.println(getCurrentName()+" test2"),pool).get();
//         asyncCallback();
//    }


    public static String getThreadName() {

        return Thread.currentThread().getName() + "线程";
    }

    public static void asyncCallback() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);


        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getThreadName() + "supplyAsync");
            return "123";
        }, pool);

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getThreadName() + "supplyAsync1");
            return "456";
        }, pool);

        String s = task.get();
        String s1 = task1.get();


        System.out.println("s+s1 = " + s + s1);

        pool.shutdown();


    }


}
