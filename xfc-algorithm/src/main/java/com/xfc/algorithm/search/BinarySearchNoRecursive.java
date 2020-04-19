package com.xfc.algorithm.search;

/**
 * 非递归方式实现二分查找
 *
 * @author jannik
 * @date 2020-02-02
 */
public class BinarySearchNoRecursive {


    /**
     * 二分查找
     *
     * @param data   数组
     * @param target 目标值
     * @return
     */
    public int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (data[middle] == target) {
                return middle;
            } else if (data[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
