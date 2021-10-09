package com.xfc.basealgorithm.string;

/**
 * 字符串循环位移包含
 * s1 = AABCD, s2 = CDAA
 * Return : true
 * 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 *
 * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 *
 * @author xf.chen
 * @date 2021/9/3 11:06
 * @since 1.0.0
 */
public class LoopDisplacementInclude {

    public boolean loopInclude(String a, String b) {
        //解法二，拼接字符串s1+s1
        // 如果s2可以由s1循环移位得到，那么s2一定在s1s1上
        final String concat = a.concat(a);
        return concat.contains(b);
    }

    /**
     * 解法1
     */
    private boolean forEach(String a, String b) {
        if (a.contains(b)) {
            return true;
        }
        int i = a.length();
        String current = a;
        while (--i >= 0) {
            current = current.substring(1) + current.charAt(0);
            System.out.println(current);
            if (current.contains(b)) {
                return true;
            }
        }
        return false;
    }
}
