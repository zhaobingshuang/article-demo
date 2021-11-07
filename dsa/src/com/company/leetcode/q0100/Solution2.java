package com.company.leetcode.q0100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 层序遍历 - 初版：重复判断左右节点了
 *
 * @author 赵丙双
 * @since 2021.10.19
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (!equalsVal(node1, node2)) {
                return false;
            }

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            if (!equalsVal(left1, left2)) {
                return false;
            }


            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;
            if (!equalsVal(right1, right2)) {
                return false;
            }


            offer(queue1, left1, right1);
            offer(queue2, left2, right2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public boolean equalsVal(TreeNode n1, TreeNode n2) {
        if (n1 == n2) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        } else {
            return n1.val == n2.val;
        }
    }

    public void offer(Queue<TreeNode> queue, TreeNode left, TreeNode right) {
        if (left != null) {
            queue.offer(left);
        }

        if (right != null) {
            queue.offer(right);
        }
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
