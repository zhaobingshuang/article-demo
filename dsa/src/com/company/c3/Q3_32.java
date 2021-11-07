package com.company.c3;

import java.util.NoSuchElementException;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class Q3_32 {

    static class LinkedQueue<E> {

        private Node<E> front;

        private Node<E> rear;

        public boolean isEmpty() {
            return front == null;
        }

        public void enqueue(E val) {
            Node<E> node = new Node<>(val);
            if (isEmpty()) {
                front = rear = node;
            } else {
                // 简化为
//                rear= rear.next = node;
                rear.next = node;
                rear = node;
            }
        }

        public E dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Node<E> node = front;
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
            }
            return node.val;
        }


    }

    static class Node<E> {
        final E val;

        Node<E> next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
