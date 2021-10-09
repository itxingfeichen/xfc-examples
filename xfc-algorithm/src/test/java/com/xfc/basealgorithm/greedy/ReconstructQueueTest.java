package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

import java.util.Arrays;

public class ReconstructQueueTest extends TestCase {

    public void testReconstructQueue() {
        int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        final ReconstructQueue reconstructQueue = new ReconstructQueue();
        final int[][] ints = reconstructQueue.reconstructQueue(arr);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}