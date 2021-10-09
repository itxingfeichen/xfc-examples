package com.xfc.basealgorithm.string;

import junit.framework.TestCase;
import org.junit.Assert;

public class ValidAnagramWordTest extends TestCase {

    public void testIsAnagram() {

        final ValidAnagramWord validAnagramWord = new ValidAnagramWord();
        final boolean anagram = validAnagramWord.isAnagram("anagram", "nagaram");
        Assert.assertTrue(anagram);
    }
}