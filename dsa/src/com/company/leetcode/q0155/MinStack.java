package com.company.leetcode.q0155;

/**
 * 最小栈 - 无哑元
 *
 * @author 赵丙双
 * @since 2021.09.28
 */
public class MinStack {

    private Node top;

    public MinStack() {
    }

    public void push(int val) {
        int min;
        if (top == null) {
            min = val;
        } else {
            min = Integer.min(val, top.min);
        }

        top = new Node(val, min, top);
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
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

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-1);
        System.out.println(stack.getMin());

    }
}
