package com.xfc.basealgorithm.greedy;

import junit.framework.TestCase;

import java.util.List;

public class PartitionLabelsTest extends TestCase {

    public void testPartitionLabels() {
        final PartitionLabels partitionLabels = new PartitionLabels();
        final List<Integer> result = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");

        System.out.println(result.toString());
    }
}