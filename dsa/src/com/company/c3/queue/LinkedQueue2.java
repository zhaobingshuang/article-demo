package com.company.c3.queue;

/**
 * 有哑元 不知对错
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class LinkedQueue2<E> {

    private Node front;

    private Node rear;

    public LinkedQueue2(int capacity) {
        front = rear = new Node(null, null);
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(E val) {
        Node node = new Node(val);
        rear.next = node;
        rear = node;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        Node node = front.next;

        front.next = front.next.next;

        if (front.next == null) {
            rear = front;
        }
        return node.value;
    }

    private class Node {
        E value;

        Node next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
