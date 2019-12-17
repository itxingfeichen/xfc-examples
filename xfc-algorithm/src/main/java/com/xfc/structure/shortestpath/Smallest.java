package com.xfc.structure.shortestpath;

/**
 * 获取最小值
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 说明：每次只能向下或者向右移动一步。
 *
 * 例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author xf
 * @date 2019/12/17 12:45
 */
public class Smallest {


    static int[][] data = new int[3][3];


    static {
        data[0][0] = 1;
        data[0][1] = 3;
        data[0][2] = 1;
        data[1][0] = 1;
        data[1][1] = 5;
        data[1][2] = 1;
        data[2][0] = 4;
        data[2][1] = 2;
        data[2][2] = 1;
    }

    public static void main(String[] args) {
        System.out.println("=============我是原始字符串==============");
        print(data);
        System.out.println("=============我是分隔符==============");
        System.out.println("minPathSum(data) = " + minPathSum(data));
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int minPathSum(int[][] arr) {
        if(arr.length == 0) return 0;
        int m = arr.length;
        int n = arr[0].length;
        int[][] array = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                //起始位置为传入数组arr起始位置值
                if(i == 0 && j == 0) {
                    array[i][j] = arr[i][j];
                }else if (i == 0) {
                    //第0行，每一列的值为前一列值(array数组)加上当前列的值(arr数组)
                    array[i][j] = array[i][j - 1] + arr[i][j];
                }else if (j == 0) {
                    //第0列，每一行的值为前一行值(array数组)加上当前行的值(arr数组)
                    array[i][j] = array[i - 1][j] + arr[i][j];
                }else {
                    //该位置的值为 该位置(array[i][j])的左边和上边值的最小值 加上当前位置的值(arr数组)
//                    array[i][j] = Math.min(array[i-1][j], array[i][j-1]) + arr[i][j];

                    array[i][j] = arr[i][j]+Math.min(array[i-1][j],array[i][j-1]);
                }
            }
        }
        print(array);
        return array[m-1][n-1];
    }


}
