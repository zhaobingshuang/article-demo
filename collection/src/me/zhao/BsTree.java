package me.zhao;

public class BsTree<T extends Comparable<T>> {

    private Node<T> root;

    public BsTree() {
    }

    public BsTree(T e) {
        this.root = new Node<>(e);
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T e) {
        return contains(e, root);
    }

    private boolean contains(T x, Node<T> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.data);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    public T findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).data;
    }

    public Node<T> findMin(Node<T> t) {
        if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).data;
    }

    public Node<T> findMax(Node<T> t) {
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    private Node<T> insert(T x, Node<T> t) {
        if (t == null) {
            return new Node<>(x);
        }

        int compareResult = x.compareTo(t.data);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {
        }
        return t;
    }

    public void remove(T x) {
        root = remove(x, root);
    }
    private Node<T> remove(T x, Node<T> t) {

        if (t == null) {
            return t;
        }

        int compareResult = x.compareTo(t.data);

        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            Node<T> min = findMin(t);
            t.data = min.data;
            t.right = remove(min.data, t.right);
        } else {
            t = (t.left == null) ? t.right : t.left;
        }

        return t;
    }


    class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(Node<T> left, Node<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}