package com.xfc.structure.tree;

import lombok.Data;

/**
 * @author jannik
 * @date 2020-01-02
 */
@Data
public class TreeNode<V> implements Comparable<TreeNode<Integer>> {

    private TreeNode<V> left;

    private TreeNode<V> right;

    private Integer data;

    public TreeNode(Integer data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode<Integer> o) {
        if (o.data != null) {
            int data1 = (int) o.data;
            int data = (int) this.data;
            return data - data1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
