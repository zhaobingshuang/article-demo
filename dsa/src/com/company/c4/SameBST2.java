package com.company.c4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 小白专场：判断树是否相同 - 一棵树
 *
 * @author 赵丙双
 * @since 2021.10.27
 */
public class SameBST2 {

    public boolean isSameBST(List<Integer> t1, List<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        // 节点数不同
        if (t1.size() != t2.size()) {
            return false;
        }

        // 两个树都为空
        if (t1.isEmpty()) {
            return true;
        }

        BST tree1 = BST.buildTree(t1);
        return isSameBST(tree1, t2);
    }

    public boolean isSameBST(BST t1, List<Integer> t2) {
        LinkedList<BST.TreeNode> stack = new LinkedList<>();
        BST.TreeNode root = t1.root;
        for (Integer value : t2) {
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    if (root.value != value && !root.visited) {
                        return false;
                    } else if (root.value == value) {
                        root.visited = true;
                    }
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
            }
        }
        return true;
    }

    public boolean check(BST t1, List<Integer> t2) {

        return true;
    }

    public boolean check(BST.TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            root.visited = true;
            return true;
        } else if (!root.visited) {
            return false;
        } else {
            if (value > root.value) {
                return check(root.right, value);
            } else {
                return check(root.left, value);
            }
        }
    }

    /**
     * 视频上的方式
     */
    public boolean check2(BST.TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.visited) {
            if (value > root.value) {
                return check(root.right, value);
            } else if (value < root.value) {
                return check(root.left, value);
            } else {
                return true;
            }
        } else {
            if (value == root.value) {
                root.visited = true;
                return true;
            } else {
                return false;
            }
        }
    }

    private static class BST {

        private TreeNode root;

        public BST() {
        }

        private void insert(int value) {
            root = insert(root, value);
        }

        private TreeNode insert(TreeNode root, int value) {
            if (root == null) {
                return new TreeNode(value);
            }

            if (value > root.value) {
                root.right = insert(root.right, value);
            } else {
                root.left = insert(root.left, value);
            }
            return root;
        }

        private static BST buildTree(List<Integer> nodes) {
            BST bst = new BST();
            nodes.forEach(bst::insert);
            return bst;
        }

        private class TreeNode {
            int value;
            TreeNode left;
            TreeNode right;
            boolean visited;

            public TreeNode(int value) {
                this.value = value;
            }

            public TreeNode(int value, TreeNode left, TreeNode right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }
        }
    }
}
