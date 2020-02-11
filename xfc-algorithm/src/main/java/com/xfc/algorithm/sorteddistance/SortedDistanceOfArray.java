package com.xfc.algorithm.sorteddistance;

/**
 * 数组元素排序后的最大相邻差
 * 高效率版本（桶排序思想）
 *
 * @author jannik
 * @date 2020-02-10
 */
public class SortedDistanceOfArray {

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
            if (data[i] > max) {
                max = data[i];
            }
            if (data[i] < min) {
                min = data[i];
            }
        }
        int distance = max - min;
        if (distance == 0) {
            return 0;
        }
        // 初始化桶
        Bucket[] buckets = new Bucket[data.length];
        for (int i = 0; i < data.length; i++) {
            buckets[i] = new Bucket();
        }

        // 遍历原始数组，确定每个桶的最大最小值
        for (int i = 0; i < data.length; i++) {

            // todo
            int index = ((data[i] - min) * (buckets.length - 1) / distance);

            // 确定最小值
            if (buckets[index].min == 0 || buckets[index].min > data[i]) {
                buckets[index].min = data[i];
            }
            // 确定最大值
            if (buckets[index].max == 0 || buckets[index].max < data[i]) {
                buckets[index].max = data[i];
            }

        }

        // 遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;

        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == 0) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        int max;
        int min;
    }
}
