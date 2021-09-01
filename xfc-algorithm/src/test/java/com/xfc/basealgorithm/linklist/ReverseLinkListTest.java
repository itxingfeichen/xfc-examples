package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import com.xfc.utils.AlgorithmUtils;
import junit.framework.TestCase;

public class ReverseLinkListTest extends TestCase {

    public void testReverseList() {

        final ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);

        final ReverseLinkList reverseLinkList = new ReverseLinkList();
        final ListNode reversedLindList = reverseLinkList.reverseList(listNode);

        AlgorithmUtils.printLinkList(reversedLindList);

    }
}