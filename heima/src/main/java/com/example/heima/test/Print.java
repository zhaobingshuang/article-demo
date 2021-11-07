package com.example.heima.test;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.23
 */
public class Print {

    public static void main(String[] args) {
        printOut(76234);
        System.out.println("------");
        printOut2(76234);
        System.out.println("------");
        printOut3(76200);
    }

    public static void printOut(int n) {
        System.out.println(n % 10);
        if (n >= 10) {
            printOut(n / 10);
        }
    }

    public static void printOut2(int n) {
        if (n >= 10) {
            printOut2(n / 10);
        }
        System.out.println(n % 10);
    }

    public static void printOut3(int n) {
        for (; ; ) {
            System.out.println(n % 10);
            int a = n / 10;
            if (a > 0) {
                n = a;
            } else {
                return;
            }
        }
    }
}
