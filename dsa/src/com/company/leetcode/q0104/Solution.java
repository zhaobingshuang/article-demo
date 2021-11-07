package com.company.leetcode.q0104;

/**
 * 104. 二叉树的最大深度
 * 深度优先搜索
 *
 * @author 赵丙双
 * @since 2021.10.19
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
