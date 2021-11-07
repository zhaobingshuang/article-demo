package com.company.leetcode.q0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现栈的关键在于，让队头是最后插入的元素，且队列中元素是倒序排列的
 *
 * 两个队列，q1存储元素，q2辅助。
 * 先入队到 q2，然后将q1全部出队并入队到q2，然后交换 q1、q2
 *
 * @author 赵丙双
 * @since 2021.09.30
 */
public class MyStack2 {

    /**
     * 存储元素的栈
     */
    private Queue<Integer> queue1;

    /**
     * 辅助的栈
     */
    private Queue<Integer> queue2;

    public MyStack2() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> t = queue1;
        queue1 = queue2;
        queue2 = t;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
