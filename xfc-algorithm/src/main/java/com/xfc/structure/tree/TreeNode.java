package com.xfc.structure.tree;

import lombok.Data;

/**
 * @author jannik
 * @date 2020-01-02
 */
@Data
public class TreeNode<V> {

    private TreeNode<V> left;

    private TreeNode<V> right;

    private V data;

    public TreeNode(V data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
