package com.xfc.structure.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 插值查找
 */
public class InsertValueSearchTest {


    @Test
    public void search() {
        InsertValueSearch instance = InsertValueSearch.getInstance();
        int search = instance.search(instance.prepareData(), 123);
        Assert.assertEquals(search, 7);
    }
}