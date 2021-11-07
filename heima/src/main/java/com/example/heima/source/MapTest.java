package com.example.heima.source;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/27
 */
public class MapTest {

    public static void main(String[] args) {

//        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put(1, null);
//        System.out.println("---");
//        hashtable.put(null, 1);
        System.out.println(1);
        HashMap<Object, Object> map = new HashMap<>(1 << 30);
//        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", "");
        map.put("2", "");
        map.put("3", "");
        map.put("4", "");
        map.put("5", "");
        map.put("6", "");
        map.put("7", "");
        map.put("8", "");
        map.put("9", "");
        map.put("10", "");
        map.put("11", "");
        map.put("12", "");
        map.put("13", "");
        map.put("14", "");
        map.put("15", "");
        map.put("16", "");
        map.put("17", "");

        HashMap<Object, Object> map2 = new HashMap<>(map);

    }

}
