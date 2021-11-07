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
public class IndexOfSubList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 1, 7, 1, 1,  0, 1, 1, 7);
        List<Integer> target = Arrays.asList(1, 1);

        System.out.println(Collections.indexOfSubList(list, target));
        System.out.println(Collections.lastIndexOfSubList(list, target));
    }
}
