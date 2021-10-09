package com.xfc.basealgorithm.string;

import junit.framework.TestCase;

public class ReversePrefixTest extends TestCase {

    public void testReversePrefix() {
        final ReversePrefix reversePrefix = new ReversePrefix();
        System.out.println(reversePrefix.reversePrefix("abcdefd", 'd'));
    }
}