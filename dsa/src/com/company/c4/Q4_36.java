package com.company.c4;

/**
 * <pre>
 *     构造高度为 h 的完美平衡 BST，节点的值从 1 到 pow(2, h + 1) - 1
 * </pre> - 1 答复
 *
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_36 {


    /**
     * 和 35 题几乎相同，但是两个子树的高度都是 h - 1
     */
    public TreeNode generateTree1(int height) {
        return generateTree1(height, new int[]{0});
    }

    public TreeNode generateTree1(int height, int[] lastValue) {
        if (height < 0) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.left = generateTree1(height - 1, lastValue);
        node.value = ++lastValue[0];
        node.right = generateTree1(height - 1, lastValue);

        return null;
    }


    /**
     *
     */
    public TreeNode generateTree2(int h) {
        return generateTree2(1, (int) Math.pow(2, h + 1) - 1);
    }

    public TreeNode generateTree2(int lower, int upper) {
        if (lower > upper) {
            return null;
        }

        int value = (lower + upper) / 2;
        TreeNode node = new TreeNode();
        node.left = generateTree2(lower, value - 1);
        node.right = generateTree2(value + 1, upper);
        return node;
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
