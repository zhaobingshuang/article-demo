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
public class Solution5 {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root, pre = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode top = stack.peek();
            TreeNode right = top.right;
            if (right == null || pre == right) {
                stack.pop();
                pre = top;
                list.add(top.val);
            } else {
                node = right;
            }
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

//        List<Integer> list = new Solution5().inorderTraversal(node1);
//        System.out.println(list);
    }
}
