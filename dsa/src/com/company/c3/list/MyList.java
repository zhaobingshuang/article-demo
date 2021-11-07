package com.company.c3.list;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.06
 */
public interface MyList<E> {

//    makeEmpty

    int find(E element);

    void insert(int index, E element);

    void remove(E element);

    E findKth(int index);

    int size();

    void printList();
}
