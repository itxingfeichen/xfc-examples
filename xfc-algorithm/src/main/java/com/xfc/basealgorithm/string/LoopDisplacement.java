package com.xfc.basealgorithm.string;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 字符串循环位移
 * s = "abcd123" k = 3
 * Return "123abcd"
 * 将字符串向右循环移动 k 位。
 * <p>
 * 将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
 *
 * @author xf.chen
 * @date 2021/9/3 11:27
 * @since 1.0.0
 */
public class LoopDisplacement {

    public String loopDisplacement(String s, int a) {
        String tmpStr = "";
        String number = "";
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                tmpStr += chars[i];
            } else {
                number += chars[i];
            }
        }

        return number + tmpStr;
    }


}
