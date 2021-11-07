package com.example.heima.utils;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.06
 */
public class T {

    private static T t;

    private final int a;

    public T(int a) {
        this.a = a;
        synchronized(T.class) {
            t = this;
        }
    }

    public static T get() {
        synchronized(T.class) {
            return t;
        }
    }

    public static void main(String[] args) {
        System.out.println(T.get());;
    }
}
