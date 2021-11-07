package com.example.heima.collections;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.17
 */
public class AsLifoQueue {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new LinkedList<>();
        deque1.add(1);
        deque1.add(2);
        deque1.add(3);

        Integer a1 = deque1.remove();
        Integer a2 = deque1.remove();
        Integer a3 = deque1.remove();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println("---");

        Deque<Integer> deque2 = new LinkedList<>();
        Queue<Integer> queue = Collections.asLifoQueue(deque2);

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Integer b1 = queue.remove();
        Integer b2 = queue.remove();
        Integer b3 = queue.remove();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

}
