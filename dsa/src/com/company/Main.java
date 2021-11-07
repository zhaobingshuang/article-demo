package com.company;

/**
 * 输出整数
 */
public class Main {

    public static void main(String[] args) {
        print2(123456);
    }

    public static void print(int n) {
        if (n < 10) {
            printD(n);
        } else {
            printD(n % 10);
            print(n / 10);
        }
    }

    public static void printD(int n) {
        System.out.println(n);
    }

    public static void print2(int n) {
        if (n < 10) {
            printD(n);
        } else {
            print2(n / 10);
            printD(n % 10);
        }
    }

    public static void print3(int n) {
        if (n >= 10) {
            print3(n / 10);
        }
        printD(n % 10);
    }
}