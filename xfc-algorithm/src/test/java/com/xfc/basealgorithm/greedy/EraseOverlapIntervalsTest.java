package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class EraseOverlapIntervalsTest extends TestCase {

    public void testEraseOverlapIntervals() {

        final EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        int[][] arr = {{1,2},{2,3},{1,3}};
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(arr));
    }
}