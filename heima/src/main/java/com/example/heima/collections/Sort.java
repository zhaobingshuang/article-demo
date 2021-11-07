package com.example.heima.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.*;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.16
 */
public class Sort {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(6, 5, 2, 1, 7);
        List<Integer> list2 = Arrays.asList(6, 5, 2, 1, 7);
        sort(list1);
        sort(list2, Comparator.reverseOrder());
        System.out.println(list1);
        System.out.println(list2);
    }
}
