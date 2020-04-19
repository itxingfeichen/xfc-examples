package com.xfc.algorithm.plim;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * 普里姆算法图表示对象
 *
 * @author jannik
 * @date 2020-02-04
 */
@Data
@AllArgsConstructor
public class PrimGraph {

    /**
     * 节点个数
     */
    private int verxs;

    /**
     * 顶点数据
     */
    private char[] data;

    /**
     * 邻接矩阵表示图中各个边的权重
     */
    private int[][] weight;

    /**
     * 打印图
     */
    public void showGraph() {
        for (int[] lineData : this.weight) {
            System.out.println(Arrays.toString(lineData));
        }
    }

}
