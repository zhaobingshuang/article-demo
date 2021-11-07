package com.company.leetcode.q1325;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.06
 */
public class Solution {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}