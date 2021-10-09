package com.xfc.basealgorithm.string;

import junit.framework.TestCase;

public class ReverseWordTest extends TestCase {

    public void testReverseWord() {

        final ReverseWord reverseWord = new ReverseWord();
        final String result = reverseWord.reverseWord("I am a student");
        System.out.println(result);

    }
}