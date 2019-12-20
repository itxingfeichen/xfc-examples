package com.xfc.structure.sort;

/**
 * 排序接口
 *
 * @author jannik
 * @date 2019-12-20 07:04
 */
public interface Sort {

    /**
     * 待排序数据
     * @param data
     * @return
     */
    int[] doSort(int[] data);
}
