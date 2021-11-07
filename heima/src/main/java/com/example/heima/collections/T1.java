package com.example.heima.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.15
 */
public class T1 {

//    public static void main(String[] args) {
////        List<Integer> integers = new java.util.ArrayList<>(Collections.nCopies(10, 5));
////        Collections.rotate(integers, 5);
//
//        int k = 3;
//        int m = 0;
//        int length = 11;
//        for (int i = 0; m < length; i++) {
//            int t = i;
//
//            do {
//                t = (t + k) % length;
//                m++;
//                System.out.println(t);
//            } while (t != i);
//        }
//
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int n = arr.length;
        for (int cycleStart  = 0, nMove = 0; nMove < n; cycleStart ++) {
            int i  = cycleStart ;
            int displaced = arr[i];
            do {
                i  = (i  + k) % n;
                int tmp = arr[i ];
                arr[i ] = displaced;
                displaced = tmp;
                nMove++;
            } while (i  != cycleStart );
        }
        System.out.println(Arrays.toString(arr));
    }

}
