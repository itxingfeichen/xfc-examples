package com.xfc.algorithm.sorteddistance;

import org.junit.Test;

public class SortedDistanceOfArrayV0Test {

    @Test
    public void getMaxSortedDistance() {
        int[] data = {2, 6, 3, 4, 5, 10, 9};
        SortedDistanceOfArrayV0 distanceOfArrayV0 = new SortedDistanceOfArrayV0();
        int maxSortedDistance = distanceOfArrayV0.getMaxSortedDistance(data);
        System.out.println("maxSortedDistance = " + maxSortedDistance);
    }
}