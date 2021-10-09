package com.xfc.basealgorithm.string;

/**
 * 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的字符串长度不会超过 1000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/3 16:15
 * @since 1.0.0
 */
public class PalindromeSubstring {


    public int countSubstrings(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        //len是当前已经遍历的字符串的长度，即 "|" 左边部分的长度
        for (int len = 1; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {
                //若是单个字符，则一定是回文串
                if (len == 1) {
                    dp[i][i] = true;
                } else if (s.charAt(i) == s.charAt(i + len - 1)
                        && (len == 2 || dp[i + 1][i + len - 2])) {
                    dp[i][i + len - 1] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
