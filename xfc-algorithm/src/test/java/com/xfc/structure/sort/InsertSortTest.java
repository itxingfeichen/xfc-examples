package com.xfc.structure.sort;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertSortTest {

    @org.junit.Test
    public void doSort() {

        int[] data = {1, 2, 3, 4};
        int[] dataInverse = {1, 3, 2, 4};

        System.out.println(Arrays.toString(new InsertSort().doSort(dataInverse)));
    }
}