package com.xfc.algorithm.kruskal;

import java.util.Arrays;

/**
 * kruskal最小生成树
 *
 * @author jannik
 * @date 2020-02-06
 */
public class KruskalMinTree {

    private int INF = 10000;

    /**
     * kruskal最小生成树
     */
    public void kruskalMinTree() {

        // 边的总数
        int sides = 0;
        // 顶点
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        // 邻接矩阵
        int[][] matrix = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};
        ;
        // 初始化基础数据
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    sides++;
                }
            }
        }

        // 最小生成树
        kruscal(sides, vertexs, matrix);


    }

    private void kruscal(int sides, char[] vertexs, int[][] matrix) {
        // 保存最小生成树中每个顶点的终点
        int[] ends = new int[sides];
        // 结果保存
        Side[] result = new Side[sides];
        // 获取所有的边
        Side[] sidesSet = getSides(sides, vertexs, matrix);

        int index = 0;
        // 遍历所有的边
        for (int i = 0; i < sides; i++) {
            // 获取第i条边的起点索引
            int p1 = getPosition(sidesSet[i].getStart(), vertexs);
            // 获取第i条边的终点索引
            int p2 = getPosition(sidesSet[i].getEnd(), vertexs);

            // 获取 p1 这个顶点在已有最小生成树中的终点
            int top1 = getTop(ends, p1);
            // 获取 p2 这个顶点在已有最小生成树中的终点
            int top2 = getTop(ends, p2);
            // 如果两个点链接后终点一致，则说明形成了一个闭环
            if (top1 != top2) {
                ends[top1] = top2;
                result[index++] = sidesSet[i];
            }

        }


        System.out.println("最小生成树=>" + Arrays.toString(result));

    }


    private int getTop(int[] ends, int index) {
        while (ends[index] != 0) {
            index = ends[index];
        }
        return index;
    }


    /**
     * 获取所有的边
     *
     * @param sides
     * @param vertexs
     * @param matrix
     * @return
     */
    private Side[] getSides(int sides, char[] vertexs, int[][] matrix) {
        int index = 0;
        Side[] sidesArr = new Side[sides];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    sidesArr[index++] = new Side(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        System.out.println("排序前=>" + Arrays.toString(sidesArr));
        // 排序
        for (int i = 0; i < sidesArr.length - 1; i++) {
            for (int j = 0; j < sidesArr.length - 1 - i; j++) {
                if (sidesArr[j].getWeight() > sidesArr[j + 1].getWeight()) {
                    Side temp = sidesArr[j];
                    sidesArr[j] = sidesArr[j + 1];
                    sidesArr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后=>" + Arrays.toString(sidesArr));
        return sidesArr;
    }

    /**
     * 获取某个顶点的索引
     *
     * @param c
     * @param vertexs
     * @return
     */
    private int getPosition(char c, char[] vertexs) {

        for (int i = 0; i < vertexs.length; i++) {
            if (c == vertexs[i]) {
                return i;
            }
        }
        return -1;
    }


}
