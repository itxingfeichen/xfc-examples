package com.xfc.basealgorithm.string;

import junit.framework.TestCase;
import org.junit.Assert;

public class LoopDisplacementIncludeTest extends TestCase {

    public void testLoopInclude() {
        final LoopDisplacementInclude displacementInclude = new LoopDisplacementInclude();
        final boolean result = displacementInclude.loopInclude("AABCD", "CDAA");
        Assert.assertTrue(result);

    }
}