package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;

import java.util.ArrayList;

/**
 * 回文
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/2 07:31
 * @since 1.0.0
 */
public class Palindrome {

    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }


    private boolean array(ListNode head) {
        // 转换为数组
        ListNode tmp = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (tmp != null) {
            arrayList.add(tmp.val);
            tmp = tmp.next;
        }
        int p1 = 0, p2 = arrayList.size() - 1;
        while (p1 < p2) {
            if (!arrayList.get(p1).equals(arrayList.get(p2))) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }


}
