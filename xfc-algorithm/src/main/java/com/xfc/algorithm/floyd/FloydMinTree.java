package com.xfc.algorithm.floyd;

import java.util.Arrays;

/**
 * 弗洛伊德算法最生成树
 *
 * @author jannik
 * @date 2020-02-07
 */
public class FloydMinTree {

    public void floydAlgorithm() {

        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int[][] dis = new int[vertex.length][vertex.length];
        final int N = 65535;
        dis[0] = new int[]{0, 5, 7, N, N, N, 2};
        dis[1] = new int[]{5, 0, N, 9, N, N, 3};
        dis[2] = new int[]{7, N, 0, N, 8, N, N};
        dis[3] = new int[]{N, 9, N, 0, N, 4, N};
        dis[4] = new int[]{N, N, 8, N, 0, 5, 4};
        dis[5] = new int[]{N, N, N, 4, 5, 0, 6};
        dis[6] = new int[]{2, 3, N, N, 4, 6, 0};
        int[][] pre = new int[vertex.length][vertex.length];
        for (int i = 0; i < pre.length; i++) {
            Arrays.fill(pre[i], i);
        }
        FloydGraph floydGraph = new FloydGraph(vertex, dis, pre);
        floyd(floydGraph);
        floydGraph.show();

    }

    private void floyd(FloydGraph floydGraph) {
        int len = 0;
        int[][] dis = floydGraph.getDis();
        int[][] pre = floydGraph.getPre();
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }


    }


    public static void main(String[] args) {
        String s1 = "hello";

        String s2 = "he"+new String("llo");

        System.out.println("s1 == s2 = " +(s1 == s2));
    }

}
