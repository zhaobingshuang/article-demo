package com.example.heima.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class Reducing2 {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};
        Long count = Arrays.stream(arr).collect(Collectors.reducing(0L, e -> 1L, Long::sum));
        Integer count2 = Arrays.stream(arr).collect(Collectors.reducing(0, String::length, (a, b) -> a + 1));
        System.out.println(count);
        System.out.println(count2);
    }
}