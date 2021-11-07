package com.company.leetcode.q0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现栈的关键在于，让队头是最后插入的元素，且队列中元素是倒序排列的
 *
 * 单个队列，每次入队后旋转，将刚入队的元素推到队头
 *
 * @author 赵丙双
 * @since 2021.09.30
 */
public class MyStack {

    private final Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
