package com.xfc.algorithm.kmp;

/**
 * kmp算法
 *
 * @author jannik
 * @date 2020-02-03
 */
public class KMPAlgorithm {

    public int kmpSearch(String original, String target) {

        int[] next = next(target);
        for (int i = 0, j = 0; i < original.length(); i++) {
            while (j > 0 && original.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }

            if (original.charAt(i) == target.charAt(j)) {
                j++;
            }

            if (j == target.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }

    /**
     * 获取部分匹配表
     *
     * @param target
     */
    private int[] next(String target) {

        int[] next = new int[target.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < target.length(); i++) {

            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }

            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }

            next[i] = j;
        }
        return next;
    }
}
