package com.company.c3;

import com.company.c3.queue.ArrayQueue1;
import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;

import java.util.NoSuchElementException;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.29
 */
public class Q3_33 {

    static class ArrayQueue {

        private final int capacity;

        private final int[] elements;

        private int front;

        private int rear;

        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.elements = new int[capacity];
            this.front = 0;
            this.rear = 0;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }

        public void enqueue(int val) {
            if (isFull()) {
                throw new IllegalStateException();
            }
            elements[rear = (rear + 1) % capacity] = val;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return elements[front = (front + 1) % capacity];
        }

    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
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
