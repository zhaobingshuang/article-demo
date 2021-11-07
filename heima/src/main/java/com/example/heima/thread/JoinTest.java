package com.example.heima.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinTest {

    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = 10;
            log.debug("end");
        }, "t-01");

        t1.start();

//        t1.join();
        log.debug("a: {}", a);
        log.debug("end");


    }

}
