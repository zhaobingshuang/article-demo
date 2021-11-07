package com.example.heima.other;

import java.util.Arrays;

public class T {

    public static void test(Object... args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        test();
        test(new Object[0]);
        test(null);
        test(null, null);
        test(new Object());
        test(new Object(), new Object());
        test(new Object[0]);
        test(new Object[]{null});
        test(new Object[]{new Object()});
    }
}