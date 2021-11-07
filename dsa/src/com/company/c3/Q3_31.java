package com.company.c3;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class Q3_31 {

    class LinkedStack<E> {

        private Node<E> head;

        public LinkedStack() {

        }

        public void push(E e) {
            head = new Node<>(e, null);
        }

        public E pop() {
            Node<E> node = head;
            head = head.next;
            return node.val;
        }
    }

    static class Node<E> {
        final E val;

        final Node<E> next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
