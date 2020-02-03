package com.xfc.algorithm.kmp;

import org.junit.Test;

public class KMPAlgorithmTest {

    @Test
    public void kmpSearch() {

        KMPAlgorithm kmpAlgorithm = new KMPAlgorithm();
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println("index = " + kmpAlgorithm.kmpSearch(str1, str2));
    }
}