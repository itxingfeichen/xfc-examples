package com.xfc.algorithm.search;

import org.junit.Test;

public class BinarySearchNoRecursiveTest {

    @Test
    public void binarySearch() {

        int data[] = {1, 3, 8, 43, 51, 80, 100};
        BinarySearchNoRecursive searchNoRecursive = new BinarySearchNoRecursive();
        System.out.println(searchNoRecursive.binarySearch(data, 100));
    }
}