package com.example.heima.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.16
 */
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(6, 5, 2, 1, 7);
        List<Integer> list2 = Arrays.asList(6, 5, 2, 1, 7);
        Collections.sort(list1);
        Collections.sort(list2, Comparator.reverseOrder());
        System.out.println(list1);
        System.out.println(list2);

        System.out.println(Collections.binarySearch(list1, 2));
        System.out.println(Collections.binarySearch(list2, 2, Comparator.reverseOrder()));

        // 插入点为 2，返回值为 -(2) - 1 = -3
        System.out.println(Collections.binarySearch(list1, 3));
        // 插入点为 3，返回值为 -(3) - 1 = -4
        System.out.println(Collections.binarySearch(list2, 3, Comparator.reverseOrder()));
    }
}