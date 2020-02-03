package com.xfc.algorithm.knapsack;

/**
 * 动态规划之背包问题
 * <p>
 * 1) 要求达到的目标为装入的背包的总价值最大，并且重量不超出
 * 2) 要求装入的物品不能重复
 * 3) 背包问题主要是指一个给定容量的背包、若干具有一定价值和重量的物品，如何选择物品放入背包使物品的价
 * 值最大。其中又分 01 背包和完全背包(完全背包指的是:每种物品都有无限件可用)
 * 4) 这里的问题属于01背包，即每个物品最多放一个。而无限背包可以转化为01背包。
 * 5) 算法的主要思想，利用动态规划来解决。每次遍历到的第i个物品，根据w[i]和v[i]来确定是否需要将该物品
 * 放入背包中。即对于给定的 n 个物品，设 v[i]、w[i]分别为第 i 个物品的价值和重量，C 为背包的容量。再令 v[i][j] 表示在前 i 个物品中能够装入容量为 j 的背包中的最大价值。
 * <p>
 * 思路：
 * (1) v[i][0]=v[0][j]=0; //表示 填入表 第一行和第一列是 0
 * (2) 当 w[i]> j 时:v[i][j]=v[i-1][j] // 当准备加入新增的商品的容量大于 当前背包的容量时，就直接使用上一个 单元格的装入策略
 * (3) 当 j>=w[i]时: v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}
 * // 当 准备加入的新增的商品的容量小于等于当前背包的容量,
 * // 装入的方式:
 * v[i-1][j]: 就是上一个单元格的装入的最大值
 * v[i] : 表示当前商品的价值
 * v[i-1][j-w[i]] : 装入 i-1 商品，到剩余空间 j-w[i]的最大值
 * 当 j>=w[i]时: v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]} :
 *
 * @author jannik
 * @date 2020-02-03
 */
public class KnapsackProblem {

    /**
     * 01背包
     */
    public void knapsackProblem() {
        // 物品的重量KG
        int[] weight = {1, 4, 3};
        // 物品的价值
        int[] value = {1500, 3000, 2000};
        // 背包容量KG
        int capacity = 4;
        // 物品的数量
        int numbersOfRes = value.length;
        // 表示前i个物品装入容量为j的背包的最大价值 i表示第几个物品，j表示容量
        int[][] maxValue = new int[numbersOfRes + 1][capacity + 1];

        // 路径和产品记录
        int[][] path = new int[numbersOfRes + 1][capacity + 1];

        for (int i = 0; i < maxValue.length; i++) {
            maxValue[i][0] = 0;
        }

        for (int i = 0; i < maxValue[0].length; i++) {
            maxValue[0][i] = 0;
        }

        // 无需处理第一行和第一列，第一行第一列分别代表0个物品和0个价值，因此坐标均从1开始
        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {

                if (weight[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
//                    maxValue[i][j] = Math.max(maxValue[i - 1][j], value[i - 1] + maxValue[i - 1][j - weight[i - 1]]);
                    if (maxValue[i - 1][j] < value[i - 1] + maxValue[i - 1][j - weight[i - 1]]) {
                        maxValue[i][j] = value[i - 1] + maxValue[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    } else {
                        maxValue[i][j] = maxValue[i - 1][j];
                    }

                }

            }
        }

        print(maxValue);


        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1; //列的最大下标 while(i > 0 && j > 0 ) { //从path的最后开始找

        while (j > 0 && i > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d 个商品放入到背包\n", i);
                j -= weight[i - 1]; //w[i-1]
            }
            i--;
        }
        print(path);
    }


    private void print(int[][] maxValue) {
        for (int i = 0; i < maxValue.length; i++) {
            for (int j = 0; j < maxValue[0].length; j++) {
                System.out.print(maxValue[i][j] + " ");
            }
            System.out.println();
        }
    }


}
