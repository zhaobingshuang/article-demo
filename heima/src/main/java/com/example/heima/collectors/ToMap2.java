package com.example.heima.collectors;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.03
 */
public class ToMap2 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(Person.of("张三", "北京"));
        list.add(Person.of("李四", "上海"));
        list.add(Person.of("李四", "深圳"));
        toMap(list);
    }

    public static void toMap(List<Person> list) {
        Map<String, String> map1 = list.stream().collect(Collectors.toMap(Person::getName, Person::getAddress));
        Map<String, String> map2 = list.stream().collect(Collectors.toMap(Person::getName, Person::getAddress,
                (v1, v2) -> v1 + " " + v2));
        Map<String, String> map3 = list.stream().collect(Collectors.toMap(Person::getName, Person::getAddress,
                (v1, v2) -> v1 + " " + v2, TreeMap::new));

        System.out.println(map1.getClass() + " - " + map1);
        System.out.println(map2.getClass() + " - " + map2);
        System.out.println(map3.getClass() + " - " + map3);

    }

    @Data
    static class Person {
        private String name;

        private String address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public static Person of(String name, String address) {
            return new Person(name, address);
        }
    }
}
