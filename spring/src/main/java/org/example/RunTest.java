package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunTest {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println(1325);
        });

    }
}
