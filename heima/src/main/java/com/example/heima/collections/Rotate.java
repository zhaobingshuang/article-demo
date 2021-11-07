package com.example.heima.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.16
 */
public class Rotate {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(list1);
        Collections.rotate(list1, 2);
        System.out.println(list1);

        System.out.println(list2);
        Collections.rotate(list2, -2);
        System.out.println(list2);
    }
}
