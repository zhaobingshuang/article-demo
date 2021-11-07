//package com.example.heima;
//
//import lombok.extern.slf4j.Slf4j;
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//@Slf4j
//public class HV2 {
//
//    private static final int NEW          = 0;
//    private static final int NORMAL       = 2;
//
//    private static Unsafe UNSAFE;
//
//    private static long stateOffset;
//
//    volatile int state  = NEW;
//
//
//    public void run() {
//        log.info("start: " + state);
//
//        while (state == NEW){}
//
//        log.info("end: " + state);
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//        HV2 hv1 = new HV2();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//        new Thread(hv1::run).start();
//
//        Thread.sleep(1000);
//
//        UNSAFE.putOrderedInt(hv1, stateOffset, NORMAL);
//    }
//
//
//
//
//    static {
//        try {
//
//            Class<?> k = HV2.class;
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            UNSAFE=(Unsafe)field.get(null);
//
//
//            stateOffset=UNSAFE.objectFieldOffset(k.getDeclaredField("state"));
////            nOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("n"));
//
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//            System.err.println(e.getLocalizedMessage());
//        }
//    }
//}
