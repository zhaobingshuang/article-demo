package com.example.heima.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
//        semaphore.acquire(1);
//        semaphore.acquire(1);
//        semaphore.acquire(1);
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        System.out.println(semaphore.drainPermits());
        System.out.println(semaphore.availablePermits());

    }

}
