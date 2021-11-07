package com.company.c4;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.06
 */
public class Q4_46 {


    static boolean similar(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            return similar(t1.left, t2.left) && similar(t1.right, t2.right);
        }
    }

    private static class TreeNode {
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
