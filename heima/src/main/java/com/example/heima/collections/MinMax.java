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
public class MinMax {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java SE Development Kit 8u291".split(" "));
        System.out.println(Collections.min(list));
        System.out.println(Collections.min(list, Comparator.comparingInt(String::length)));
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(list, Comparator.comparingInt(String::length)));
    }

}
