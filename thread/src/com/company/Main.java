package com.company;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static volatile AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new SynchronousQueue<>());

        Runnable task = () -> {
            System.out.println(num.incrementAndGet());
            try {
                Thread.sleep(10000000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);

//        threadPoolExecutor.shutdown();


        // write your code here
        System.out.println("final");
    }
}
