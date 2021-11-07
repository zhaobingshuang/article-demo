package com.company.leetcode.q0700;

/**
 * 700. 二叉搜索树中的搜索
 *
 * 迭代
 *
 * @author 赵丙双
 * @since 2021.10.20
 */
public class Solution2 {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            int v = root.val;
            if (v == val) {
                return root;
            } else if (v > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
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
