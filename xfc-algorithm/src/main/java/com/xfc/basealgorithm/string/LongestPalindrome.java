package com.xfc.basealgorithm.string;

/**
 * 最长回文字符串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/3 15:02
 * @since 1.0.0
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            arr[aChar]++;
        }
        // 奇数个数
        int count = 0;
        for (int i : arr) {
            if(i == 0){
                continue;
            }
            count += i % 2;
        }
        return count == 0 ? s.length() : s.length() - count + 1;
    }


}
