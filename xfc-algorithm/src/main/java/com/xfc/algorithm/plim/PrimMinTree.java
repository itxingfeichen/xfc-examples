package com.xfc.algorithm.plim;

/**
 * 普里姆最小生成树表示对象
 *
 * @author jannik
 * @date 2020-02-04
 */
public class PrimMinTree {

    /**
     * 通过普里姆算法查找最小生成树
     */
    public void minTree() {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};
        PrimGraph graph = new PrimGraph(data.length, data, weight);
        graph.showGraph();
        primAlgorithm(graph, 5);


    }

    /**
     * 普里姆算法
     *
     * @param graph
     * @param top
     */
    private void primAlgorithm(PrimGraph graph, int top) {

        // 使用一个数组记录已经访问过的顶点,所有顶点会默认初始化未访问过
        int[] visited = new int[graph.getVerxs()];
        // 将传入的顶点置为已访问过
        visited[top] = 1;
        // 设置两个顶点下标
        int top1 = -1, top2 = -1, minWeight = 1000;
        // 遍历顶点开始
        for (int i = 1; i < graph.getVerxs(); i++) {

            //  开始遍历并查找从当前顶点出发的最短路径
            // 从1开始，因为起点已经被默认设置为已访问
            for (int j = 0; j < graph.getVerxs(); j++) {

                for (int k = 0; k < graph.getVerxs(); k++) {
                    if (visited[j] == 1 && visited[k] != 1 && graph.getWeight()[j][k] < minWeight) {
                        minWeight = graph.getWeight()[j][k];
                        top1 = j;

                        top2 = k;
                    }
                }
            }

            System.out.println("找到从" + graph.getData()[top1] + "到" + graph.getData()[top2] + "的最短路径为" + minWeight);

            visited[top2] = 1;
            minWeight = 1000;
        }
    }
}
