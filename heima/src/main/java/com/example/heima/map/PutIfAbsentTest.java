package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class PutIfAbsentTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("k", null);

        // 没有与 key 对应的 value，返回 null
        String r1 = map.putIfAbsent("k", "a");
        System.out.println(map + " " + r1);


        // key 已经有对应的值 a 了，没有执行 put(k, b)，且返回了当前值 a
        String r2 = map.putIfAbsent("k", "b");
        System.out.println(map + " " + r2);
    }
}
