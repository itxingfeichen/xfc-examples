package com.github.xfc;

import java.util.Random;

/**
 * @author : chenxingfei
 * @date: 2019-07-06  12:18
 * @description:
 */
public class HamTest {

    public static void main(String[] args) {
        Random random = new Random();

        boolean b = random.nextBoolean();

        Number result = (b || !b) ? new Integer(3) : new Float(1);


        // 这里的执行结果是？ 3.0
        System.out.println(result);
    }
}
