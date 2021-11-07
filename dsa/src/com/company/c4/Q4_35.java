package com.company.c4;

/**
 * 构造高度为 h 的最少节点的 AVL 树
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_35 {

    public TreeNode generateTree(int height) {
        return generateTree(height, new int[]{0});
    }

    /**
     * lastValue 存储最后一个分配的 value
     */
    public TreeNode generateTree(int height, int[] lastValue) {
        if (height < 0) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.left = generateTree(height - 1, lastValue);
        node.value = ++lastValue[0];
        node.right = generateTree(height - 2, lastValue);

        return null;
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
