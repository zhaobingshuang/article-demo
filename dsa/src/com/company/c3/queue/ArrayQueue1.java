package com.company.c3.queue;

/**
 * 没有 size，
 * front == rear 代表空
 * （rear + 1） % capacity = front 代表慢
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class ArrayQueue1<E> {

    private final E[] elements;

    private final int capacity;

    private int front = -1;

    private int rear = -1;

    public ArrayQueue1(int capacity) {
        this.elements = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(E val) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        elements[rear = (rear + 1) % capacity] = val;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return elements[front = (front + 1) % capacity];
    }

    public static void main(String[] args) {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());

        }

    }
}
