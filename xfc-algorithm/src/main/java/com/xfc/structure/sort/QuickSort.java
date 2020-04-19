package com.xfc.structure.sort;

import java.util.Arrays;

/**
 * 快速排序</br>
 * 基本思想：是对冒泡排序的改进
 *
 * @author jannik
 * @date 2019-12-21
 */
public class QuickSort implements ArraySort {

    private static final QuickSort quickSort = new QuickSort();

    public static QuickSort getInstance() {
        return quickSort;
    }

    private QuickSort() {

    }

    @Override
    public int[] doSort(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        int left = 0;
        int right = data.length - 1;

        return quickSort(data, left, right);
    }

    private int[] quickSort(int[] data, int left, int right) {

        if (left < right) {
            int partition = partition(data, left, right);
            quickSort(data, left, partition - 1);
            quickSort(data, partition + 1, right);
        }
        return data;
    }

    private int partition(int[] data, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (data[i] < data[pivot]) {
                // 交换
                if (i != index) {
                    swap(data, i, index);
                }
                index++;
            }
        }
        swap(data, pivot, index - 1);
        return index - 1;
    }
//    default void swap(int[] data, int i, int j) {
//        int temp = data[i];
//        data[i] = data[j];
//        data[j] = temp;
//    }
}
