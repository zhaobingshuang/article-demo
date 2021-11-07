package com.company.c3.stack;

/**
 * 无哑元
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class LinkedStack2<E> {

    private Node<E> head;


    public LinkedStack2() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(E element) {
        head = new Node<>(element, head);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node<E> node = head;
        head = node.next;

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

        LinkedStack2<Integer> stack = new LinkedStack2<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}