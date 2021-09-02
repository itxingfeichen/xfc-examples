package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import junit.framework.TestCase;

public class PalindromeTest extends TestCase {

    public void testIsPalindrome() {
        final ListNode listNode20 = new ListNode(5);
        final ListNode listNode21 = new ListNode(0);
        final ListNode listNode22 = new ListNode(1);
        final ListNode listNode24 = new ListNode(4);
        final ListNode listNode25 = new ListNode(5);
        listNode20.next = listNode21;
        listNode21.next = listNode22;
        listNode22.next = listNode24;
        listNode24.next = listNode25;
        final Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome(listNode20);
    }
}