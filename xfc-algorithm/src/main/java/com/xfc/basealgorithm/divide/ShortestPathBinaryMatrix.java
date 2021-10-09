package com.xfc.basealgorithm.divide;

import java.util.LinkedList;

/**
 * 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/14 16:53
 * @since 1.0.0
 */
public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int res = 0, n = grid.length;
        // 存放当前元素的下标
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        // 枚举8个方向
        int[][] dir = {{-1,0}, {-1,1}, {0,1},{1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            res++;
            int l = queue.size();
            for(int i = 0; i < l; i++) {
                int[] t = queue.pollFirst();
                if (t[0] == n - 1 && t[1] == n - 1) {
                    return res;
                }
                for (int[] d : dir) {
                    int x = t[0] + d[0], y = t[1] + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && !vis[x][y]) {
                        vis[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(5 & (1 << 29) - 1);
    }
}
