package com.xfc.basealgorithm.greedy;

/**
 * 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/13 11:45
 * @since 1.0.0
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            // 前一个
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            // 后一个
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            // 满足前面后面都是0，则说明当前位置可以种植
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }

    private boolean methodStep(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0; ) {
            if (flowerbed[i] == 1) {
                //即如果，当前i位置已经种植了话，那么下一个可以种花的位置是 i+2
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                //这里很关键
                //如果是最后一个位置了，那么肯定能够种植（i==flowerbed.length-1)
                //如果不是，则还需要确保 可种花的位置(i+2)紧邻其后的(i+2+1)的位置没有种植（flowerbed[i+1]==0)
                //只有这样才可以种植
                n--;
                //同时找出下一个可以种植的位置
                i += 2;
            } else {
                //这种情况是flowerbed[i+2+1]=1，所以下次循环就从这里重新开始判断其后可种植的位置
                i += 3;
            }
        }
        return n <= 0;
    }
}
