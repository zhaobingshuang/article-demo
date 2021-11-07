package com.company.c4;

import java.util.Random;

/**
 * 构造一个有 n 个节点的 BST
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_34 {

    public TreeNode randomTree(int count) {
        return randomTree(1, count);
    }

    public TreeNode randomTree(int lower, int upper) {
        if (lower > upper) {
            return null;
        }

        int randomValue = randomInt(lower, upper);
        TreeNode left = randomTree(lower, randomValue - 1);
        TreeNode right = randomTree(randomValue + 1, upper);
        return new TreeNode(randomValue, left, right);
    }

    private final Random random = new Random();

    private int randomInt(int lower, int upper) {
        return random.nextInt(upper - lower + 1) + lower;
    }

    public static void main(String[] args) {
        Q4_34 q4_34 = new Q4_34();
        System.out.println(q4_34.randomInt(1, 1));


    }
}
