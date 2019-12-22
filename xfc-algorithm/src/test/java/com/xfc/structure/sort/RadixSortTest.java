package com.xfc.structure.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {

    @Test
    public void doSort() {

        RadixSort instance = RadixSort.getInstance();
        int[] data = {7,434,52,2,9,8};

        int[] result = instance.doSort(data);
        instance.printResult(result,null);
    }
}