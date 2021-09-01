package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import com.xfc.utils.AlgorithmUtils;
import junit.framework.TestCase;

public class RemoveNthFromEndTest extends TestCase {

    public void testRemoveNthFromEnd() {
//        final ListNode listNode = new ListNode(4);
//        final ListNode listNode1 = new ListNode(1);
//        final ListNode focusNode = new ListNode(8);
//        listNode.next = listNode1;
//        listNode1.next = focusNode;

        final ListNode listNode20 = new ListNode(1);
        final ListNode listNode21 = new ListNode(2);
        final ListNode listNode22 = new ListNode(1);
        final ListNode listNode24 = new ListNode(4);
        final ListNode listNode25 = new ListNode(5);
        listNode20.next = listNode21;
        listNode21.next = listNode22;
        listNode22.next = listNode24;
        listNode24.next = listNode25;
        final RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        final ListNode nthFromEnd = removeNthFromEnd.removeNthFromEnd(listNode20, 2);
        AlgorithmUtils.printLinkList(nthFromEnd);
    }
}