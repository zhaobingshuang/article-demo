package com.company.c3.list;

import java.util.*;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.08
 */
public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;

    private int size;

    public MyArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public void clear() {
        size = 0;
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void trimToSize() {
        ensureCapacity(size);
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            E e;
            if ((e = elements[i]) == element || Objects.equals(e, elements)) {
                return true;
            }
        }
        return false;
    }

    public E get(int idx) {
        rangeCheck(idx);
        return elements[idx];
    }

    public E set(int idx, E element) {
        rangeCheck(idx);
        E old = elements[idx];
        elements[idx] = element;
        return old;
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int idx, E element) {
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= idx; i--) {
            elements[i + 1] = elements[i];
        }
        elements[idx] = element;
        size++;
    }

    private void addAll(Iterable<? extends E> iterable) {
        for (E e : iterable) {
            add(e);
        }
    }

    public E remove(int idx) {
        rangeCheck(idx);
        E old = elements[idx];
        for (int i = idx; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        return old;
    }

    private void ensureCapacity(int newCapacity) {
        if (elements.length >= newCapacity) {
            return;
        }

        E[] old = this.elements;
        this.elements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            elements[i] = old[i];
        }
    }

    private void rangeCheck(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void printList() {
        for (E e : this) {
            System.out.println(e);
        }
        System.out.println("----");
    }



    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }



    private class Itr implements Iterator<E> {

        /**
         * 下一个要被返回的
         */
        int cursor;

        /**
         * 上次返回的
         */
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int lastRet = cursor++;
            return elements[lastRet];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new NoSuchElementException();
            }
            MyArrayList.this.remove(lastRet);
            // 优化
//            cursor--;
            cursor = lastRet;
            lastRet = -1;
        }
    }

    private class ListItr extends Itr implements ListIterator<E> {
        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return elements[lastRet = --cursor];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {
            MyArrayList.this.add(cursor++, e);
        }
    }

    public Iterator<E> reverseIterator() {
        return new ReverseItr();
    }


    private class ReverseItr implements Iterator<E> {

        private int cursor;

        private int lastRet = -1;

        public ReverseItr() {
            this.cursor = size - 1;
        }

        @Override
        public boolean hasNext() {
            return cursor >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[lastRet = cursor--];
        }

        @Override
        public void remove() {
            if (lastRet == -1) {
                throw new NoSuchElementException();
            }
            MyArrayList.this.remove(lastRet);
            lastRet = -1;
        }
    }
}
