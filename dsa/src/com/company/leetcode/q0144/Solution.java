package com.company.leetcode.q0144;

import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 递归
 *
 * @author 赵丙双
 * @since 2021.10.19
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
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
