package com.company.c1;

import java.util.LinkedList;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.28
 */
public class Q1_6 {

    public static void main(String[] args) {
        permute("abc");
    }

    private static void permute(String str) {
        permute(str.toCharArray(), 0, str.length() - 1);
    }

    private static void permute(char[] str, int low, int high) {
        if (low == high) {
            System.out.print(str[low]);
            return;
        }

        if (high < low) {
            return;
        }

        for (int i = low; i < high; i++) {
            permute(str, low, i);
            permute(str, i + 1, high);

            permute(str, i + 1, high);
            permute(str, low, i);

            System.out.println();
//            System.out.println();
        }


//        for (int i = low; i < high; i++) {
//            permute(str, i + 1, high);
//            permute(str, low, i);
////            System.out.println();
//        }


//        for (int i = low; i <= high; i++) {
//            System.out.print(str[i]);
//            permute(str, low, i - 1);
//            permute(str, i + 1, high);
//            System.out.println();
//        }
//
//        for (int i = low; i <= high; i++) {
//            permute(str, low, i - 1);
//            permute(str, i + 1, high);
//            System.out.print(str[i]);
//            System.out.println();
//        }

//        for (int i = 0; i < str.length; i++) {
//            permute(str, low, i - 1);
//            System.out.print(str[i]);
//            permute(str, i + 1, high);
//            System.out.println();
//        }


//        if (low == high) {
//            System.out.print(str[low]);
//            return;
//        }
//
//        for (int i = low; i <= high; i++) {
//            for (int j = low; j <= high; j++) {
//                if (i == j) {
////                    continue;
//                }
//                permute(str, i, j);
//            }
//        }
    }

    public static void test(String str) {
        char[] chars = str.toCharArray();

    }
}
