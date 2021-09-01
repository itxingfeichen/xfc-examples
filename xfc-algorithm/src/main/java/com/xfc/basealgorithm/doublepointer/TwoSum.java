package com.xfc.basealgorithm.doublepointer;

/**
 * 167. 两数之和 II - 输入有序数组
 * 两数之和
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/8/25 15:03
 * @since 1.0.0
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        return doublePointer(numbers, target);
    }


    private int[] doublePointer(int[] numbers, int target) {
        int low = 0, up = numbers.length - 1;
        while (low < up) {
            final int re = numbers[low] + numbers[up];

            if (re == target) {
                return new int[]{low + 1, up + 1};
            }

            if (re < target) {
                low++;
            } else {
                up--;
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 暴力计算 复杂度 O(n^2)
     */
    private int[] forceCalculate(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int i1 = 0; i1 < numbers.length; i1++) {
                if (numbers[i] + numbers[i1] == target && i != i1) {
                    return new int[]{i + 1, i1 + 1};
                }
            }
        }
        return result;
    }
}
