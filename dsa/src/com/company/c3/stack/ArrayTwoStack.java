package com.company.c3.stack;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class ArrayTwoStack<E> {

    private final E[] elements;

    private int leftTop;

    private int rightTop;

    public ArrayTwoStack(int capacity) {
        this.elements = (E[]) new Object[capacity];
        leftTop = -1;
        rightTop = capacity;
    }

    public boolean isEmpty(boolean left) {
        if (left) {
            return leftTop == -1;
        } else {
            return rightTop == elements.length;
        }
    }

    public boolean isFull() {
        return leftTop + 1 == rightTop;
    }

    public void push(E element, boolean left) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (left) {
            elements[++leftTop] = element;
        } else {
            elements[--rightTop] = element;
        }
    }

    public E pop(boolean left) {
        if (isEmpty(left)) {
            throw new IllegalStateException();
        }

        if (left) {
            return elements[leftTop--];
        } else {
            return elements[rightTop++];
        }
    }


    public static void main(String[] args) {
    }
}