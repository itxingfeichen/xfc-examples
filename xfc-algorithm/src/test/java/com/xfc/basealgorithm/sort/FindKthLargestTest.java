package com.xfc.basealgorithm.sort;

import junit.framework.TestCase;

public class FindKthLargestTest extends TestCase {

    public void testFindKthLargest() {
        final FindKthLargest findKthLargest = new FindKthLargest();
        int[] numbers = {3,2,3,1,2,4,5,5,6};
        final int kthLargest = findKthLargest.findKthLargest(numbers, 4);
        System.out.println(kthLargest);
    }
}