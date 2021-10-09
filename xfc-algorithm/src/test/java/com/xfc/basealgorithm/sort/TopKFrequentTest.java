package com.xfc.basealgorithm.sort;

import junit.framework.TestCase;

import java.util.Arrays;

public class TopKFrequentTest extends TestCase {

    public void testTopKFrequent() {
        final TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {4,1,-1,2,-1,2,3};
        final int[] ints = topKFrequent.topKFrequent(nums, 2);

        System.out.println(Arrays.toString(ints));
    }
}