package com.xfc.structure.search;

/**
 * 线性查找
 *
 * @author jannik
 * @date 2019-12-25
 */
public class SeqSearch implements ArraySearch {

    private static SeqSearch ourInstance = new SeqSearch();

    public static SeqSearch getInstance() {
        return ourInstance;
    }

    private SeqSearch() {
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
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
