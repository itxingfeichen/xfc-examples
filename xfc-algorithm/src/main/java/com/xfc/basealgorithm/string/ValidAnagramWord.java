package com.xfc.basealgorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/3 14:18
 * @since 1.0.0
 */
public class ValidAnagramWord {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
            if (arr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 因为一共26个字母，所以可以以来hash表
        Map<Character, Integer> maps = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (maps.containsKey(c)) {
                maps.put(c, maps.get(c) + 1);
            } else {
                maps.put(c, 1);
            }
        }
        final char[] chars = t.toCharArray();
        for (char aChar : chars) {
            if (maps.containsKey(aChar)) {
                if (maps.get(aChar) == 1) {
                    maps.remove(aChar);
                } else {
                    maps.put(aChar, maps.get(aChar) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法1，排序
     */
    private boolean sort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);

        final char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }
}
