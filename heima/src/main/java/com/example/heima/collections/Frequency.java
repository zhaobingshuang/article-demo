package com.example.heima.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.17
 */
public class Frequency {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 1, 7, 1,  0, 1, 7);
        System.out.println(Collections.frequency(list, 1));
    }

}
