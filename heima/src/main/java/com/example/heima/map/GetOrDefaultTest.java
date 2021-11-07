package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class GetOrDefaultTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", null);
        map.put("k2", "a");

        String v1 = map.getOrDefault("k1", "v1");
        String v2 = map.getOrDefault("k2", "v2");
        String v3 = map.getOrDefault("k3", "v3");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}