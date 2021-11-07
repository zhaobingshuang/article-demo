package com.example.heima.concurrent.executor;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {

        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
        Future f = null;
        try {
            f.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

}
