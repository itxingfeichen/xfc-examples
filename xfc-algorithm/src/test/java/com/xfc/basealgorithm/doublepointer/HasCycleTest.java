package com.xfc.basealgorithm.doublepointer;

import com.xfc.basealgorithm.base.ListNode;
import junit.framework.TestCase;
import org.junit.Assert;

public class HasCycleTest extends TestCase {

    public void testHasCycle() {

        final ListNode listNode = new ListNode(1);
        final ListNode listNode2 = new ListNode(2);
        final ListNode listNode3 = new ListNode(3);
        final ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        final HasCycle hasCycle = new HasCycle();
        Assert.assertTrue(hasCycle.hasCycle(listNode));


    }
}