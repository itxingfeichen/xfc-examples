package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class MaxSubArrayTest extends TestCase {

    public void testMaxSubArray() {

        final MaxSubArray maxSubArray = new MaxSubArray();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(a));

    }
}