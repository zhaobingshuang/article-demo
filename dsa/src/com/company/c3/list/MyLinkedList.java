package com.company.c3.list;

import java.util.*;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.12
 */
public class MyLinkedList<E> implements Iterable<E> {

    private int size;

    private int modCount;

    private Node<E> beginMarker;

    private Node<E> endMarker;

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        size = 0;
        this.beginMarker = new Node<>();
        this.endMarker = new Node<>(null, beginMarker);
        beginMarker.next = endMarker;
        modCount++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        Node<E> currentNode = beginMarker.next;
        while (currentNode != null) {
            if (Objects.equals(element, currentNode.val)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int indexOf(Object o) {
        int i = 0;
        for (Node<E> currentNode = beginMarker.next; currentNode != endMarker; currentNode = currentNode.next) {
            if (Objects.equals(o, currentNode.val)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Node<E> getNode(E element) {
        Node<E> current = beginMarker.next;
        while (current != endMarker) {
            if (Objects.equals(current.val, element)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public E get(int idx) {
        rangeCheck(idx);
        return getNode(idx).val;
    }

    public Node<E> getNode(int idx) {
        Node<E> current;
        if (idx < (size >>1)) {
        // 前半部分
            current = beginMarker.next;
            // 这里必须是 i < idx 不能是 ==，否则就多走了一步
            for (int i = 0; i < idx; i++) {
                current = current.next;
            }
        } else {
        // 后半部分
            current = endMarker.prev;
            for (int i = size - 1; i > idx; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public E set(int idx, E element) {
        rangeCheck(idx);
        Node<E> node = getNode(idx);
        return set(node, element);
    }

    public E set(Node<E> node, E element) {
        E old = node.val;
        node.val = element;
        return old;
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int idx, E element) {
        rangeCheckForAdd(idx);
        // 由于有 endMarker 节点，所以不需要判断是否要插到 size 位置

        Node<E> node = getNode(idx);
        add(node, element);
    }

    public void add(Node<E> node, E element) {
        // 由于有 endMarker 节点，所以不需要判断是否要插到 size 位置

        Node<E> newNode = new Node<>(element, node.prev, node);
        newNode.prev.next = newNode;
        // 感觉这样写更清晰
//        newNode.next.prev = newNode;

        node.prev = newNode;

        modCount++;
        size++;
    }

    private void addAll(Iterable<? extends E> iterable) {
        for (E e : iterable) {
            add(e);
        }
    }

    public E remove(int idx) {
        rangeCheck(idx);
        Node<E> node = getNode(idx);
        return remove(node);
    }

    public E remove(Node<E> node) {
        E old = node.val;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
        modCount++;
        return old;
    }

    public void removeAll(Iterable<? extends E> items) {
        for (E item : items) {
            Node<E> node;
            if ((node = getNode(item)) != null) {
                remove(node);
            }
        }
    }

    private void rangeCheck(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void printList() {
        for (E e : this) {
            System.out.println(e);
        }
        System.out.println("----");
    }


    @Override
    public Iterator<E> iterator() {
        return new ListItr();
    }

    private class ListItr implements ListIterator<E> {

        int expectedModCount = modCount;

        Node<E> next = beginMarker.next;

        int nextIndex = 0;

        Node<E> lastRet = null;

        @Override
        public boolean hasNext() {
            return next != endMarker;
        }

        @Override
        public E next() {
            checkForComodification();

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastRet = next;
            next = next.next;
            nextIndex++;
            return lastRet.val;
        }

        @Override
        public boolean hasPrevious() {
            return next != beginMarker.next;
        }

        @Override
        public E previous() {
            checkForComodification();

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastRet = next.prev;
            next = next.prev;
            nextIndex--;

            return lastRet.val;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastRet == null) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(lastRet);
            expectedModCount++;
            nextIndex--;
            lastRet = null;
        }

        @Override
        public void set(E e) {
            checkForComodification();
            if (lastRet == null) {
                throw new IllegalStateException();
            }
            lastRet.val = e;
        }

        @Override
        public void add(E e) {
            checkForComodification();
            MyLinkedList.this.add(next, e);
            nextIndex++;
            expectedModCount++;
            lastRet = null;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }


    private static class Node<E> {
        E val;

        Node<E> prev;

        Node<E> next;

        public Node() {
        }

        public Node(E val, Node<E> prev) {
            this.val = val;
            this.prev = prev;
        }

        public Node(E val, Node<E> prev, Node<E> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
