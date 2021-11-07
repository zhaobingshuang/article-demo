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
public class Reverse {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 5, 2, 1, 7);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
