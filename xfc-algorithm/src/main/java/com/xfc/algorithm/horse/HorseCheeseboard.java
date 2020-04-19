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

    private int X = 6;
    private int Y = 6;
    // 标记是否访问过
    boolean[] visited = new boolean[X * Y];

    /**
     * 马踏棋盘算法
     */
    public void horseCheeseBoard() {


        // 定制棋盘大小
        int row = 6;
        int column = 6;
        // 棋盘二维数组
        int[][] cheeseBoard = new int[row][column];
//        horseCheeseboard(cheeseBoard, visited, new Point(0, 0), 1);
        traversalChessboard(cheeseBoard, 0, 0, 1);
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
//        ArrayList<Point> pointList = next(startPosition);

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

    public ArrayList<Point> next(Point curPoint) { //创建一个 ArrayList
        ArrayList<Point> ps = new ArrayList<Point>(); //创建一个 Point
        Point p1 = new Point();
        //表示马儿可以走 5 这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 6 这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 7 这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 0 这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 1 这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 2 这个位置

        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 3 这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走 4 这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        //row = 4 X = 8 column = 4 = 4 * 8 + 4 = 36
        visited[row * X + column] = true; //标记该位置已经访问 //获取当前位置可以走的下一个位置的集合
//        ArrayList<Point> ps = next(new Point(column, row));
        List<Point> ps = getNextPoint(new Point(column, row), 6, 6);
        //对 ps 进行排序,排序的规则就是对 ps 的所有的 Point 对象的下一步的位置的数目，进行非递减排序 sort(ps);
        //遍历 ps
        while (!ps.isEmpty()) {

            Point p = ps.remove(0);//取出下一个可以走的位置 //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {//说明还没有访问过
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        //判断马儿是否完成了任务，使用 step 和应该走的步数比较 ， //如果没有达到数量，则表示没有完成任务，将整个棋盘置 0 //说明: step < X * Y 成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

}
