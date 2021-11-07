package com.example.heima.collections;

import java.util.Collections;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.17
 */
public class NCopies {
    public static void main(String[] args) {
        List<String> list = Collections.nCopies(3, "a");
        System.out.println(list);
    }

}
