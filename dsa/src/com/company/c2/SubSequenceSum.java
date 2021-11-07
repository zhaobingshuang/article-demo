package com.company.c2;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.29
 */
public class SubSequenceSum {

    public static void main(String[] args) {
        int[] arr = {-2, 11, -4, 13, -5, -2};
        System.out.println(sum2(arr));

    }

    public static int sum1(int[] a) {
        int maxSum = 0;
        // 子序列的开始下标
        for (int i = 0; i < a.length; i++) {

            // 子序列的结束下标
            for (int j = i; j < a.length; j++) {

                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }

            }

        }
        return maxSum;
    }

    public static int sum2(int[] a) {
        int maxSum = 0;
        // 子序列的开始下标
        for (int i = 0; i < a.length; i++) {

            int thisSum = 0;
            // 子序列的结束下标
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }

            }

        }
        return maxSum;
    }

}
