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
public class Checked2 {

    public static void main(String[] args) {
        List<Integer> list = Collections.checkedList(new ArrayList<>(), Integer.class);
        List unCheckedlist = list;
        // 直接报错
        unCheckedlist.add("a");
        System.out.println("after add");
        System.out.println(list.get(0));
        Integer integer = list.get(0);
        System.out.println(integer);
    }
}
