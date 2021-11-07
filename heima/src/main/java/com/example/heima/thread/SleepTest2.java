package com.example.heima.thread;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SleepTest2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("t-01") {
            @Override
            public void run() {
                log.debug("sleep1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("State: {}, isInterrupted: {}", getState(), isInterrupted());
                    log.error("interrupted...", e);
                }
            }
        };
        thread.start();
        Thread.sleep(100);
        log.debug("{}", thread.getState());

        log.debug("interrupt...");
        thread.interrupt();
        log.debug("{}", thread.getState());
            Thread.sleep(2000);
        log.debug("{}", thread.getState());
    }
}
