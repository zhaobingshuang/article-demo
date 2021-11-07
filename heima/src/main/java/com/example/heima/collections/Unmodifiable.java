package com.example.heima.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.16
 */
public class Unmodifiable {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        list = Collections.unmodifiableList(list);
        list.add(2);
    }
}
