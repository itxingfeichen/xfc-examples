package com.xfc.structure.sort;

import java.util.Arrays;

/**
 * 升级版的插入排序（希尔排序）
 *
 * @author jannik
 * @date 2019-12-20
 */
public class ShellSort implements ArraySort {
    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSort(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        // 步长
        int skip = data.length / 2;
        while (skip > 0) {
            for (int i = skip; i < data.length; i++) {
                for (int j = i - skip; j >= 0; j -= skip) {
                    if (data[j] > data[j + skip]) {
                        // 交换
                        int temp = data[j];
                        data[j] = data[j + skip];
                        data[j + skip] = temp;
                    }
                }
            }
            // 循环结束重新计算步长
            skip = skip / 2;
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
        // copy数组
        int[] data = Arrays.copyOf(originData, originData.length);
        int skip = data.length / 2;
        while (skip > 0) {
            for (int i = skip; i < data.length; i++) {
                int temp = data[i];
                int j = i - skip;
                while (j >= 0 && data[j] > temp) {
                    data[j+skip] = data[j];
                    j -= skip;
                }
                data[j+skip] = temp;
            }
            // 循环结束重新计算步长
            skip = skip / 2;
        }
        return data;
    }
}
