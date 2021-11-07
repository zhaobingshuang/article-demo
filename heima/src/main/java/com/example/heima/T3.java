package com.example.heima;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.13
 */
public class T3 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = integers.iterator();
        iterator.remove();
        iterator.remove();


    }

}
