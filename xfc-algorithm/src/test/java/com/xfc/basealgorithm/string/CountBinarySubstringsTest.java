package com.xfc.basealgorithm.string;

import junit.framework.TestCase;

public class CountBinarySubstringsTest extends TestCase {

    public void testCountBinarySubstrings() {
        final CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();

        final int i = countBinarySubstrings.countBinarySubstrings("01");
        System.out.println("i = " + i);

    }
}