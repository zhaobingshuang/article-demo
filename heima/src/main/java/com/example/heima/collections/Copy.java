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
public class Copy {
    public static void main(String[] args) {
        List<Integer> src = Arrays.asList(6, 5, 2);
        List<Integer> dest1 = Arrays.asList(3, 3, 3, 3, 3);
        List<Integer> dest2 = Arrays.asList(3, 3);
        System.out.println(src);
        System.out.println(dest1);
        System.out.println(dest2);
        // dest1.size() > src.size()，正常否则
        Collections.copy(src, dest1);
        System.out.println(dest1);
        // dest2.size() < src.size()，会报错
        Collections.copy(src, dest2);
        System.out.println(dest2);
    }
}
