package com.xfc.basealgorithm.doublepointer;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * 回文字符串
 *
 * @author xf.chen
 * @date 2021/8/26 10:58
 * @since 1.0.0
 */
public class Palindrome {

    public boolean validPalindrome(String s) {
        final char[] chars = s.toCharArray();
        int low = 0;
        int up = chars.length - 1;
        while (low < up) {
            if (chars[low] == chars[up]) {
                low++;
                up--;
            } else {
                return valid(s, low + 1, up) || valid(s, low, up - 1);
            }
        }
        return true;

    }

    private boolean valid(String s, int low, int up) {
        final char[] chars = s.toCharArray();
        while (low < up) {
            if (chars[low] != chars[up]) {
                return false;
            }
            low++;
            up--;
        }
        return true;
    }

}
