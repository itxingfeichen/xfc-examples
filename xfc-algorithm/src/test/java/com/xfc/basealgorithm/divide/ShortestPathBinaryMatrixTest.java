package com.xfc.basealgorithm.divide;

import junit.framework.TestCase;

public class ShortestPathBinaryMatrixTest extends TestCase {

    public void testShortestPathBinaryMatrix() {

        final ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        int[][] data = {{0,0,0}, {1,1,0}, {1,1,0}};
        final int binaryMatrix = shortestPathBinaryMatrix.shortestPathBinaryMatrix(data);

        System.out.println("binaryMatrix = " + binaryMatrix);
    }
}