package com.company.leetcode.q0100;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.19
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (!isSame(p, q)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val;
        }
    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);
        Solution solution = new Solution();
        solution.isSameTree(root, root);


    }

}
