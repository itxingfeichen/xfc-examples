package com.xfc.algorithm.floyd;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 弗洛伊德算法图表示对象
 *
 * @author jannik
 * @date 2020-02-07
 */
@Data
@AllArgsConstructor
public class FloydGraph {

    /**
     * 顶点
     */
    private char[] vertex;

    /**
     * 从各个点出发到其他顶点的距离
     */
    private int[][] dis;

    /**
     * 到达目标顶点的前去顶点
     */
    private int[][] pre;

    /**
     * 打印数据
     */
    public void show() {

        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            for (int j = 0; j < dis.length; j++) {
                System.out.print("【" + vertex[i] + "到" + vertex[j] + "最短路径为" + dis[i][j] + "】");
            }
            System.out.println();
        }

    }

}
