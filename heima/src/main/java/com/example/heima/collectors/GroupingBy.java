package com.example.heima.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.03
 */
public class GroupingBy {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(Person.of("北京", "张三"));
        list.add(Person.of("上海", "李四"));
        list.add(Person.of("深圳", "王五"));
        list.add(Person.of("北京", "小明"));
        list.add(Person.of("深圳", "小红"));

        groupingBy(list);
    }

    public static void groupingBy(List<Person> list) {
        Map<String, List<Person>> map1 = list.stream().collect(Collectors.groupingBy(Person::getCity));

        Map<String, Set<Person>> map2 = list.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.toSet()));

        TreeMap<String, Set<Person>> map3 = list.stream().collect(Collectors.groupingBy(Person::getCity, TreeMap::new, Collectors.toSet()));

        TreeMap<String, Set<String>> map4 = list.stream().collect(Collectors.groupingBy(Person::getCity, TreeMap::new, Collectors.mapping(Person::getName, Collectors.toSet())));

        System.out.println(map1.getClass() + " - " + map1);
        System.out.println(map2.getClass() + " - " + map2);
        System.out.println(map3.getClass() + " - " + map3);
        System.out.println(map4.getClass() + " - " + map4);
    }


    @Data
    @AllArgsConstructor
    private static class Person {
        private String city;

        private String name;

        public static Person of(String city, String name) {
            return new Person(city, name);
        }

        @Override
        public String toString() {
            return city + "<=" + name;
        }
    }

}
