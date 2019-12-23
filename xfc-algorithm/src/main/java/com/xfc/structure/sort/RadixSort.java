package com.xfc.structure.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author jannik
 * @date 2019-12-21
 */
public class RadixSort implements ArraySort {

    private static final RadixSort radixSort = new RadixSort();

    public static RadixSort getInstance() {
        return radixSort;
    }

    private RadixSort(){}
    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSort(int[] originData) {



        int[] data = Arrays.copyOf(originData, originData.length);

        /**
         * 定义存储数据的桶
         */
        int[][] bucket = new int[10][originData.length];
        // 对最长的数字进行遍历，以保证可以取出数组中的所有元素的位数
        int[] elementCounts = new int[10];
        for (int i = 0, mod = 1; i < getMaxLength(data); i++, mod *= 10) {

            for (int i1 = 0; i1 < data.length; i1++) {
                // 计算当前元素的位置
                int i2 = data[i1] / mod % 10;
                bucket[i2][elementCounts[i2]] = data[i1];
                elementCounts[i2]++;
            }
            int index = 0;
            // 一轮循环结束，需要用桶中的元素覆盖数组中的元素
            for (int j = 0; j < bucket.length; j++) {
                // 大于0。代表桶中有数据。需要依此 取出
                if (elementCounts[j] > 0) {
                    for (int k = 0; k < elementCounts[j]; k++) {
                        data[index++] = bucket[j][k];
                    }
                }
                // 清理当前桶的数据
                elementCounts[j] = 0;
            }
        }

        return data;
    }

    /**
     * 获取最大值的长度
     *
     * @param data
     * @return
     */
    private int getMaxLength(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (max < data[i]) {
                max = data[i];
            }
        }
        return String.valueOf(max).length();
    }
}
