package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import com.xfc.utils.AlgorithmUtils;
import junit.framework.TestCase;

public class SwapPairsFromLinkListTest extends TestCase {

    public void testSwapPairs() {
        final ListNode listNode20 = new ListNode(1);
        final ListNode listNode21 = new ListNode(2);
        final ListNode listNode22 = new ListNode(3);
        final ListNode listNode24 = new ListNode(4);
        final ListNode listNode25 = new ListNode(5);
        listNode20.next = listNode21;
        listNode21.next = listNode22;
        listNode22.next = listNode24;
        listNode24.next = listNode25;
        final SwapPairsFromLinkList swapPairsFromLinkList = new SwapPairsFromLinkList();
        final ListNode swapPairs = swapPairsFromLinkList.swapPairs(listNode20);
        AlgorithmUtils.printLinkList(swapPairs);

    }
}