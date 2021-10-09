package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class MaxProfitV2Test extends TestCase {

    public void testMaxProfit() {
        final MaxProfitV2 maxProfitV2 = new MaxProfitV2();
        int[] ar = {7,1,5,3,6,4};
        final int i = maxProfitV2.maxProfit(ar);

        System.out.println("i = " + i);
    }
}