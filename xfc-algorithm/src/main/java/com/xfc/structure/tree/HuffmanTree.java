package com.xfc.structure.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 哈夫曼树
 *
 * @author jannik
 * @date 2020-01-05
 */
public class HuffmanTree {

    public TreeNode<Integer> createHuffmanTree(int[] data){
        // 将数组转换为list便于操作
        ArrayList<TreeNode> nodes = new ArrayList<>(data.length);
        for (int datum : data) {
            nodes.add(new TreeNode<>(data));
        }
        return doCreate(nodes);

    }

    public TreeNode doCreate(ArrayList<TreeNode> nodes){

//        Arrays.sort(nodes);
        return null;
    }
}
