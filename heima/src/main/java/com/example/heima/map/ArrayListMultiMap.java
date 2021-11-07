package com.example.heima.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.26
 */
public class ArrayListMultiMap<K, V> {

    private final Map<K, ArrayList<V>> map;

    public ArrayListMultiMap() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        map.computeIfAbsent(key, (k) -> new ArrayList<>()).add(value);
    }

    public ArrayList<V> get(K key) {
        return map.get(key);
    }

    @Override
    public String toString() {
        return "ArrayListMultiMap{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) {
        ArrayListMultiMap<String, String> multiMap = new ArrayListMultiMap<>();
        multiMap.put("k1", "a");
        multiMap.put("k1", "b");
        multiMap.put("k1", "a");
        multiMap.put("k1", "c");
        multiMap.put("k2", "aa");
        multiMap.put("k2", "bb");
        System.out.println(multiMap);

    }
}