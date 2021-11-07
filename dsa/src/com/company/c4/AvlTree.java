package com.company.c4;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.26
 */
public class AvlTree<E extends Comparable<? super E>> {

    private TreeNode<E> root;

    public void insert(E value) {
        root = insert(root, value);
    }

    public void remove(E value) {
        root = remove(root, value);
    }

    private TreeNode<E> insert(TreeNode<E> root, E value) {
        if (root == null) {
            return new TreeNode<>(value);
        }

        int compareResult = value.compareTo(root.value);
        if (compareResult > 0) {
            root.right = insert(root.right, value);
        } else if (compareResult < 0) {
            root.left = insert(root.left, value);
        } else {
            ;
        }
        return balance(root);
    }

    private TreeNode<E> remove(TreeNode<E> root, E value) {
        if (root == null) {
            return null;
        }

        int compareResult = value.compareTo(root.value);
        if (compareResult > 0) {
            root.right = remove(root.right, value);
        } else if (compareResult < 0) {
            root.left = remove(root.left, value);
        } else {
            if (root.left != null && root.right != null) {
                // 两个子节点
                root.value = findMin(root.right).value;
                // 必须用 remove，不能用 removeMin
                root.right = remove(root.right, root.value);
            } else {
                root = root.left != null ? root.left : root.right;
            }
        }
        return balance(root);
    }


    private TreeNode<E> balance(TreeNode<E> root) {

        if (height(root.left) - height(root.right) > 1) {
            if (height(root.left.left) > height(root.left.right)) {
                root = rotateWithLeftChild(root);
            } else {
                root = doubleRotateWithLeftChild(root);
            }
        } else if (height(root.right) - height(root.left) > 1) {
            if (height(root.right.right) - height(root.right.left) > 1) {
                root = rotateWithRightChild(root);
            } else {
                root = doubleRotateWithRightChild(root);
            }
        }
        root.height = calculateHeight(root);
        return root;
    }

    private int height(TreeNode<E> root) {
        return root == null ? -1 : root.height;
    }

    private int calculateHeight(TreeNode<E> root) {
        return Integer.max(height(root.left), height(root.right)) + 1;
    }

    private TreeNode<E> rotateWithLeftChild(TreeNode<E> k2) {
        TreeNode<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = calculateHeight(k2);
        k1.height = calculateHeight(k1);
        return k1;
    }

    private TreeNode<E> rotateWithRightChild(TreeNode<E> k2) {
        TreeNode<E> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = calculateHeight(k2);
        k1.height = calculateHeight(k1);
        return k1;
    }

    private TreeNode<E> doubleRotateWithLeftChild(TreeNode<E> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private TreeNode<E> doubleRotateWithRightChild(TreeNode<E> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }


    private TreeNode<E> findMin(TreeNode<E> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

//    private TreeNode<E> removeMin(TreeNode<E> root) {
//        if (root.left == null) {
//            return null;
//        }
//        return removeMin(root.left);
//    }

    private TreeNode<E> removeMin(TreeNode<E> root) {
        if (root.left == null) {
            return null;
        }
        root.left = removeMin(root.left);
        root.height = calculateHeight(root);
        return root;
    }

    private static class TreeNode<E> {
        E value;
        TreeNode<E> left;
        TreeNode<E> right;
        int height;

        public TreeNode(E val) {
            this.value = val;
        }

        public TreeNode(E val, TreeNode<E> left, TreeNode<E> right, int height) {
            this.value = val;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

}
