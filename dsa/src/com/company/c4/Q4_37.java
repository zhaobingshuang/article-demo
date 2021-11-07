package com.company.c4;

/**
 * 构造高度为 h 的最少节点的 AVL 树
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_37 {

    public void printRange(TreeNode root, int lower, int upper) {
        if (root == null) {
            return;
        }
        // 比下界小
        if (root.value < lower) {
            printRange(root.right, lower, upper);

        } else if (root.value > upper) {
            printRange(root.left, lower, upper);
        } else {
            System.out.println(root.value);
            printRange(root.left, lower, upper);
            printRange(root.right, lower, upper);
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Q4_34().randomTree(20);


        Q4_37 q4_37 = new Q4_37();
//        q4_37.inOrder(treeNode);
                q4_37.printRange(treeNode, 16, 70);

    }
}
