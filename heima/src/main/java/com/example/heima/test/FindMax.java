package com.example.heima.test;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.23
 */
public class FindMax {

    public static Comparable findMax(Comparable[] arr) {
        return null;
    }


    public static Comparable findMax2(List<? extends Comparable> arr) {
        return null;
    }

    public static <T extends Comparable<T>> T findMax3(T[] arr) {
        for (T t : arr) {
            if (t.compareTo(arr[0]) > 0) {
                return arr[0];
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        String[] arr = {};
        Integer[] arr1 = {};
        List<String> list = new ArrayList();

        findMax(arr);
        findMax2(list);
        Integer max3 = findMax3(arr1);



    }

}
