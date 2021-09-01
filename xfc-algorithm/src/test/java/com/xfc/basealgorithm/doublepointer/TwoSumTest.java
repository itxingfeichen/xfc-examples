package com.xfc.basealgorithm.doublepointer;

import junit.framework.TestCase;
import org.junit.Assert;

public class TwoSumTest extends TestCase {

    public void testTwoSum() {

        int[] numbers = {-1,0};
        int target = -1;
        final TwoSum twoSum = new TwoSum();
        final int[] result = twoSum.twoSum(numbers, target);
        Assert.assertArrayEquals(result,new int[]{1,2});
    }
}