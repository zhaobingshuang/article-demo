package com.example.heima.collections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.17
 */
public class Singleton {

    public static void main(String[] args) {
        Set<String> set = Collections.singleton("a");
        List<String> list = Collections.singletonList("a");
        Map<String, String> map = Collections.singletonMap("k", "v");
        System.out.println(set);
        System.out.println(list);
        System.out.println(map);

        set.add("b");
    }

}
