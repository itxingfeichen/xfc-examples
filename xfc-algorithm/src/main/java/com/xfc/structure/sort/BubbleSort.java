package com.xfc.structure.sort;

import java.util.Arrays;

/**
 * 冒泡排序方法
 */
public class BubbleSort implements ArraySort {
    private static BubbleSort ourInstance = new BubbleSort();

    public static BubbleSort getInstance() {
        return ourInstance;
    }


    private BubbleSort() {
    }

    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSort(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
        return data;
    }


    /**
     * 第二种排序方法（用与扩展有多种写法的算法）
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSortOptimization(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        // 通过flag标记是否交换过，如果没有交换过，则证明排序已经完成
        boolean flag = false;
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    flag = true;
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
            if (flag) {
                flag = true;
            } else {
                break;
            }
        }
        return data;
    }
}
