package com.example.heima.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        Thread[] arr = new Thread[4];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 4; i++) {
            arr[i] = new Thread(() -> {
                log.info("start");

                try {
                    cyclicBarrier.isBroken();
                    int await = cyclicBarrier.await();
                    log.info("index: {}", await);
                } catch (Exception e) {
//                    e.printStackTrace();

                    log.error("", e);
                }
                log.info("end");
            }, "t" + i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();

        }


        Thread.sleep(1000);
        arr[2].interrupt();
        Thread.sleep(1000);
        cyclicBarrier.await();
        log.info("end");
    }
}
