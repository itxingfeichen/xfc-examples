package com.xfc.basealgorithm.sort;

import java.util.*;

/**
 * 根据字符串出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/8 11:45
 * @since 1.0.0
 */
public class FrequencySort {

    public String frequencySort(String s) {
        // 通过hashmap统计单个字符出现的次数
        final char[] chars = s.toCharArray();
        Map<Character, Integer> maps = new HashMap<>();
        for (char aChar : chars) {
            maps.put(aChar, maps.getOrDefault(aChar, 0) + 1);
        }

        // 排序
        List<Character> characters = new ArrayList<>(maps.keySet());
        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return -(maps.get(o1) - maps.get(o2));
            }
        });
        // 拼接最终的字符串
        StringBuffer buffer = new StringBuffer();
        for (Character character : characters) {
            final Integer count = maps.get(character);
            for (Integer i = 0; i < count; i++) {
                buffer.append(character);
            }
        }
        return buffer.toString();
    }
}
