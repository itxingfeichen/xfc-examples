package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;

import java.util.Stack;

/**
 * 两数相加
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/8/31 16:09
 * @since 1.0.0
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
                s1.push(temp1.val);
                s2.push(temp2.val);
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1 != null) {
                s1.push(temp1.val);
                temp1 = temp1.next;
            } else {
                s2.push(temp2.val);
                temp2 = temp2.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int proximal = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = 0;
            if (!s1.isEmpty() && !s2.isEmpty()) {
                final Integer pop = s1.pop();
                final Integer pop1 = s2.pop();
                sum = pop + pop1;

            } else if (!s1.isEmpty()) {
                sum = s1.pop();
            } else {
                sum = s2.pop();
            }
            if (proximal > 0) {
                sum += proximal;
                proximal = 0;
            }
            if (sum < 10) {
                dummy.next = new ListNode(sum);
            } else {
                proximal = sum / 10;
                int val = sum % 10;
                dummy.next = new ListNode(val);
            }
            dummy = dummy.next;

        }

        if (proximal > 0) {
            dummy.next = new ListNode(proximal);
        }
        return reverse(result.next);
    }


    private ListNode reverse(ListNode head) {

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
