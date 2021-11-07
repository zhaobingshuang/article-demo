package com.example.heima.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class PartitioningBy {

    public static void main(String[] args) {
        String[] arr = {"a", "bb", "ccc", "dddd", "eeeee"};
        Map<Boolean, List<String>> map1 = Arrays.stream(arr).collect(Collectors.partitioningBy(e -> e.length() > 2));

        Map<Boolean, Set<String>> map2 = Arrays.stream(arr).collect(Collectors.partitioningBy(e -> e.length() > 2, Collectors.toSet()));

        System.out.println(map1);
        System.out.println(map2);
    }

}
