package com.xfc.basealgorithm.string;

import junit.framework.TestCase;
import org.junit.Assert;

public class IsPalindromeTest extends TestCase {

    public void testIsPalindrome() {
        final IsPalindrome isPalindrome = new IsPalindrome();
        final boolean palindrome = isPalindrome.isPalindrome(121);
        Assert.assertTrue(palindrome);
    }
}