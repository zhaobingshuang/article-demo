package com.company.leetcode.q0155;

/**
 * 最小栈 - 无哑元
 *
 * @author 赵丙双
 * @since 2021.09.28
 */
public class MinStack2 {

    private final Node head;

    public MinStack2() {
        head = new Node(-1, -1, null);
    }

    public void push(int val) {
        Node top = head.next;
        int min;
        if (top == null) {
            min = val;
        } else {
            min = Integer.min(val, top.min);
        }

        head.next = new Node(val, min, top);
    }

    public void pop() {
        head.next = head.next.next;
    }

    public int top() {
        return head.next.val;
    }

    public int getMin() {
        return head.next.min;
    }

    class Node {
        private int val;

        private int min;

        private Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}