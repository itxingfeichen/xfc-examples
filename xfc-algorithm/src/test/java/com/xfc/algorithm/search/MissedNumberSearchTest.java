package com.xfc.algorithm.search;

import org.junit.Test;

public class MissedNumberSearchTest {

    private static final int[] data = {1,3};

    private final MissedNumberSearch numberSearch = new MissedNumberSearch();


    @Test
    public void missedNumberSearch1() {
        System.out.println("结果1:"+numberSearch.missedNumberSearch1(data));
    }

    @Test
    public void missedNumberSearch2() {
        System.out.println("结果2:"+numberSearch.missedNumberSearch2(data));
    }

    @Test
    public void missedNumberSearch3() {
        System.out.println("结果3:"+numberSearch.missedNumberSearch3(data));
    }
}