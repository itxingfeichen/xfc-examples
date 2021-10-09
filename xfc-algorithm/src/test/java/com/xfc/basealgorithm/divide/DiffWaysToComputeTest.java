package com.xfc.basealgorithm.divide;

import junit.framework.TestCase;

import java.util.List;

public class DiffWaysToComputeTest extends TestCase {

    public void testDiffWaysToCompute() {
        final DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        final List<Integer> integers = diffWaysToCompute.diffWaysToCompute("2-1-1");

        System.out.println("integers = " + integers);
    }
}