package com.example.heima.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.17
 */
public class AddAll {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list);
    }

}
