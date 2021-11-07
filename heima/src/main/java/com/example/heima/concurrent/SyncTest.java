package com.example.heima.concurrent;

/**
 * @author 赵丙双
 * @since 2021.01.25
 */
public class SyncTest {

    public synchronized void test() {

    }

    public void test1() {
        synchronized (this) {
            System.out.println(this);
        }
    }


    public static void main(String[] args) {

    }

}
