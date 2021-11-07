package com.example.heima.thread;

public class PriorityTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int count = 0;
            while (true) {
                System.out.println("t1: " + ++count);
            }

        }, "t1");

        Thread t2 = new Thread(()->{
            int count = 0;
            while (true) {
                System.out.println("\t\t\t t2: " + ++count);
            }

        }, "t2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
    }
}
