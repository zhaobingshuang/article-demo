package com.company.leetcode.q0622;

/**
 * 只有 front、size
 *
 * front：队头
 * size：个数
 * 满：size == capacity
 * 空：size == 0
 * frontIndex = front
 * rearIndex = (front + size - 1) % n
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class MyCircularQueue2 {

    private final int[] elements;

    private final int capacity;

    private int front;

    private int size;

    public MyCircularQueue2(int k) {
        this.capacity = k;
        this.elements = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        elements[(rearIndex() + 1) % capacity] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[rearIndex()];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int rearIndex() {
        return (front + size - 1) % capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue2 queue = new MyCircularQueue2(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));

    }
}
