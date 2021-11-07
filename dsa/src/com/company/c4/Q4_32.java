package com.company.c4;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_32 {

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.value >= root.value) {
            return false;
        }

        if (root.right != null && root.right.value <= root.value) {
            return false;
        }

        return isBST(root.left) && isBST(root.right);
    }


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
