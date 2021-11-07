package com.example.heima.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/23
 */
@Slf4j
public class T2 {

    public static void main(String[] args) {

        Runnable r = ()->{
            log.info(Thread.currentThread().getName());
            int i = 1 / 0;
        };


        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.execute(r);
//        executorService.execute(r);
//        executorService.execute(r);
//        executorService.execute(r);
//        executorService.execute(r);

        executorService.submit(r);
        executorService.submit(r);
        executorService.submit(r);
        executorService.submit(r);
        executorService.submit(r);

    }

}
