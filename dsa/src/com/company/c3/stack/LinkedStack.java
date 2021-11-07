package com.company.c3.stack;

/**
 * 有哑元
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class LinkedStack<E> {

    private final Node<E> dummy = new Node<>(null, null);


    public LinkedStack() {
    }

    public boolean isEmpty() {
        return dummy.next == null;
    }

    public void push(E element) {
        dummy.next = new Node<>(element, dummy.next);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node<E> node = dummy.next;
        dummy.next = node.next;

        return node.value;
    }

    private class Node<E> {
        private E value;

        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}