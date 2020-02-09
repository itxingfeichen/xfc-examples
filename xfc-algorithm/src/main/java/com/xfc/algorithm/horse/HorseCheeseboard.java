package com.xfc.algorithm.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 马踏棋盘
 *
 * @author jannik
 * @date 2020-02-08
 */
public class HorseCheeseboard {

    private boolean finished = false;


    /**
     * 马踏棋盘算法
     */
    public void horseCheeseBoard() {

        // 定制棋盘大小
        int row = 6;
        int column = 6;
        // 棋盘二维数组
        int[][] cheeseBoard = new int[row][column];
        // 标记是否访问过
        boolean[] visited = new boolean[row * column];
        horseCheeseboard(cheeseBoard, visited, new Point(0, 0), 1);
        for (int[] rows : cheeseBoard) {
            System.out.println(Arrays.toString(rows));
        }

        System.out.println("finished = " + finished);

    }


    private void horseCheeseboard(int[][] cheeseBoard, boolean[] visited, Point startPosition, int step) {
        cheeseBoard[startPosition.y][startPosition.x] = step;

        // 标记起始点已经访问过
        visited[cheeseBoard.length * startPosition.y + startPosition.x] = true;

        // 获取起始点可以访问的点
        List<Point> pointList = getNextPoint(startPosition, 6, 6);

        while (!pointList.isEmpty()) {
            Point point = pointList.remove(0);
            if (!visited[cheeseBoard.length * point.y + point.x]) {
                horseCheeseboard(cheeseBoard, visited, point, step + 1);
            }
        }
        if (step < cheeseBoard.length * cheeseBoard[0].length && !finished) {
            cheeseBoard[startPosition.y][startPosition.y] = 0;
            visited[startPosition.y * cheeseBoard.length + startPosition.x] = false;
        } else {
            finished = true;
        }

    }


    /**
     * 获取当前点可以走的其他点集合
     *
     * @param currentPoint
     * @return
     */
    private List<Point> getNextPoint(Point currentPoint, int maxRow, int maxColumn) {

        List<Point> points = new ArrayList<>();

        int x = 0;
        int y = 0;
        if ((x = currentPoint.x - 2) >= 0 && (y = currentPoint.y - 1) >= 0) {
            points.add(new Point(x, y));
        }
        if ((x = currentPoint.x - 2) >= 0 && (y = currentPoint.y + 1) <= maxRow - 1) {
            points.add(new Point(x, y));
        }

        if ((x = currentPoint.x - 1) >= 0 && (y = currentPoint.y - 2) >= 0) {
            points.add(new Point(x, y));
        }

        if ((x = currentPoint.x - 1) >= 0 && (y = currentPoint.y + 2) <= maxRow - 1) {
            points.add(new Point(x, y));
        }


        if ((x = currentPoint.x + 1) <= maxColumn - 1 && (y = currentPoint.y - 2) >= 0) {
            points.add(new Point(x, y));
        }

        if ((x = currentPoint.x + 1) <= maxColumn - 1 && (y = currentPoint.y + 2) <= maxRow - 1) {
            points.add(new Point(x, y));
        }

        if ((x = currentPoint.x + 2) <= maxColumn - 1 && (y = currentPoint.y - 1) >= 0) {
            points.add(new Point(x, y));
        }

        if ((x = currentPoint.x + 2) <= maxColumn - 1 && (y = currentPoint.y + 1) <= maxRow - 1) {
            points.add(new Point(x, y));
        }
        return points;
    }

}
