package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ComputeIfPresentTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "a");
        map.put("k3", null);
        map.put("k4", "d");

        System.out.println(map);

        // k1 存在且值不为 null，执行 put
        String v1 = map.computeIfPresent("k1", (k, v) -> k + v);
        // k2 不存在，不执行 put
        String v2 = map.computeIfPresent("k2", (k, v) -> k + v);
        // k3 存在，但值为null，不执行 put
        String v3 = map.computeIfPresent("k3", (k, v) -> k + v);
        // k4 存在，但计算结果为 null，不执行 put
        String v4 = map.computeIfPresent("k4", (k, v) -> null);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println(map);
    }

}
