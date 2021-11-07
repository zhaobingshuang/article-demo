package com.company.c1;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.28
 */
public class Q1_5 {

    public static int ones1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return ones1(n / 2);
        } else {
            return ones1(n / 2) + 1;
        }
    }

    public static int ones2(int n) {
        if (n == 0) {
            return 0;
        }
        return ones1(n / 2) + n % 2;
    }

    public static void main(String[] args) {
        System.out.println(ones2(1));
        System.out.println(ones2(2));
        System.out.println(ones2(3));
        System.out.println(ones2(10));


    }

}
