package com.xfc.basealgorithm.string;

import junit.framework.TestCase;
import org.junit.Assert;

public class IsomorphicTest extends TestCase {

    public void testIsIsomorphic() {

        final Isomorphic isomorphic = new Isomorphic();
        final boolean isomorphic1 = isomorphic.isIsomorphic("egg", "iss");
        Assert.assertTrue(isomorphic1);
    }
}