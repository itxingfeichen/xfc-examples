package com.xfc.structure.statck.demo;

/**
 * 迷宫
 *
 * @author jannik
 * @date 2019-12-15
 */
public class MazeFromStack {

    /**
     * 迷宫游戏
     *
     * @return
     */
    public void playMaze() {

        int[][] map = makeMap();
        // 设置小球最初位置
        start2(1, 1, map);
        showMap(map);


    }

    /**
     * 查找路 规则  下->右->左->上
     *
     * @param i
     * @param j
     * @param map
     * @return
     */
    private boolean start(int i, int j, int[][] map) {
        if (map[6][5] == 2) {
            return true;
        } else {
            // 0 代表当前元素没有走过
            if (map[i][j] == 0) {
                map[i][j] = 2;
                // 向下走
                if (start(i + 1, j, map)) {
                    return true;
                }
                // 向右走
                else if (start(i, j + 1, map)) {
                    return true;
                }
                // 向上走
                else if (start(i - 1, j, map)) {
                    return true;
                }
                // 向左走
                else if (start(i, j - 1, map)) {
                    return true;
                } else {
                    map[i][j] = 3;
                }
            } else {
                return false;
            }

        }
        return false;

    }

    /**
     * 查找路 规则  上->右->下->左
     *
     * @param i
     * @param j
     * @param map
     * @return
     */
    private boolean start2(int i, int j, int[][] map) {
        if (map[6][5] == 2) {
            return true;
        } else {
            // 0 代表当前元素没有走过
            if (map[i][j] == 0) {
                map[i][j] = 2;
                // 向上走
                if (start2(i - 1, j, map)) {
                    return true;
                }
                // 向右走
                else if (start2(i, j + 1, map)) {
                    return true;
                }
                // 向下走
                else if (start2(i + 1, j, map)) {

                    return true;
                }
                // 向左走
                else if (start2(i, j - 1, map)) {
                    return true;
                } else {
                    map[i][j] = 3;
                }
            } else {
                return false;
            }

        }
        return false;

    }

    /**
     * 制作地图
     *
     * @return 地图
     */
    private int[][] makeMap() {
        int[][] mazeMap = new int[8][7];
        for (int i = 0; i < 7; i++) {
            mazeMap[0][i] = 1;
            mazeMap[7][i] = 1;
            mazeMap[i][0] = 1;
            mazeMap[i][6] = 1;
        }
        mazeMap[3][1] = 1;
        mazeMap[3][2] = 1;
        return mazeMap;

    }

    /**
     * 展示地图
     *
     * @param mazeMap
     */
    private void showMap(int[][] mazeMap) {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 7; j++) {
                System.out.print(mazeMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
