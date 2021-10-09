package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import com.xfc.utils.AlgorithmUtils;
import junit.framework.TestCase;

public class ReverseLinkListTest extends TestCase {

    public void testReverseList() {

        final ListNode listNode = new ListNode(1);
        final ListNode next = new ListNode(2);
        final ListNode next3 = new ListNode(3);
        listNode.next = next;
        next.next = next3;
        final ReverseLinkList reverseLinkList = new ReverseLinkList();
        final ListNode reversedLindList = reverseLinkList.reverseList(listNode);

        AlgorithmUtils.printLinkList(reversedLindList);

    }
}