package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

import java.util.Arrays;

public class CheckPossibilityTest extends TestCase {

    public void testCheckPossibility() {

        final CheckPossibility checkPossibility = new CheckPossibility();
        int[] data = {5,7,1,8};
        final boolean b = checkPossibility.checkPossibility(data);
        System.out.println(Arrays.toString(data));
        System.out.println("b = " + b);
    }
}