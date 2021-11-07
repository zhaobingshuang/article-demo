package com.example.heima.bit;

/**
 * @author 赵丙双
 * @since 2021.01.19
 */
public class T1 {

    static final Integer SHARED_SHIFT   = 16;
    static Object o;
    static final Integer SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final Integer MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final Integer EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    public static void main(String[] args) {
//
//        System.out.println(16 >> 1);
//        System.out.println(16 << 1);
//        System.out.println(SHARED_UNIT);
//        System.out.println(MAX_COUNT);
//        System.out.println(EXCLUSIVE_MASK);
//
//        System.out.println(Integer.toBinaryString(SHARED_SHIFT));
//        System.out.println(Integer.toBinaryString(SHARED_UNIT));
//        System.out.println(Integer.toBinaryString(MAX_COUNT));
//        System.out.println(Integer.toBinaryString(EXCLUSIVE_MASK));
//
         o = new Object();
    }

}
