package com.example.heima.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            log.debug("开始 t1");

            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.debug("结束 t1");


        }, "t1");
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(1000);
        log.debug("结束 main");
    }
}
