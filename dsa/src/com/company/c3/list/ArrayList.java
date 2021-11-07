package com.company.c3.list;

import java.util.Arrays;
import java.util.Objects;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.06
 */
public class ArrayList<E> implements MyList<E> {

    private Object[] elements;

    private int size;

    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    @Override
    public int find(E element) {
        int i = 0;
        while (i < size && !Objects.equals(element, elements[i])) {
            i++;
        }
        return i < size ? i : -1;
    }

    @Override
    public void insert(int index, E element) {
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public void remove(E element) {
        remove(find(element));

    }

    private void remove(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    @Override
    public E findKth(int index) {
        return (E) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList() {
        System.out.println(Arrays.toString(elements));
    }

    public static void main(String[] args) {
        MyList<Integer> list = new ArrayList<>(10);
        list.insert(0, 12);
        list.insert(0, 16);
        list.insert(0, 52);
        list.insert(0, 12);
        list.insert(0, 34);

        list.printList();

        System.out.println(list.find(52));
        list.insert(2, 0);
        list.printList();

        list.remove(52);
        list.printList();

    }
}
