package com.company.c3.list;

import java.util.Objects;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.14
 */
public class SingleList {

    private final Node head;

    private int size;

    public SingleList() {
        this.head = new Node();
    }

    boolean add( Object x ) {
        Node pre = head;
        while (pre.next != null && pre.next.value != x) {
            pre = pre.next;
        }
        // 已存在
        if (pre.next != null) {
            return false;
        }

        pre.next = new Node(x, null);
        size++;
        return true;
    }

    boolean remove(Object x) {
        Node pre = head;
        while (pre.next != null) {
            if (Objects.equals(x, pre.next.value)) {
                pre.next = pre.next.next;
                size--;
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    boolean remove2(Object x) {
        Node pre = head;
        while (pre.next != null && pre.next.value != x) {
            pre = pre.next;
        }

        if (pre.next != null) {
            pre.next = pre.next.next;
            size--;
            return true;
        }

        return false;
    }

    int size(){
        return size;
    }

    void print(){
        Node current = head.next;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    boolean contains( Object x ){
        Node current = head.next;
        while (current != null && current.value != x) {
            current = current.next;
        }

        return current != null;
    }

    static class Node {

        Object value;

        Node next;

        public Node() {
        }

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
