package com.xfc.basealgorithm.divide;

import com.xfc.basealgorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/14 16:09
 * @since 1.0.0
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        final LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (start > end) {
            linkedList.add(null);
            return linkedList;
        }
        for (int i = start; i <= end; i++) {
            final List<TreeNode> treeNodes = generateTrees(start, i - 1);
            final List<TreeNode> treeNodes1 = generateTrees(i + 1, end);
            for (TreeNode left : treeNodes) {
                for (TreeNode right : treeNodes1) {
                    final TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    linkedList.add(curr);
                }
            }
        }
        return linkedList;
    }

}
