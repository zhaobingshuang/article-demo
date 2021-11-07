package com.company.c4;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_31 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    /**
     * 左子树 + 右子树 + 本节点是不是满节点
     */
    public int countFull(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int full = root.left != null && root.right != null ? 1 : 0;
        return countFull(root.left) + countFull(root.right) + full;
    }


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
