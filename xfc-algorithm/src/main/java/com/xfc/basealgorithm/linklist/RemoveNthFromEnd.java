package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;

/**
 * 删除链表的倒数第几个元素
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/8/31 14:22
 * @since 1.0.0
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 计算链表长度
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        length -= n;
        ListNode dummy = new ListNode(0);
        ListNode first=  dummy;
        dummy.next = head;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


    private ListNode dirtyCode(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        // 计算链表长度
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        int thePosition = length - n;
        ListNode remove = head;
        while (thePosition > 1) {
            remove = remove.next;
            thePosition--;
        }
        if (thePosition == 0) {
            return head.next;
        }
        remove.next = remove.next.next;
        return head;
    }
}
