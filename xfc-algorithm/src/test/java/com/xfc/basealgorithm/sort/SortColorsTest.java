package com.xfc.basealgorithm.sort;

import junit.framework.TestCase;

import java.util.Arrays;

public class SortColorsTest extends TestCase {

    public void testSortColors() {
        final SortColors sortColors = new SortColors();
        int[] numbers = {1,2,1,2,1,0,1,2,1};
        sortColors.sortColors(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}