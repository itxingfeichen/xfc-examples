package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

public class FindContentChildrenTest extends TestCase {

    public void testFindContentChildren() {

        final FindContentChildren findContentChildren = new FindContentChildren();
        int[] ar = {10,9,8,7};
        int[] ab = {1,2};
        System.out.println(findContentChildren.findContentChildren(ar, ab));


    }
}