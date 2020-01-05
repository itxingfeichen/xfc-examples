package com.xfc.structure.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 哈夫曼树测试
 */
public class HuffmanTreeTest {

    @Test
    public void createHuffmanTree() {
        int[] da = {4,6,8,5,9};

        HuffmanTree huffmanTree = HuffmanTree.getInstance();
        TreeNode<Integer> treeNode = huffmanTree.createHuffmanTree(da);
        MyTree<Integer> myTree = new MyTree<>();
        myTree.preTraversal(treeNode);
    }
}