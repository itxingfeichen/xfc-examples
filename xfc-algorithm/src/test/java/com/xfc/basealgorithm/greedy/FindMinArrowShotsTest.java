package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class FindMinArrowShotsTest extends TestCase {

    public void testFindMinArrowShots() {
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
        final FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(arr));
    }
}