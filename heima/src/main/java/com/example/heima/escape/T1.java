package com.example.heima.escape;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;

@Slf4j
public class T1 {

    private int a;

    public T1(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "T1{" +
                "a=" + a +
                '}';
    }

    public synchronized void test() {

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println(T1.this);
                T2.runnable = this;
            }
        };

        T2.register(runnable);

    }

    public final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
//        T1 t1 = new T1(1);
//        t1.test();

        Hashtable h = new Hashtable();

        new Thread(()->{
            log.info("进入");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("进入1");
            h.put("", "");
            log.info("进入2");
        }, "t1").start();


        synchronized (h) {
            log.info("ZHu");

            Thread.sleep(5000);
            log.info("ZHu2");
        }





    }
}

class T2 {

    public static Runnable runnable;

    public static void register(Runnable runnable) {
        T2.runnable = runnable;
    }
}
