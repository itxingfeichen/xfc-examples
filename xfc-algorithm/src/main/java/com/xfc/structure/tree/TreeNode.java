package com.xfc.structure.tree;

import lombok.Data;

/**
 * @author jannik
 * @date 2020-01-02
 */
@Data
public class TreeNode<V> implements Comparable<TreeNode<V>> {

    private TreeNode<V> left;

    private TreeNode<V> right;

    private V data;

    public TreeNode(V data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode<V> o) {
        if (o.data instanceof Integer) {
            int data1 = (int) o.data;
            int data = (int) this.data;
            return data - data1;
        }
        return 0;
    }
}
