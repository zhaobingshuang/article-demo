package com.company.leetcode.q0100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 层序遍历
 *
 * @author 赵丙双
 * @since 2021.10.19
 */
public class Solution3 {
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
            if (node1.val != node2.val) {
                return false;
            }

            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            // 这里只需要判断左右的结构是否相同就可以，不需要判断值
            if (left1 == null ^ left2 == null) {
                return false;
            }

            if (right1 == null ^ right2 == null) {
                return false;
            }

            offerIfNonNull(queue1, left1);
            offerIfNonNull(queue1, right1);
            offerIfNonNull(queue2, left2);
            offerIfNonNull(queue2, right2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public void offerIfNonNull(Queue<TreeNode> queue, TreeNode node) {
        if (node != null) {
            queue.offer(node);
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
