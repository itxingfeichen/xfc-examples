package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class CanPlaceFlowersTest extends TestCase {

    public void testCanPlaceFlowers() {
        final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] ar = {1,0,0,0,0,0,1};
        final boolean b = canPlaceFlowers.canPlaceFlowers(ar, 1);
        System.out.println(b);


    }
}