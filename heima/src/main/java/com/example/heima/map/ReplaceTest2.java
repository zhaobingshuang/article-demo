package com.example.heima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ReplaceTest2 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("k1", "a");
        map.put("k2", "b");
        System.out.println(map);

        // k3 不存在，替换失败
        boolean r1 = map.replace("k3", "c", "ccc");
        System.out.println(map + " " + r1);

        // k1 存在，但值不等于 aa，替换失败
        boolean r2 = map.replace("k1", "aa", "aaa");
        System.out.println(map + " " + r2);

        // k2 存在，且值等于 b，替换成功
        boolean r3 = map.replace("k2", "b", "bbb");
        System.out.println(map + " " + r3);
    }
}
