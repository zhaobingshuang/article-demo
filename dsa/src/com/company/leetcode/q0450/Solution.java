package com.company.leetcode.q0450;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * 递归
 *
 * @author 赵丙双
 * @since 2021.10.20
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
                root.val = findMin(root.right).val;
                root.right = deleteMin(root.right);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else {
                return root.right;
            }
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }


    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

//    private int deleteMin(TreeNode root) {
//        TreeNode parent = root;
//        while (root.left != null) {
//            root = root.left;
//            parent = root;
//        }
//        parent.left = root.right;
//        return root.val;
//    }

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
