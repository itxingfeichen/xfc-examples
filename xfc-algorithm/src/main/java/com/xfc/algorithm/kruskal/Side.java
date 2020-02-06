package com.xfc.algorithm.kruskal;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 图的边对象
 *
 * @author jannik
 * @date 2020-02-06
 */
@Data
@AllArgsConstructor
public class Side {

    /**
     * 边的起点
     */
    private char start;

    /**
     * 边的终点
     */
    private char end;

    /**
     * 边的权重
     */
    private int weight;

    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }
}
