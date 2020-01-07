package com.xfc.structure.tree;

/**
 * 二叉树操作
 *
 * @author jannik
 * @date 2020-01-01
 */
public class MyTree<V> {


    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<>(1);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(4);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        treeNode.setLeft(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        treeNode.setRight(node4);
        MyTree<Integer> myTree = new MyTree<>();
        myTree.preTraversal(treeNode);

    }


    /**
     * 前序遍历
     */
    public void preTraversal(TreeNode<V> treeNode) {
        if (treeNode == null) {
            System.out.println("此树空树");
            return;
        }
        //
        System.out.println(treeNode);
        if (treeNode.getLeft() != null) {
            preTraversal(treeNode.getLeft());
        }
        if (treeNode.getRight() != null) {
            preTraversal(treeNode.getRight());
        }
    }

    /**
     * 中序遍历
     */
    private void medilleTraversal(TreeNode<V> treeNode) {
        if (treeNode == null) {
            System.out.println("此树空树");
            return;
        }
        //
        if (treeNode.getLeft() != null) {
            preTraversal(treeNode.getLeft());
        }
        System.out.println(treeNode.getData());
        if (treeNode.getRight() != null) {
            preTraversal(treeNode.getRight());
        }
    }
    /**
     * 前序遍历
     */
    private void postTraversal(TreeNode<V> treeNode) {
        if (treeNode == null) {
            System.out.println("此树空树");
            return;
        }
        //
        if (treeNode.getLeft() != null) {
            preTraversal(treeNode.getLeft());
        }
        if (treeNode.getRight() != null) {
            preTraversal(treeNode.getRight());
        }
        System.out.println(treeNode.getData());
    }


}
