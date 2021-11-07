package com.example.heima.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.16
 */
public class Disjoint {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(2, 3, 4);
        System.out.println(Collections.disjoint(list1, list2));
        System.out.println(Collections.disjoint(list1, list3));
        System.out.println(Collections.disjoint(list2, list3));
    }
}
