package com.example.heima.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.03
 */
public class Mapping {

    public static void main(String[] args) {
        String[] arr = {"a", "ab", "abc"};

    List<Integer> list = Arrays.stream(arr).collect(
            Collectors.mapping(String::length, Collectors.toList()));

        System.out.println(list);
    }
}
