package com.xfc.basealgorithm.base;

/**
 * 树节点
 *
 * @author xf.chen
 * @date 2021/9/14 16:09
 * @since 1.0.0
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
