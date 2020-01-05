package com.xfc.structure.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author jannik
 * @date 2020-01-05
 */
public class HeapSort implements ArraySort {


    private static final HeapSort radixSort = new HeapSort();

    public static HeapSort getInstance() {
        return radixSort;
    }

    private HeapSort() {
    }

    /**
     * 待排序数据
     *
     * @param originData
     * @return
     */
    @Override
    public int[] doSort(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        helpSort(data);
        return data;
    }

    /**
     * 排序辅助
     *
     * @param arr
     */
    private void helpSort(int[] arr) {
        System.out.print("原来数组");
        printResult(arr, null);
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            process(arr, i, arr.length);
            System.out.print("原来数组" + i);
            printResult(arr, null);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            process(arr, 0, i);
            printResult(arr, null);

        }
    }

    /**
     * 排序逻辑处理
     *
     * @param arr    数组
     * @param i      当前非叶子节点索引
     * @param length 数组长度（是变化的）
     */
    private void process(int arr[], int i, int length) {

        // 使用临时变量记录当前非叶子节点数据
        int tem = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 左子节点的值小于右子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 需要则说明需要直接用非叶子节点与右子节点比较
                k++;
            }
            // 比较非叶子节点与子节点
            if (arr[k] > tem) {
                // 如果父节点大于当前子节点，则将子节点的值赋值给父节点
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }

        }
        // 循环结束，则代表已经将i为父节点的最大值放到了顶部，需要把i放回子节点
        // 最后将temp元素调整到最后的位置
        arr[i] = tem;

    }
}
