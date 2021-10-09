package com.xfc.basealgorithm.sort;

import java.util.Arrays;

/**
 * 找到数组中第k个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/7 14:24
 * @since 1.0.0
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums, k);
    }

    private int force(int[] nums, int num) {
        Arrays.sort(nums);

        return nums[nums.length - num];
    }

    private int quickSort(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        final int target = nums.length - k;
        while (true) {
            int index = partition(nums, left, right);
            System.out.println(Arrays.toString(nums) + "     = " + index);
            if (target == index) {
                return nums[index];
            } else if (target > index) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] numbers, int left, int right) {
        int pivot = numbers[left];

        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (numbers[i] < pivot) {
                j++;
                swap(numbers, i, j);
            }
        }
        swap(numbers, j, left);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
