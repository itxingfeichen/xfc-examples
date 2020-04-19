package com.xfc.structure.sort;

import org.junit.Test;

public class HeapSortTest {

    @Test
    public void doSort() {

        HeapSort heapSort = HeapSort.getInstance();
        int[] da = {4, 6, 8, 5, 9};
        int[] ints = heapSort.doSort(da);
        heapSort.printResult(ints, null);

    }
}