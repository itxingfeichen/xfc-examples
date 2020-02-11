package com.xfc.algorithm.sorteddistance;

import org.junit.Test;

public class SortedDistanceOfArrayTest {

    @Test
    public void getMaxSortedDistance() {

        int[] data = {2,6,3,4,5,10,9};
        SortedDistanceOfArray distanceOfArray = new SortedDistanceOfArray();
        int maxDistance = distanceOfArray.getMaxSortedDistance(data);
        System.out.println("maxDistance = " + maxDistance);
    }
}