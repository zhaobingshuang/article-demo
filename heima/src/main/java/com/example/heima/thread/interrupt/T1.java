package com.example.heima.thread.interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class T1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("开始 sleep");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.debug("中断标志: {}", Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }

        }, "t-01");

        t1.start();

        Thread.sleep(1000);
        log.debug("打断 t1");
        t1.interrupt();
        log.debug("中断标志: {}", t1.isInterrupted());
    }
}
