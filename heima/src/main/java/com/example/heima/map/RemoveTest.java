package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class RemoveTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", null);
        map.put("k2", "a");
        map.put("k3", "b");
        map.put("k4", "");

        System.out.println(map);

        // value 不同，失败
        boolean b1 = map.remove("k1", "a");
        // value 不同，失败
        boolean b2 = map.remove("k2", "b");
        // value 相同，成功
        boolean b3 = map.remove("k3", "b");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        System.out.println(map);
    }

}
