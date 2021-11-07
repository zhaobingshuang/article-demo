package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ForEachTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", null);
        map.put("k2", "a");
        map.put("k3", "b");
        map.put("k4", "");

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
