package com.example.heima.concurrent.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        constructor();

    }

    public static void main1(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
//        boolean broken = cyclicBarrier.isBroken();
//        int numberWaiting = cyclicBarrier.getNumberWaiting();
//        int parties = cyclicBarrier.getParties();

        Thread t1 = new Thread(() -> {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean broken = cyclicBarrier.isBroken();
            int numberWaiting = cyclicBarrier.getNumberWaiting();
            int parties = cyclicBarrier.getParties();
            log.info("broken: {}", broken);
            log.info("numberWaiting: {}", numberWaiting);
            log.info("parties: {}", parties);
            try {
                int await = cyclicBarrier.await();
                log.info("await: {}", await);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean broken = cyclicBarrier.isBroken();
            int numberWaiting = cyclicBarrier.getNumberWaiting();
            int parties = cyclicBarrier.getParties();
            log.info("broken: {}", broken);
            log.info("numberWaiting: {}", numberWaiting);
            log.info("parties: {}", parties);
            try {
                int await = cyclicBarrier.await();
                log.info("await: {}", await);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "t2");

        Thread t3 = new Thread(() -> {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean broken = cyclicBarrier.isBroken();
            int numberWaiting = cyclicBarrier.getNumberWaiting();
            int parties = cyclicBarrier.getParties();
            log.info("broken: {}", broken);
            log.info("numberWaiting: {}", numberWaiting);
            log.info("parties: {}", parties);
            try {
                int await = cyclicBarrier.await();
                log.info("await: {}", await);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    public static void constructor() throws InterruptedException {
        Runnable barrierAction = ()->{
            log.info("barrierAction");
            int i = 1 / 0;
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, barrierAction);
        Thread t1 = newThread(cyclicBarrier, "t1", 1000);
        Thread t2 = newThread(cyclicBarrier, "t2", 2000);
        Thread t3 = newThread(cyclicBarrier, "t3", 3000);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    public static Thread newThread(CyclicBarrier cyclicBarrier, String name, long millis) {
        return new Thread(() -> {

            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("before await");
            try {
                cyclicBarrier.await();
                log.info("after await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, name);
    }

}
