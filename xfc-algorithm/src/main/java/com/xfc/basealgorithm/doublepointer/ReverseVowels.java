package com.xfc.basealgorithm.doublepointer;

/**
 * 反转字符串中的原音
 * 345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 *
 * @author xf.chen
 * @date 2021/8/26 10:16
 * @since 1.0.0
 */
public class ReverseVowels {

    private static final String VOWEL = "aeiouAEIOU";

    public String reverseVowels(String s) {
        final char[] chars = s.toCharArray();
        int low = 0;
        int up = chars.length - 1;
        while (low < up) {
            final char lowChar = chars[low];
            final char upChar = chars[up];
            boolean lowIsVowel = isVowel(lowChar), upIsVowel = isVowel(upChar);

            if (lowIsVowel && upIsVowel) {
                chars[low] = upChar;
                chars[up] = lowChar;
                up--;
                low++;
            } else if (lowIsVowel) {
                up--;
            } else {
                low++;
            }

        }
        return new String(chars);
    }

    /**
     * 判断是否为元音 （aeiouAEIOU）
     */
    private boolean isVowel(char c) {
        return VOWEL.indexOf(c) >= 0;
    }
}
