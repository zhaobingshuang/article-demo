package com.example.heima.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.03
 */
public class ToCollection {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};
        toCollection(arr);
    }

    public static void toCollection(String[] arr) {
        ArrayList<String> list1 = Arrays.stream(arr).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list1);

        List<String> list2 = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(list2);

        Set<String> set = Arrays.stream(arr).collect(Collectors.toSet());
        System.out.println(set);
    }
}
