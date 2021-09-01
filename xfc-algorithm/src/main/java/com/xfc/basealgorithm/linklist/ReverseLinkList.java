package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;

/**
 * 链表反转
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/8/30 18:05
 * @since 1.0.0
 */
public class ReverseLinkList {

    public ListNode reverseList(ListNode head) {

        return forEach(head);
    }

    /**
     * 递归模式
     */
    private ListNode recursion(ListNode head) {
        // 如果为空或者只有一个节点则不用反转
        if (head == null || head.next == null) {
            return head;
        }
        // 获取下一个节点，
        final ListNode next = head.next;
        final ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     */
    private ListNode forEach(ListNode head) {
        // 如果为空或者只有一个节点则不用反转
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


}
