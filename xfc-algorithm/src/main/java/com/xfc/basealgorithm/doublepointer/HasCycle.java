package com.xfc.basealgorithm.doublepointer;


import com.xfc.basealgorithm.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否存在环
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/8/26 16:10
 * @since 1.0.0
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head, p2 = head.next;

        while (p1 != p2) {
            if (p2.next == null || p2.next.next == null) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;


    }

    private boolean hash(ListNode head) {
        Set<ListNode> hash = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (!hash.add(tmp)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

}


