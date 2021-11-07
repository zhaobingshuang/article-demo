package com.example.heima.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();

//        timeTasks(9, ()-> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

    }

    public static void timeTasks(int n, final Runnable task) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(n);

        for (int i = 0; i <n; i++) {
            new Thread(()->{
                try {
                    start.await();
                    try {
                        log.info("run");
                        task.run();
                    } finally {
                        end.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t" + i).start();
        }


        start.countDown();
        end.await();
        log.info("main exit");

    }

    public static void test() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);
        System.out.println(cdl.getCount());
        cdl.countDown();
        System.out.println(cdl.getCount());
        cdl.countDown();
        System.out.println(cdl.getCount());
        cdl.countDown();
        System.out.println(cdl.getCount());
        cdl.countDown();
        System.out.println(cdl.getCount());
        cdl.countDown();
        System.out.println(cdl.getCount());
    }

    public static void test1() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        Thread.currentThread().interrupt();
        cdl.await();
    }

    public static void test2() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }

    public static void test3() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        log.info("开始 await");
        boolean b = cdl.await(2, TimeUnit.SECONDS);
        log.info("结束 await, 返回值: {}", b);
    }

    public static void test4() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            try {
                log.info("开始 await");
                boolean b = cdl.await(2, TimeUnit.SECONDS);
                log.info("结束 await, 返回值: {}", b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        Thread.sleep(1000);
        cdl.countDown();
    }

    public static void test5() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        cdl.countDown();
        log.info("开始 await");
        boolean b = cdl.await(2, TimeUnit.SECONDS);
        log.info("结束 await, 返回值: {}", b);
    }

}
