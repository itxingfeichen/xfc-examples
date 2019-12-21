package com.xfc.structure.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void doSort() {

        MergeSort instance = MergeSort.getInstance();
        int[] originData = instance.prepareOriginalData(5);
        instance.printResult(originData,"原始数据");
        int[] sort = instance.doSortWithOptimization(originData);
        instance.printResult(sort,null);
//        instance.doSortWithPerformance(true);

    }
}