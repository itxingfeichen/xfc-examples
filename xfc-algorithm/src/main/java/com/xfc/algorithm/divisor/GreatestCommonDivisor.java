package com.xfc.algorithm.divisor;

/**
 * 最大公约数
 *
 * @author jannik
 * @date 2020-02-10
 */
public class GreatestCommonDivisor {

    /**
     * 获取两个数据最大公约数
     *
     * @param small
     * @param big
     * @return
     */
    public int greatestCommonDivisor(int small, int big) {
        if (small > big) {
            throw new IllegalArgumentException("参数错误:" + small + "不能大于" + big);
        }

        // 如果big和small可以整除，则证明small为最大公约数
        if (big % small == 0) {
            return small;
        }
        // 倒叙找，找到的第一个则为最大公约数
        for (int i = small / 2; i > 0; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        throw new IllegalStateException("没有找到最大公约数");

    }

    /**
     * 更相减损术
     */
    public int greatestCommonDivisor1(int small, int big) {
        if (small > big) {
            throw new IllegalArgumentException("参数错误:" + small + "不能大于" + big);
        }

        // 如果big和small可以整除，则证明small为最大公约数
        if (big % small == 0) {
            return small;
        }
        // 判断是否均为偶素
        int count2 = 1;
        while (small % 2 == 0 && big % 2 == 0) {
            small = small / 2;
            big = big / 2;
            count2 *= 2;
        }
        // 更相减损术
        while ((big - small) != 0) {
            int tem = big - small;
            if (tem > small) {
                big = tem;
            } else {
                small = tem;
                big = small;
            }
        }
        return small * count2;

    }

    /**
     * 更相减损术递归版本
     *
     * @param small
     * @param big
     * @return
     */
    public int greatestCommonDivisorRescur(int a, int b) {
        if (a == b) {
            return a;
        }
        return greatestCommonDivisorRescur(Math.abs(a - b), Math.min(a, b));

    }


    /**
     * 辗转相除法
     *
     * @param small
     * @param big
     * @return
     */
    public int greatestCommonDivisorV1(int small, int big) {
        System.out.println(small+" "+big);
        if (small > big) {
            throw new IllegalArgumentException("参数错误:" + small + "不能大于" + big);
        }
        // 如果big和small可以整除，则证明small为最大公约数
        if (big % small == 0) {
            return small;
        }
        return greatestCommonDivisorV1(big % small, small);
    }


}
