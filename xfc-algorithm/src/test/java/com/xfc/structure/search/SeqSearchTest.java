package com.xfc.structure.search;


import org.junit.Assert;
import org.junit.Test;

/**
 * 线性查找测试
 */
public class SeqSearchTest {


    @Test
    public void search() {
        SeqSearch instance = SeqSearch.getInstance();
        int search = instance.search(instance.prepareData(), 123);
        Assert.assertEquals(search,7);
    }
}