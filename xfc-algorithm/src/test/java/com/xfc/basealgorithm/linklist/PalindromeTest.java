package com.xfc.basealgorithm.linklist;

import com.xfc.basealgorithm.base.ListNode;
import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromeTest extends TestCase {

    public void testIsPalindrome() {
        final ListNode listNode20 = new ListNode(1);
        final ListNode listNode21 = new ListNode(2);
        final ListNode listNode22 = new ListNode(2);
        listNode20.next = listNode21;
        listNode21.next = listNode22;
        final Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.isPalindrome(listNode20));;
    }
}