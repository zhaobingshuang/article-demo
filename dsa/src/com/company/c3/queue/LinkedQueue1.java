package com.company.c3.queue;

/**
 * 有哑元 不知对错
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class LinkedQueue1<E> {

    private Node front;

    private Node rear;

    public LinkedQueue1() {
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(E val) {
        Node node = new Node(val);
        if (front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        Node node = front;
        if (front == rear) {
            // 只有一个元素，清空队列
            front = rear = null;
        } else {
            front = front.next;
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
