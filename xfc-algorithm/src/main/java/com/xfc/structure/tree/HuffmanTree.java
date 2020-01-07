package com.xfc.structure.tree;

import com.xfc.structure.sort.HeapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 哈夫曼树
 *
 * @author jannik
 * @date 2020-01-05
 */
public class HuffmanTree {

    private static final HuffmanTree huffmanTree = new HuffmanTree();

    public static HuffmanTree getInstance() {
        return huffmanTree;
    }

    private HuffmanTree() {
    }

    public TreeNode<Integer> createHuffmanTree(int[] originData) {
        int[] data = Arrays.copyOf(originData, originData.length);
        // 将数组转换为list便于操作
        ArrayList<TreeNode<Integer>> nodes = new ArrayList<>(data.length);
        for (int datum : data) {
            nodes.add(new TreeNode<>(datum));
        }
        return doCreate(nodes);

    }

    /**
     * 哈夫曼树创建
     *
     * @param nodes
     * @return
     */
    private TreeNode<Integer> doCreate(ArrayList<TreeNode<Integer>> nodes) {
        while (nodes.size() != 1) {
            Collections.sort(nodes);
            TreeNode<Integer> nodeLeft = nodes.get(0);
            TreeNode<Integer> nodeRight = nodes.get(1);
            TreeNode<Integer> parent = new TreeNode<>(nodeLeft.getData() + nodeRight.getData());
            parent.setLeft(nodeLeft);
            parent.setRight(nodeRight);
            nodes.remove(nodeLeft);
            nodes.remove(nodeRight);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
