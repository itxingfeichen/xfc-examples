package com.xfc.basealgorithm.doublepointer;

/**
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a^2 + b^2 = c 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 平方和
 *
 * @author xf.chen
 * @date 2021/8/25 21:37
 * @since 1.0.0
 */
public class SquareSum {

    public boolean judgeSquareSum(int c) {
        final double sqrt = Math.sqrt(c);
        int low = 0;
        int up = (int) sqrt;

        while (low <= up) {
            final int result = low * low + up * up;
            if (result == c) {
                return true;
            } else if (c > result) {
                low++;
            } else {
                up--;
            }
        }
        return false;

    }
}
