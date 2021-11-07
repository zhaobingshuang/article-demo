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
public class Checked {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List unCheckedlist = list;
        unCheckedlist.add("a");
        System.out.println("after add");
        // 不会报错
        System.out.println(list.get(0));
        // 会报错
        Integer integer = list.get(0);
        System.out.println(integer);
    }
}
