package com.example.heima.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

@Slf4j
public class C1 {

    public static void main(String[] args) {

        new Thread("t1") {
            @Override
            public void run() {
                log.debug("running");
            }
        }.start();

        log.debug("running");




    }

}
