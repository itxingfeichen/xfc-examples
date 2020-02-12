package com.xfc.leetcode;

import org.junit.Assert;

public class Solution1Test {

    @org.junit.Test
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution1 solution1 = new Solution1();
        Assert.assertArrayEquals(new int[]{0,1},solution1.twoSum(nums,target));
    }
}