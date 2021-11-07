package com.example.heima.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class Reducing3 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(Person.of("北京", 160));
        list.add(Person.of("北京", 181));
        list.add(Person.of("上海", 179));
        list.add(Person.of("上海", 171));
        list.add(Person.of("深圳", 190));
        list.add(Person.of("深圳", 166));

        Map<String, Integer> map = list.stream().collect(Collectors.groupingBy(Person::getCity,
                Collectors.reducing(0, Person::getHeight,
                    BinaryOperator.maxBy(Comparator.comparing(Function.identity())))));


        System.out.println(map);

        Map<String, Integer> map2 = list.stream().collect(Collectors.groupingBy(Person::getCity,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Person::getHeight)), (op) -> op.orElse(new Person()).getHeight())));


        System.out.println(map2);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Person {

        private String city;

        private int height;

        public static Person of(String city, int height) {
            return new Person(city, height);
        }
    }
}
