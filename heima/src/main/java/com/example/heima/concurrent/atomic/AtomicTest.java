package com.example.heima.concurrent.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 赵丙双
 * @since 2021.01.26
 */
public class AtomicTest {

    private int i = 0;

    private AtomicInteger atomicI = new AtomicInteger(0);

    private void safeCount() {
        atomicI.incrementAndGet();
    }

    private void count() {
        i++;
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicTest atomicTest = new AtomicTest();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    atomicTest.safeCount();
                    atomicTest.count();
                }
            });
            ts.add(t);
        }

        ts.forEach(Thread::start);

        for (Thread t : ts) {
            t.join();
        }

        System.out.println(atomicTest.atomicI);
        System.out.println(atomicTest.i);
        System.out.println(System.currentTimeMillis()- start);

    }

}
