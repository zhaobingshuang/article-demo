package com.example.heima.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {

        GO go = new GO();

        new Thread(() -> {
            log.info("获取结果");
            Object o = go.get(10000);
            log.info("结果: {}", o);

        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("写入结果");
            go.set(new Object());
        }, "t2").start();


    }

}
