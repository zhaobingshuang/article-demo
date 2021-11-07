package com.company.leetcode.q0701;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * 迭代：记录父节点；要插入到左边还是右边
 *
 * @author 赵丙双
 * @since 2021.10.20
 */
public class Solution2 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            return newNode;
        }

        // 父节点
        TreeNode parent = null, node = root;
        // 要插入到左边还是右边
        boolean isLeft = false;
        while (node != null) {
            parent = node;
            if (val > node.val) {
                node = node.right;
                isLeft = false;
            } else {
                node = node.left;
                isLeft = true;
            }
        }

        if (isLeft) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
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
