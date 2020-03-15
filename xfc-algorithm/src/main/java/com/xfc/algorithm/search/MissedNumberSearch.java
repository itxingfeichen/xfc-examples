package com.xfc.algorithm.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 查找缺失的整数
 * 题目：在一个无序数组里有99个不重复的正整数，范围是1～100 ，唯独缺少1个1～100中的整数，如何找出这个缺失的整数
 *
 * @author jannik
 * @date 2020-03-15
 */
public class MissedNumberSearch {

    /**
     * 方法一：根据hash表映射，判断hash表内的元素是否包含数组中的元素，不包含的那个数就是缺失的那个数字
     * <p>
     * 时间复杂度：O(2n) 单独申请了内存空间，空间复杂度大了
     *
     * @param nums
     * @return
     */
    public int missedNumberSearch1(int[] nums) {

        Set<Integer> numbers = new HashSet<>(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            numbers.add(i);
        }

        for (int i = 1; i < nums.length; i++) {
            if (numbers.contains(nums[i - 1])) {
                numbers.remove(nums[i - 1]);
            }
        }

        return numbers.size() == 1 ? numbers.iterator().next() : -1;

    }

    /**
     * 方法二：排序，然后判断后一个元素和前一个元素的差是否为1
     * <p>
     * 时间复杂度：O(2n)
     *
     * @param nums
     * @return
     */
    public int missedNumberSearch2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 1 2 3 4 5 7
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException("not found a number for adapted");

    }


    /**
     * 方法三：高斯定律算法，先计算出1到制定元素的和，然后减除数组中的元素
     * <p>
     * 时间复杂度：O(2n)
     *
     * @param nums
     * @return
     */
    public int missedNumberSearch3(int[] nums) {
        int sum = ((nums.length + 1) * (nums.length + 2)) / 2;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;

    }
}
