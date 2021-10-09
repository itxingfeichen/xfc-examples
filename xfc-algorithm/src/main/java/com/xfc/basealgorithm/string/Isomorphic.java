package com.xfc.basealgorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 可以假设 s 和 t 长度相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/3 15:29
 * @since 1.0.0
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if(s.indexOf(x) != t.indexOf(y)){
                return false;
            }
        }
        return true;
    }
}
