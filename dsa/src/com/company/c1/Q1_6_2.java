package com.company.c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.28
 */
public class Q1_6_2 {

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
            System.out.println(str[i]);
            permute(str, low, i - 1);
            permute(str, i + 1, high);

            System.out.println(str[i]);
            permute(str, i + 1, high);
            permute(str, low, i - 1);

            permute(str, low, i - 1);
            System.out.println(str[i]);
            permute(str, i + 1, high);

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

class Solution {
    List<String> rec;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();

        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();

        backtrack(arr, 0, n, perm);

        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }
}