package com.xfc.structure.sort;

import org.junit.Test;

/**
 * 选择排序测试
 */
public class SelectSortTest {

    @Test
    public void doSort() {
        SelectSort selectSort = new SelectSort();
        int[] ints = selectSort.doSort(selectSort.prepareOriginalData(0));
        selectSort.printResult(ints, null);
    }
}