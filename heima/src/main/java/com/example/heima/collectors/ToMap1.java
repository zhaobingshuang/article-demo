package com.example.heima.collectors;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.03
 */
public class ToMap1 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
//        list.add(Person.of("张三", "北京"));
//        list.add(Person.of("李四", "上海"));
//        list.add(Person.of("王五", "深圳"));

        list.add(Person.of("张三", "北京"));
        list.add(Person.of("李四", "上海"));
        list.add(Person.of("李四", "深圳"));

        toMap(list);
    }

    public static void toMap(List<Person> list) {
        Map<String, String> map1 = list.stream().collect(Collectors.toMap(
                Person::getName, Person::getAddress, (v1, v2) -> v1 + " " + v2, TreeMap::new));

        Map<String, String> map2 = list.stream().collect(Collectors.toMap(
                Person::getName, Person::getAddress, (v1, v2) -> v1 + " " + v2));

        System.out.println(map1.getClass() + " - " + map1);
        System.out.println(map2.getClass() + " - " + map2);

        Map<String, String> map3 = list.stream().collect(Collectors.toMap(
                Person::getName, Person::getAddress));
        System.out.println(map3.getClass() + " - " + map3);
    }

    @Data
    private static class Person {
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
