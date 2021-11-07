package com.example.heima.lock;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.FieldLayout;

import java.util.SortedSet;

public class Test {

    private boolean b;


//    @Override
//    public int hashCode() {
//        return 1;
//    }

    public static void main(String[] args) throws InterruptedException {
        Test o = new Test();
        ClassLayout classLayout = ClassLayout.parseInstance(o);
//        System.out.println(classLayout.toPrintable());
//
//        synchronized (o) {
//
//            System.out.println(classLayout.toPrintable());
//
//        }
//        System.out.println(classLayout.toPrintable());


//        System.identityHashCode(o);

        Thread t1 = new Thread(() -> {

            System.out.println("------------------------------------------------------------------------------------------------------------------------" +  classLayout.toPrintable());
            synchronized (o) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------" + classLayout.toPrintable());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------------------------------------------------------------------------------------------------------------------------" + classLayout.toPrintable());
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------" + classLayout.toPrintable());
        });

        Thread t2 = new Thread(() -> {
            System.out.println("========================================================================================================================" + classLayout.toPrintable());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                System.out.println("========================================================================================================================" + classLayout.toPrintable());
            }
            System.out.println("123123123");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("========================================================================================================================" + classLayout.toPrintable());
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("----------------------------" + classLayout.toPrintable());

        synchronized (o) {

            System.out.println(classLayout.toPrintable());
        }
        System.out.println(classLayout.toPrintable());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------" + classLayout.toPrintable());


        synchronized (o) {

            System.out.println(classLayout.toPrintable());
        }
        System.out.println(classLayout.toPrintable());
    }


}
