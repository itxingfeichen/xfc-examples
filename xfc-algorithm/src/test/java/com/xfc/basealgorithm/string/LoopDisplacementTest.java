package com.xfc.basealgorithm.string;

import junit.framework.TestCase;
import org.junit.Assert;

public class LoopDisplacementTest extends TestCase {

    public void testLoopDisplacement() {
        final LoopDisplacement loopDisplacement = new LoopDisplacement();
        final String displacement = loopDisplacement.loopDisplacement("abcd123", 3);
        Assert.assertEquals("123abcd", displacement);

    }
}