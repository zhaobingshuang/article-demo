package com.company.leetcode.q0094;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.14
 */
public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            list.add(root.val);
            root = root.right;
            stack.pop();
        }

        return list;
    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        List<Integer> list = new Solution3().inorderTraversal(node1);
        System.out.println(list);
    }
}
