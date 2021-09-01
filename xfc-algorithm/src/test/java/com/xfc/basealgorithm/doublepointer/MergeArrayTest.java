package com.xfc.basealgorithm.doublepointer;

import junit.framework.TestCase;

import java.util.Arrays;

public class MergeArrayTest extends TestCase {

    public void testMerge() {

        final MergeArray mergeArray = new MergeArray();
        final int[] nums1 = {1, 2, 3, 0, 0, 0};
        final int[] nums2 = {2, 5, 6};
        mergeArray.merge(nums1,3, nums2,3);
        Arrays.toString(nums1);
    }
}