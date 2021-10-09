package com.xfc.basealgorithm.greedy;

/**
 * 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/13 16:03
 * @since 1.0.0
 */
public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        for (int i = 0; i < nums.length -1 ; i++) {
            // 临近两个元素
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                nums[i] = y;
                if(!isSort(nums)){
                    nums[i] = x;
                    nums[i+1] = x;
                    if(!isSort(nums)){
                        return false;
                    }
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isSort(int[] nums) {
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < pre) {
                return false;
            }
            pre = nums[i];
        }
        return true;

    }

}
