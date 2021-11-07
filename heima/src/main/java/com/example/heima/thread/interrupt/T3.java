package com.example.heima.thread.interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class T3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("开始 while");
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("t1 被打断了");
                    break;
                }
            }

        }, "t-01");

        t1.start();

        Thread.sleep(1000);
        log.debug("打断 t1");
        t1.interrupt();
        log.debug("中断标志: {}", t1.isInterrupted());
    }
}
