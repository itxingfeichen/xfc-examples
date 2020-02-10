package com.xfc.algorithm.divisor;

import org.junit.Test;

public class GreatestCommonDivisorTest {

    @Test
    public void greatestCommonDivisor() {

        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
        long start = System.currentTimeMillis();
        int divisor = greatestCommonDivisor.greatestCommonDivisor(104, 260);
        long end = System.currentTimeMillis();
        System.out.println("divisor = " + divisor+"耗时："+(end-start));
        // 更相减损术
//        int divisor1 = greatestCommonDivisor.greatestCommonDivisor1(1000000, 1000001);
        int divisor1 = greatestCommonDivisor.greatestCommonDivisorRescur(104, 260);
        long end1 = System.currentTimeMillis();
        System.out.println("divisor1 = " + divisor1+"耗时："+(end1-end));

        int divisorV1 = greatestCommonDivisor.greatestCommonDivisorV1(104, 260);
        System.out.println("divisorV1 = " + divisorV1);
    }

}