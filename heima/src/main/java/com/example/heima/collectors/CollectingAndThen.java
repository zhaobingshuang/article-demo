package com.example.heima.collectors;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class CollectingAndThen {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "a", "b"};

        int size = Arrays.stream(arr).collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));

        System.out.println(size);
    }

}
