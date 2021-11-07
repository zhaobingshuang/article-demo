package com.example.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author 赵丙双
 * @since 2021.01.29
 */
@Slf4j
public class T2 {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            log.info("开始");
            int i = 1 / 0;
            log.info("结束");
        });

    }

}
