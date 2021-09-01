package com.xfc.basealgorithm.doublepointer;

import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromeTest extends TestCase {

    public void testValidPalindrome() {
        final Palindrome palindrome = new Palindrome();
        final boolean result = palindrome.validPalindrome("ebcbb ececabbacec  bbcbe");
        Assert.assertTrue(result);

    }
}