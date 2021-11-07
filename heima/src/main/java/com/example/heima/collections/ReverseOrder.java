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
public class ReverseOrder {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(6, 2, 5, 1, 7);
        List<Integer> list2 = Arrays.asList(6, 2, 5, 1, 7);
        Collections.sort(list1);
        Collections.sort(list2, Comparator.reverseOrder());
        System.out.println(list1);
        System.out.println(list2);
    }
}
