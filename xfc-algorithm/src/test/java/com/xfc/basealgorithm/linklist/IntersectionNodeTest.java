package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import junit.framework.TestCase;
import org.junit.Assert;

public class IntersectionNodeTest extends TestCase {

    public void testGetIntersectionNode() {

        final ListNode listNode = new ListNode(4);
        final ListNode listNode1 = new ListNode(1);
        final ListNode focusNode = new ListNode(8);
        listNode.next = listNode1;
        listNode1.next = focusNode;

        final ListNode listNode20 = new ListNode(5);
        final ListNode listNode21 = new ListNode(0);
        final ListNode listNode22 = new ListNode(1);
        final ListNode listNode24 = new ListNode(4);
        final ListNode listNode25 = new ListNode(5);
        listNode20.next = listNode21;
        listNode21.next = listNode22;
        listNode22.next = focusNode;
        focusNode.next = listNode24;
        listNode24.next = listNode25;

        final IntersectionNode intersectionNode = new IntersectionNode();

        final ListNode result = intersectionNode.getIntersectionNode(listNode, listNode20);

        Assert.assertEquals(8, result.val);
    }
}