package com.xfc.structure.search;


/**
 * 二分查找
 *
 * @author jannik
 * @date 2019-12-25
 */
public class BinarySearch implements ArraySearch {
    private static BinarySearch ourInstance = new BinarySearch();

    public static BinarySearch getInstance() {
        return ourInstance;
    }

    private BinarySearch() {
    }

    /**
     * 查找接口
     *
     * @param data 数据
     * @param key  查找的关键字
     * @return 角标
     */
    @Override
    public int search(int[] data, int key) {
        return search(data, key, 0, data.length - 1);
    }

    /**
     * 二分查找
     *
     * @param data  数据
     * @param key   查找的关键字
     * @param left  最小角标
     * @param right 最大角标
     * @return 关键字key的角标
     */
    private int search(int[] data, int key, int left, int right) {

        // 如果left大于或等与则跳出循环
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (key > data[middle]) {
            return search(data, key, middle + 1, right);
        } else if (key < data[middle]) {
            return search(data, key, left, middle - 1);
        } else {
            return middle;
        }
    }
}
