package com.company.c2;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.31
 */
public class Q2_8 {
    public static int romInt(int i, int j) {
        return 0;
    }


    public static void m1(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            int romInt;
            romInt = romInt(1, n);
            flag:
            for (int j = 0; j < i; j++) {
                // 已存在
                if (arr[j] == romInt) {
                    romInt = romInt(1, n);
                    continue flag;
                }
            }

            arr[i] = romInt;
        }

    }

}
