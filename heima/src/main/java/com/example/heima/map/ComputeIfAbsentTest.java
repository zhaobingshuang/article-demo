package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ComputeIfAbsentTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k2", null);
        map.put("k3", "c");

        System.out.println(map);

        // k1 不存在，执行 put
        String v1 = map.computeIfAbsent("k1", (k) -> k + k);
        // k2 存在，但值为null，执行 put
        String v2 = map.computeIfAbsent("k2", (k) -> k + k);
        // k3 存在，但值不为null，不执行 put
        String v3 = map.computeIfAbsent("k3", (k) -> k + k);
        // k4 不存在，但计算结果为 null，不执行 put
        String v4 = map.computeIfAbsent("k4", (k) -> null);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println(map);
    }

}
