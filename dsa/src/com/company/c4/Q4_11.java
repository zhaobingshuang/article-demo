package com.company.c4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.01
 */
public class Q4_11 {


}


class MyTreeSet<E extends Comparable<? super E>> {

    private TreeNode<E> root;

    private int modCount;

    private boolean isEmpty() {
        return root == null;
    }

    private boolean contains(E value) {
        return find(root, value) != null;
    }

    private TreeNode<E> find(TreeNode<E> root, E value) {
        if (root == null) {
            return null;
        }

        int compareResult = value.compareTo(root.value);
        if (compareResult < 0) {
            return find(root.left, value);
        } else if (compareResult > 0) {
            return find(root.right, value);
        } else {
            return root;
        }
    }

    private E findMin() {
        TreeNode<E> node = findMin(root);
        return node == null ? null : node.value;
    }

    private TreeNode<E> findMin(TreeNode<E> root) {
        if (root == null) {
            return null;
        }
        TreeNode<E> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode<E> findMax(TreeNode<E> root) {
        if (root == null) {
            return null;
        } else if (root.right == null) {
            return root;
        } else {
            return findMax(root.right);
        }
    }


    private void insert(E value) {
        root = insert(root, value);
    }

    private TreeNode<E> insert(TreeNode<E> root, E value) {
        if (root == null) {
            modCount++;
            return new TreeNode<E>(value);
        }
        int compareResult = value.compareTo(root.value);
        if (compareResult < 0) {
            root.left = insert(root.left, value);
        } else if (compareResult > 0) {
            root.right = insert(root.right, value);
        } else {}
        return root;
    }

    private void remove(E value) {
        root = remove(root, value);
    }

    private TreeNode<E> remove(TreeNode<E> root, E value) {
        if (root == null) {
            return null;
        }

        int compareResult = value.compareTo(root.value);
        if (compareResult < 0) {
            root.left = remove(root.left, value);
        } else if (compareResult > 0) {
            root.right = remove(root.right, value);
        } else if (root.left != null && root.right != null) {
            root.value = findMin(root.right).value;
            root.right = remove(root.right, root.value);
        } else {
            modCount++;
            TreeNode<E> t = root.left != null ? root.left : root.right;
            t.parent = root.parent;
            root = t;
        }
        return root;
    }

    private TreeNode<E> successor(TreeNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.right != null) {
            TreeNode<E> p = t.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            TreeNode<E> p = t.parent;
            TreeNode<E> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private TreeNode<E> predecessor(TreeNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.left != null) {
            TreeNode<E> p = t.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else {
            TreeNode<E> p = t.parent;
            TreeNode<E> ch = t;
            while (p != null && ch == p.left) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }


    private class Itr implements Iterator<E> {

        int expectedModCount = modCount;

        TreeNode<E> cur = findMin(root);

        TreeNode<E> prev;

        boolean atEnd;

        @Override
        public boolean hasNext() {
            return cur != null && !atEnd;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeNode<E> successor = successor(cur);
            prev = cur;
            if (successor == null) {
                atEnd = true;
            } else {
                cur = successor;
            }
            return prev.value;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (prev == null) {
                throw new IllegalStateException();
            }
            MyTreeSet.this.remove(prev.value);
            prev = null;
        }
    }


    private static class TreeNode<E> {
        E value;
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode(E value, TreeNode<E> parent, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}