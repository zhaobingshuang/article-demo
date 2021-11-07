package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ComputeTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "a");
        map.put("k3", null);
        map.put("k4", "d");

        System.out.println(map);

        // function 返回值不为 null，执行 put
        String v1 = map.compute("k1", (k, v) -> k + v);
        // function 返回值不为 null，执行 put
        String v2 = map.compute("k2", (k, v) -> k + v);
        // function 返回值不为 null，执行 put
        String v3 = map.compute("k3", (k, v) -> k + v);
        // function 返回值为 null，执行删除
        String v4 = map.compute("k4", (k, v) -> null);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println(map);
    }
}
