package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ReplaceTest1 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        // 没有与 key 对应的 value，没有替换，返回 null
        String r1 = map.replace("k", "a");
        System.out.println(map + " " + r1);

        map.put("k", null);
        System.out.println(map);

        // key 已经有对应的值 null 了，替换成功，且返回了旧值 null
        String r2 = map.replace("k", "b");
        System.out.println(map + " " + r2);

        map.put("k", "a");
        System.out.println(map);

        // key 已经有对应的值 a 了，替换成功，且返回了旧值 a
        String r3 = map.replace("k", "c");
        System.out.println(map + " " + r3);
    }
}
