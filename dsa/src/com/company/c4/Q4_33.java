package com.company.c4;

/**
 * 删除叶子结点
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_33 {

    public TreeNode removeLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        // 不要忘记重新赋值，子树的根节点可能发生变化
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
