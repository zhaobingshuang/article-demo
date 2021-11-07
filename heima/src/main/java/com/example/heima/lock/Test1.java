package com.example.heima.lock;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();

//        Thread t1 = new Thread(() -> {
//            log.debug(ClassLayout.parseInstance(o).toPrintable());
//
//            synchronized (o) {
//                log.debug(ClassLayout.parseInstance(o).toPrintable());
//            }
//            log.debug(ClassLayout.parseInstance(o).toPrintable());
//
//
//        }, "t1");
//
//        Thread t2 = new Thread(() -> {
//            log.debug(ClassLayout.parseInstance(o).toPrintable());
//
//            synchronized (o) {
//                log.debug(ClassLayout.parseInstance(o).toPrintable());
//            }
//            log.debug(ClassLayout.parseInstance(o).toPrintable());
//
//        }, "t2");
//
//        Thread t3 = new Thread(() -> {
//            for (int i = 0; i < 1000000; i++) {
//                log.debug(ClassLayout.parseInstance(o).toPrintable());
//
//                synchronized (o) {
//                    log.debug(ClassLayout.parseInstance(o).toPrintable());
//                }
//                log.debug(ClassLayout.parseInstance(o).toPrintable());
//            }
//        }, "t3");
//
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
//        t3.start();
//        t3.join();


        o.notifyAll();


    }

}
