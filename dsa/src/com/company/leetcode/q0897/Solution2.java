package com.company.leetcode.q0897;

import java.util.LinkedList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * 在中序遍历的过程中改变节点指向
 *
 * @author 赵丙双
 * @since 2021.10.28
 */
public class Solution2 {


    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(0, null, root);
        parent = dummyNode;
        inorder(dummyNode.right);
        return dummyNode.right;
    }

    private TreeNode parent;

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        parent.right = node;
        node.left = null;
        parent = node;
        inorder(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
