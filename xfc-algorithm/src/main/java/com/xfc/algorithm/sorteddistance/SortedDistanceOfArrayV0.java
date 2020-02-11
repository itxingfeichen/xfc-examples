package com.xfc.algorithm.sorteddistance;

import java.util.Arrays;

/**
 * 数组元素排序后的最大相邻差
 *
 * @author jannik
 * @date 2020-02-10
 */
public class SortedDistanceOfArrayV0 {

    /**
     * 数组元素排序后的最大相邻差
     *
     * @param data
     * @return
     */
    public int getMaxSortedDistance(int[] data) {

        // 获取数组的最大值和最小值
        int max = data[0];
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (data[i] > max) {
                max = data[i];
            }
        }
        int distance = max - min + 1;
        if (distance == 0) {
            return 0;
        }

        int[] newArray = new int[data.length + min];
        for (int i = 0; i < data.length; i++) {

            newArray[data[i]-min] = 1;
        }

        System.out.println(Arrays.toString(newArray));

        return 0;
    }

}
