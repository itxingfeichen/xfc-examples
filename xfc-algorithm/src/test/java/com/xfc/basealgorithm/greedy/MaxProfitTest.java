package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class MaxProfitTest extends TestCase {

    public void testMaxProfit() {
        final MaxProfit maxProfit = new MaxProfit();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit.maxProfit(arr));
    }
}