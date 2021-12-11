package com.example.heima.number;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.11.26
 */
public class Test {

    public static synchronized void a() {

    }

    public static synchronized void b() {

    }

    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap(10,0.75f,true);

        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");

        System.out.println("原始顺序为：");
        for(Iterator<Map.Entry<String,String>> it = map.entrySet().iterator(); it.hasNext();){
            System.out.print(it.next().getKey() + "    ");
        }
        System.out.println();

        map.get("2");

        System.out.println("访问 2 之后的顺序为：");
        for(Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();it.hasNext();){
            System.out.print(it.next().getKey() + "    ");
        }

    }
}
