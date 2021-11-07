//package com.example.heima;
//
//import lombok.extern.slf4j.Slf4j;
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//@Slf4j
//public class HV1<V> {
//
//    private static final int NEW          = 0;
////    private static final int COMPLETING   = 1;
//    private static final int NORMAL       = 2;
////    private static final int EXCEPTIONAL  = 3;
////    private static final int CANCELLED    = 4;
////    private static final int INTERRUPTING = 5;
////    private static final int INTERRUPTED  = 6;
//
//    private static Unsafe UNSAFE;
//
//    private static long stateOffset;
//
//    volatile int state;
//
//    V outcome;
//
//    public HV1(V outcome) {
//        this.state = NEW;
//        this.outcome = outcome;
//    }
//
//    protected void set(V v) {
//        outcome = v;
//        UNSAFE.putOrderedInt(this, stateOffset, NORMAL); // final state
//    }
//
//
//    public void run() {
//
//        log.info("start: " + state + " " + outcome);
//        while (state == NEW) {
////            System.out.println("1   " + state);
////            System.out.println("2   " + UNSAFE.getInt(this, stateOffset));
////            System.out.println("3   " + UNSAFE.getIntVolatile(this, stateOffset));
//        }
//        log.info("end: " + state + " " + outcome);
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        HV1<Integer> hv1 = new HV1<>(100);
//        new Thread(hv1::run).start();
//
//        Thread.sleep(1000);
//
//        hv1.set(200);
//
////        hv1.outcome = 200;
////        UNSAFE.putOrderedInt(hv1, stateOffset, 0);
////        UNSAFE.putIntVolatile(hv1, stateOffset, 0);
//
//        log.info("1   " + hv1.state);
//        log.info("2   " + UNSAFE.getInt(hv1, stateOffset));
//        log.info("3   " + UNSAFE.getIntVolatile(hv1, stateOffset));
//
//    }
//
//
//
//
//    static {
//        try {
//
//            Class<?> k = HV1.class;
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
