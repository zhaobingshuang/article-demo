package com.example.heima.thread.interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class T4 {

    public static void main(String[] args) throws InterruptedException {
        Thread monitorThread = new Thread(() -> {
            log.debug("开始监控");

            Thread currentThread = Thread.currentThread();
            while (true) {
                if (currentThread.isInterrupted()) {
                    log.debug("清理资源, 退出监控");
                    break;
                }

                log.debug("输出监控信息");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("监控信息睡眠中被打断");
                    e.printStackTrace();
                    currentThread.interrupt();
                }
            }
        }, "monitor");

        monitorThread.start();

        Thread.sleep(7000);
        log.debug("打断监控线程");
        monitorThread.interrupt();


    }

}
