package com.xfc.structure.search;

/**
 * 查找算法接口
 *
 * @author jannik
 * @date 2019-12-25 21:24
 */
public interface ArraySearch {

    /**
     * 查找接口
     *
     * @param data 数据
     * @param key  查找的关键字
     * @return 角标
     */
    int search(int[] data, int key);

    /**
     * 数据构造
     *
     * @return int[]
     */
    default int[] prepareData() {
        return new int[]{1, 3, 5, 6, 7, 9, 11, 123, 321, 343};
    }


}
