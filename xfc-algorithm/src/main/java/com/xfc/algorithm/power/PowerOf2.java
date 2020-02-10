package com.xfc.algorithm.power;

/**
 * 判断一个整数是否位2的整数次幂
 *
 * @author jannik
 * @date 2020-02-10
 */
public class PowerOf2 {


    /**
     * 判断num是否为2的整数次幂V1
     *
     * @param num
     * @return
     */
    public boolean powerOf2V1(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("请输入大于0的数");
        }
        int temp = 2;
        while (num >= temp) {
            if (num == temp) {
                return true;
            }
            temp *= 2;
        }
        return false;
    }

    /**
     * 判断num是否为2的整数次幂V2
     *
     * @param num
     * @return
     */
    public boolean powerOfV2(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("请输入大于0的数");
        }
        int temp = 2;
        while (num >= temp) {
            if (num == temp) {
                return true;
            }
            temp = temp << 1;
        }
        return false;

    }

    /**
     * 判断num是否为2的整数次幂V2
     *
     * @param num
     * @return
     */
    public boolean powerOfV3(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("请输入大于0的数");
        }
        return (num & (num - 1)) == 0;

    }
}
