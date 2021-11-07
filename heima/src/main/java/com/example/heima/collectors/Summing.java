package com.example.heima.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class Summing {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(Person.of("张三", 18));
        list.add(Person.of("李四", 25));
        list.add(Person.of("王五", 15));

        Integer ageSum = list.stream().collect(Collectors.summingInt(Person::getAge));
        Integer lengthSum = list.stream().collect(Collectors.summingInt((p) -> p.getName().length()));

        System.out.println(ageSum);
        System.out.println(lengthSum);
    }


    @Data
    @AllArgsConstructor
    private static class Person {
        private String name;

        private int age;

        public static Person of(String name, int age) {
            return new Person(name, age);
        }
    }
}
