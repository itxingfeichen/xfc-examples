package com.xfc.structure.sort;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 排序接口
 *
 * @author jannik
 * @date 2019-12-20 07:04
 */
public interface ArraySort {

    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    int[] doSort(int[] originData);

    /**
     * 第二种排序方法（用与扩展有多种写法的算法）
     *
     * @param originData
     * @return
     */
    default int[] doSortType2(int[] originData) {
        return originData;
    }


    /**
     * 原始数据
     * @return
     */
    default int[] prepareOriginalData() {
        int[] data = {1, 3, 2, 4};
        return data;
    }

    /**
     * 打印结果
     * @param result
     */
    default void printResult(int[] result){
        System.out.println(MessageFormat.format("排序结果为:{0}", Arrays.toString(result)));
    }
}
