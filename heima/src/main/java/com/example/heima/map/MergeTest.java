package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class MergeTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k2", null);
        map.put("k3", "c");
        map.put("k4", "d");

        System.out.println(map);

        // k1 不存在，执行 put
        String v1 = map.merge("k1", "a", String::concat);
        // k2 存在但值为 null，执行 put
        String v2 = map.merge("k2", "b", String::concat);
        // k3 存在，执行 merge
        String v3 = map.merge("k3", "-c", String::concat);
        // k4 存在，但 function 返回值为 null，执行 删除
        String v4 = map.merge("k4", "c", (oldValue, value) -> null);


        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println(map);
    }
}
