package com.xfc.basealgorithm.doublepointer;

import junit.framework.TestCase;
import org.junit.Assert;

public class VowelsTest extends TestCase {

    public void testReverseVowels() {

        final ReverseVowels reverseVowels = new ReverseVowels();
        final String vowels = reverseVowels.reverseVowels("ai");
        Assert.assertEquals("ia",vowels);
    }
}