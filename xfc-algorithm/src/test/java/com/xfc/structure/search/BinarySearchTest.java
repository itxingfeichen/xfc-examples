package com.xfc.structure.search;

import org.junit.Assert;
import org.junit.Test;
/**
 * 二分查找测试
 */
public class BinarySearchTest {

    @Test
    public void search() {
        BinarySearch instance = BinarySearch.getInstance();
        int search = instance.search(instance.prepareData(), 1);
        Assert.assertEquals(search,7);
    }
}
