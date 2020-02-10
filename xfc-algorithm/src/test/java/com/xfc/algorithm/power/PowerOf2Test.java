package com.xfc.algorithm.power;

import org.junit.Test;

public class PowerOf2Test {

    @Test
    public void powerOf2V1() {

        PowerOf2 powerOf2 = new PowerOf2();
        boolean powerOf2V1 = powerOf2.powerOf2V1(31);
        System.out.println("powerOf2V1 = " + powerOf2V1);

        boolean powerOfV2 = powerOf2.powerOfV2(32);
        System.out.println("powerOf2 = " + powerOfV2);

        boolean powerOfV3 = powerOf2.powerOfV3(31);
        System.out.println("powerOfV3 = " + powerOfV3);
    }
}