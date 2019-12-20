package com.xfc.structure.sort;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 排序接口
 *
 * @author jannik
 * @date 2019-12-20 07:04
 */
public interface ArraySort {

    Map<String, int[]> map = new HashMap();

    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    int[] doSort(int[] originData);


    /**
     * 性能测试
     * @param doSort
     */
    default void doSortWithPerformance(boolean doSort){
        int[] originData = prepareOriginalData(8000);
        long start = Instant.now().toEpochMilli();
        if(doSort){
            doSort(originData);
        }else{
            doSortWithOptimization(originData);
        }
        long end = Instant.now().toEpochMilli();
        System.out.printf("%s%dms%n", doSort ? "未优化耗时" : "优化耗时", end - start);

    }

    /**
     * 第二种排序方法（用与扩展有多种写法的算法）
     *
     * @param originData
     * @return
     */
    default int[] doSortWithOptimization(int[] originData) {
        return originData;
    }


    /**
     * 原始数据
     *
     * @return
     */
    default int[] prepareOriginalData(int max) {
        if (max == 0) {
            int[] data = {1, 3, 2, 4,10,8,6,5,7};
            printResult(data, "原始数组为");
            return data;
        } else {
            if (map.get("data") != null) {
                return map.get("data");
            }
            int[] data = new int[max];
            Random random = new Random();
            for (int i = 0; i < data.length; i++) {
                data[i] = random.nextInt(max);
            }
            map.put("data", data);
            return data;
        }

    }

    /**
     * 打印结果
     *
     * @param result
     */
    default void printResult(int[] result, String message) {
        if (message == null) {
            message = "排序结果为";
        }
        System.out.println(MessageFormat.format("{0}:{1}", message, Arrays.toString(result)));
    }
}
