package com.company.leetcode.q0938;

/**
 * 938. 二叉搜索树的范围和
 *
 * @author 赵丙双
 * @since 2021.11.06
 */
public class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

}
