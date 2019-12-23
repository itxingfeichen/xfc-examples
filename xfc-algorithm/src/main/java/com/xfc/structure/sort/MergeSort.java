package com.xfc.structure.sort;

import java.util.Arrays;

public class MergeSort implements ArraySort {
    private static MergeSort ourInstance = new MergeSort();

    public static MergeSort getInstance() {
        return ourInstance;
    }

    private MergeSort() {
    }

    /**
     * 第二种排序方法（用与扩展有多种写法的算法）
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSortWithOptimization(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        return sort(data, 0, originData.length-1);

    }

    private int[] sort(int[] data, int left, int right) {

        if (left == right) {
            return data;
        }
        int middle = (int) Math.floor((left + right) / 2);
        sort(data, left, middle);
        sort(data, middle + 1, right);
        return merge2(data, left, right, middle);

    }

    /**
     * 根据角标合并
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    private int[] merge2(int[] data, int left, int right, int middle) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = middle + 1;
        while (middle >= l && r <= right) {
            temp[i++] = data[l] > data[r] ? data[r++] : data[l++];
        }

        while (l <= middle) {
            temp[i++] = data[l++];

        }
        while (r <= right) {
            temp[i++] = data[r++];
        }

        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            data[left + i] = temp[i];
        }
        return data;
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
        if (data.length < 2) {
            return data;
        }
        int middle = (int) Math.floor(data.length / 2);
        int[] left = Arrays.copyOfRange(data, 0, middle);
        int[] right = Arrays.copyOfRange(data, middle, data.length);
        int[] merge = merge(doSort(left), doSort(right));
        return merge;
    }


    /**
     * 合并操作
     *
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
