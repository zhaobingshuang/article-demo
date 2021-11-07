package com.example.heima.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.06.04
 */
public class Reducing {

    public static void main(String[] args) {


    }


    @Data
    @AllArgsConstructor
    private static class Person {

        private String city;

        private String height;

        public static Person of(String city, String height) {
            return new Person(city, height);
        }
    }

}
