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
public class Joining {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};
        List<String> list = Arrays.asList(arr);

        String s1 = list.stream().collect(Collectors.joining());
        String s2 = list.stream().collect(Collectors.joining(","));
        String s3 = list.stream().collect(Collectors.joining(",", "[", "]"));

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}