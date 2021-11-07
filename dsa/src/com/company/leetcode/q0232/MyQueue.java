package com.company.leetcode.q0232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.30
 */
public class MyQueue {

    private final Deque<Integer> enStack;

    private final Deque<Integer> deStack;

    public MyQueue() {
        this.enStack = new LinkedList<>();
        this.deStack = new LinkedList<>();
    }

    public void push(int x) {
        enStack.push(x);
    }

    public int pop() {
        if (deStack.isEmpty()) {
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
        return deStack.pop();
    }

    public int peek() {
        if (deStack.isEmpty()) {
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
        return deStack.peek();
    }

    public boolean empty() {
        return enStack.isEmpty() && deStack.isEmpty();
    }
}
