package com.example.heima.atomic;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.07.16
 */
public class T1 {

    static volatile int[] arr = {};

    public static void main(String[] args) {
        arr[0] = 1;

        arr = new int[]{1, 2};

    }


}
