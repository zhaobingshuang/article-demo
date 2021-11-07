package com.example.heima.collections;

import java.util.*;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.16
 */
public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 2, 5, 1, 7);
        Enumeration<Integer> enumeration = Collections.enumeration(list);
        ArrayList<Integer> list2 = Collections.list(enumeration);
        System.out.println(list2);
    }
}
