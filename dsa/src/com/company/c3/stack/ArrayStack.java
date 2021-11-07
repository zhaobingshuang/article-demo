package com.company.c3.stack;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class ArrayStack<E> {

    private final E[] elements;

    private int top = -1;

    public ArrayStack(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public void push(E element) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        elements[++top] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return elements[top--];
    }


    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}