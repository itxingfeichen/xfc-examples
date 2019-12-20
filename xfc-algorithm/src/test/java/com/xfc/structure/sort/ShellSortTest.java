package com.xfc.structure.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 希尔排序测试
 */
public class ShellSortTest {

    @Test
    public void doSort() {

        int[] data = {1, 3, 2, 4};
        ShellSort shellSort = new ShellSort();
        int[] ints = shellSort.doSort(data);

        int[] sortType2 = shellSort.doSortOptimization(data);
        System.out.println(Arrays.toString(sortType2));

//        System.out.println(Arrays.toString(ints));
    }
}