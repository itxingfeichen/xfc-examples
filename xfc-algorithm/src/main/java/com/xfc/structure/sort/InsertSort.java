package com.xfc.structure.sort;

/**
 * 插入排序
 *
 * @author xf
 * @date 2019/12/19 19:51
 */
public class InsertSort implements ArraySort {

    /**
     * 待排序数据
     *
     * @param data
     * @return
     */
    @Override
    public int[] doSort(int[] data) {
        int tmp;
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                tmp = data[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && tmp < data[j - 1]) {
                        data[j] = data[j - 1];
                    } else {
                        data[j] = tmp;
                        break;
                    }
                }
            }

        }

        return data;
    }

}
