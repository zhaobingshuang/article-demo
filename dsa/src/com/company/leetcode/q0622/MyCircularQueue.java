package com.company.leetcode.q0622;

/**
 * 只有 front、rear
 *
 * front：队头的前一个
 * rear：队尾
 * 满：(rear + 1) % n == front;
 * 空：rear == front;
 * frontIndex = (front + 1) % n;
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class MyCircularQueue {

    private final int[] elements;

    private final int capacity;

    private int front;

    private int rear;

    public MyCircularQueue(int k) {
        this.capacity = k + 1;
        this.elements = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        elements[rear = (rear + 1) % capacity] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(front + 1) % capacity];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[rear];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));

    }
}
