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
public class ReplaceAll {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, null, 2, 5, 2, null);
        System.out.println(list);
        Collections.replaceAll(list, 2, 0);
        System.out.println(list);
        Collections.replaceAll(list, null, 9);
        System.out.println(list);
    }
}
