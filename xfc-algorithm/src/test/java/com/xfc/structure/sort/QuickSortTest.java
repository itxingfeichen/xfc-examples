package com.xfc.structure.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void doSort() {

        QuickSort instance = QuickSort.getInstance();
//        int[] da = {3,4,2,1,5};
//        int[] result = instance.doSort(da);
//        instance.printResult(result,null);
        instance.doSortWithPerformance(true);

    }
}