package com.xfc.basealgorithm.doublepointer;

import junit.framework.TestCase;

import java.util.Arrays;

public class LongestWordTest extends TestCase {

    public void testFindLongestWord() {
        final LongestWord longestWord = new LongestWord();
        final String word = longestWord.findLongestWord("abpcplea", Arrays.asList("apple", "ale", "monkey", "plea"));
        System.out.println(word);

    }
}