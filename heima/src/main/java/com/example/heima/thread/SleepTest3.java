package com.example.heima.thread;

public class SleepTest3 {

    public static void main(String[] args) {

        Thread thread = new Thread() {

            @Override
            public void run() {
            Thread.currentThread().interrupt();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            System.out.println("interrupt");
//            thread.interrupt();
        }
    }

}
