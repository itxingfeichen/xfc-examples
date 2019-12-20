package com.xfc.structure.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author jannik
 * @date 2019-12-20
 */
public class SelectSort implements ArraySort {
    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSort(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data.length; i1++) {
                if (data[i] < data[i1]) {
                    int temp = data[i1];
                    data[i1] = data[i];
                    data[i] = temp;
                }
            }
        }
        return data;
    }
}
