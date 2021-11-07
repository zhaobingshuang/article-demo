package com.example.heima.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.17
 */
public class NewSetFromMap {

    public static void main(String[] args) {
        HashMap<String, Boolean> map = new HashMap<>();
        System.out.println(map);
        Set<String> set = Collections.newSetFromMap(map);
        set.add("a");
        set.add("b");
        System.out.println(set);

        System.out.println(map);
    }

}
