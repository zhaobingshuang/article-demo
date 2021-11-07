package com.example.heima.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * xxx
 * @author 赵丙双
 * @date 2021/4/23
 */
public class T2 {


    public static void main(String[] args) {

            T2.class.notify();
        synchronized (T2.class) {
            T2.class.notify();

        }


        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        writeLock.lock();
        readLock.lock();

        writeLock.unlock();
        System.out.println("end");

    }
}


