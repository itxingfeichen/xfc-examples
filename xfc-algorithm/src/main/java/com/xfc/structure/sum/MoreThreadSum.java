package com.xfc.structure.sum;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * more threads get a result of sum
 *
 * @author xf
 * @date 2020/1/3 14:38
 */
public class MoreThreadSum {


    public static void main(String[] args) throws InterruptedException {

        int sum = 0;
        int[] data = new int[10];
        final Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10);
        }
        for (int i = 0; i < data.length; i++) {
            sum+=data[i];
        }
        System.out.println("sum = " + sum);
        sum = 0;



    }

    private static int sum(int n){
        return (n*(n+1))/2;
    }

}
