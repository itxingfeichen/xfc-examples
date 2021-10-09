package com.xfc.basealgorithm.sort;

import junit.framework.TestCase;

public class FrequencySortTest extends TestCase {

    public void testFrequencySort() {
        final FrequencySort frequencySort = new FrequencySort();
        final String eert = frequencySort.frequencySort("tree");
        System.out.println(eert);
    }
}