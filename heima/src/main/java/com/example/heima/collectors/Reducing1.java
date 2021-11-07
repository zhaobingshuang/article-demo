package com.example.heima.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class Reducing1 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(Person.of("张三", 18));
        list.add(Person.of("李四", 25));
        list.add(Person.of("王五", 15));

        Optional<Person> min = list.stream().collect(Collectors.reducing(BinaryOperator.minBy(Comparator.comparingInt(Person::getAge))));
        Optional<Person> max = list.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Person::getAge))));

        System.out.println(min);
        System.out.println(max);
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
