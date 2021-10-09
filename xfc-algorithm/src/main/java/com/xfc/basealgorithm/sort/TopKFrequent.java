package com.xfc.basealgorithm.sort;

import java.util.*;

/**
 * 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/8 10:19
 * @since 1.0.0
 */
public class TopKFrequent {


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }

    private int[] priorityQueue(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }

        // 使用优先级队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return maps.get(o1) - maps.get(o2);
            }
        });

        // 遍历map的key
        for (Integer integer : maps.keySet()) {
            if (queue.size() >= k) {
                if (!queue.isEmpty() && maps.get(queue.peek()) < maps.get(integer)) {
                    queue.poll();
                    queue.offer(integer);
                }
            } else {
                queue.offer(integer);
            }
        }
        // 遍历queue，取出数据组成数组即可
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = queue.poll();
        }

        return ret;
    }


}
