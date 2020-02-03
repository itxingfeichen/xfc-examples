package com.xfc.algorithm.hanno;

/**
 * 汉诺塔
 *
 * @author jannik
 * @date 2020-02-02
 */
public class HannoTower {

    /**
     * 汉诺塔
     */
    public void hannoTower() {
        doMove(5, "A", "B", "C");
    }

    /**
     * 汉诺塔递归处理
     *
     * @param num 汉诺塔
     * @param a
     * @param b
     * @param c
     */
    private void doMove(int num, String a, String b, String c) {
        if (num == 1) {
            System.out.println("将第1个盘的" + a + "->" + c);
        } else {
            doMove(num - 1, a, c, b);
            System.out.println("将第" + num + "个盘的" + a + "->" + c);
            doMove(num - 1, b, a, c);
            System.out.println("==============");
        }
    }
}
