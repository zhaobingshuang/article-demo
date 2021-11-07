package com.company.leetcode.q0155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 辅助栈
 *
 * @author 赵丙双
 * @since 2021.09.28
 */
public class MinStack3 {

    private final Deque<Integer> valueStack;

    private final Deque<Integer> minStack;

    public MinStack3() {
        valueStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int val) {
        Integer top = minStack.peek();
        if (top == null) {
            minStack.push(val);
        } else {
            minStack.push(Integer.min(top, val));
        }

        valueStack.push(val);

    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
