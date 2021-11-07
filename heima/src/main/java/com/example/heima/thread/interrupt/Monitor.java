package com.example.heima.thread.interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Monitor {

    private final Thread t;

    public Monitor(Thread t) {
        this.t = t;
        this.t.start();
    }

    public static Monitor start() {
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
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.debug("监控信息睡眠中被打断");
                    e.printStackTrace();
                    // 设置打断标志
                    currentThread.interrupt();
                }
            }
        }, "monitor");

        return new Monitor(monitorThread);
    }

    public void stop() {
        t.interrupt();
    }


    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = Monitor.start();

        Thread.sleep(3500);
        log.debug("打断监控线程");
        monitor.stop();

    }
}
