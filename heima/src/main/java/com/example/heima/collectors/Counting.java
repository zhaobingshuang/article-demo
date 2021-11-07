package com.example.heima.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class Counting {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};
        Long count = Arrays.stream(arr).collect(Collectors.counting());
        System.out.println(count);
    }

}
