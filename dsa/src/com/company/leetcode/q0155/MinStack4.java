package com.company.leetcode.q0155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 辅助栈 + 最小值的哑元
 *
 * @author 赵丙双
 * @since 2021.09.28
 */
public class MinStack4 {

    private final Deque<Integer> valueStack;

    private final Deque<Integer> minStack;

    public MinStack4() {
        valueStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        minStack.push(Integer.min(minStack.peek(), val));
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
