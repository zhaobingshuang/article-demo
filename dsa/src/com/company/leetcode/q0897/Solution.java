package com.company.leetcode.q0897;

import java.util.LinkedList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * 额外的 List
 *
 * @author 赵丙双
 * @since 2021.10.28
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        inorder(root, list);

        for (int i = 1, size = list.size(); i < size; i++) {
            TreeNode right = list.get(i);
            right.left = null;
            right.right = null;
            list.get(i - 1).right = right;
        }
        return list.get(0);
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
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
