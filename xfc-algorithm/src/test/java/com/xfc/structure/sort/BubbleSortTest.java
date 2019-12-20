package com.xfc.structure.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void doSort() {
        BubbleSort instance = BubbleSort.getInstance();
        // 未优化版本
        int[] originData = instance.prepareOriginalData(0);
        int[] result = instance.doSort(originData);
        int[] optimization = instance.doSortOptimization(originData);
        instance.printResult(result,null);
        instance.printResult(optimization,"优化版本排序结果为");
    }

    @Test
    public void doSortWithPerformance() {
        BubbleSort instance = BubbleSort.getInstance();
        instance.doSortWithPerformance(true);
        instance.doSortWithPerformance(false);

    }
}