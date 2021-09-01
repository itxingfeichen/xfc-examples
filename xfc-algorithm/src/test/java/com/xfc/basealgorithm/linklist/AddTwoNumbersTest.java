package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import com.xfc.utils.AlgorithmUtils;
import junit.framework.TestCase;

public class AddTwoNumbersTest extends TestCase {

    public void testAddTwoNumbers() {
        final ListNode listNode = new ListNode(2);
        final ListNode listNode1 = new ListNode(4);
        final ListNode focusNode = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = focusNode;

        final ListNode listNode20 = new ListNode(5);
        final ListNode listNode21 = new ListNode(6);
        final ListNode listNode22 = new ListNode(4);
        listNode20.next = listNode21;
        listNode21.next = listNode22;
        final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        final ListNode result = addTwoNumbers.addTwoNumbers(listNode, listNode20);
        AlgorithmUtils.printLinkList(result);
    }
}