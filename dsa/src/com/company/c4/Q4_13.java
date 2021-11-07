package com.company.c4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.04
 */
public class Q4_13 {
    static class TreeSet<E extends Comparable<? super E>> {

        private TreeNode<E> root;

        int modCount;

        private TreeNode<E> findMin(TreeNode<E> root) {
            if (root == null) {
                return null;
            }

            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        private void insert(E value) {
            root = insert(root, value, null, null);
        }

        private TreeNode<E> insert(TreeNode<E> root, E value, TreeNode<E> prev, TreeNode<E> next) {
            if (root == null) {
                TreeNode<E> node = new TreeNode<>(value, prev, next);
                if (prev != null) {
                    prev.next = node;
                }

                if (next != null) {
                    next.prev = node;
                }

                return node;
            }

            int compareResult = value.compareTo(root.value);
            if (compareResult < 0) {
                root.left = insert(root.left, value, prev, root);
            } else if (compareResult > 0) {
                root.right = insert(root.right, value, root, next);
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
            } else {
                if (root.left != null && root.right != null) {
                    root.value = findMin(root.right).value;
                    root.right = remove(root.right, root.value);
                } else {
                    // 链表的删除
                    if (root.prev != null) {
                        root.prev.next = root.next;
                    }
                    if (root.next != null) {
                        root.next.prev = root.prev;
                    }
                    root = root.left != null ? root.left : root.right;

                }
            }
            return root;
        }


        class Itr implements Iterator<E> {

            TreeNode<E> cur = findMin(root);
            TreeNode<E> prev;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                TreeNode<E> prev = cur;
                cur = cur.next;
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
                TreeSet.this.remove(root, prev.value);
                prev = null;
            }
        }


        static class TreeNode<E> {

            E value;
            TreeNode<E> left;
            TreeNode<E> right;
            TreeNode<E> prev;
            TreeNode<E> next;

            public TreeNode(E value) {
                this.value = value;
            }

            public TreeNode(E value, TreeNode<E> prev, TreeNode<E> next) {
                this.value = value;
                this.prev = prev;
                this.next = next;
            }

            public TreeNode(E value, TreeNode<E> left, TreeNode<E> right, TreeNode<E> prev, TreeNode<E> next) {
                this.value = value;
                this.left = left;
                this.right = right;
                this.prev = prev;
                this.next = next;
            }
        }

    }

}


