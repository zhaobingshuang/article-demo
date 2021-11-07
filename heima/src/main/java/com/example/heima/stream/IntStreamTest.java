package com.example.heima.stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.06.27
 */
public class IntStreamTest {

    public static void main(String[] args) {
//        range();
//        map();
//        sum();
//        maxMax();
//        average();
//        summaryStatistics();
//        asXxxStream();
        boxed();
    }

    public static void range() {
        IntStream.range(1, 3).forEach(System.out::println);

        System.out.println();

        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    public static void map() {
        IntStream intStream = IntStream.rangeClosed(1, 3)
                .map(operand -> operand * 2);

        Stream<String> stringStream = IntStream.rangeClosed(1, 3)
                .mapToObj(String::valueOf);

        intStream.forEach(System.out::println);
        System.out.println();
        stringStream.forEach(System.out::println);
    }

    public static void sum() {
        int sum = IntStream.rangeClosed(1, 3).sum();
        System.out.println(sum);
    }

    public static void maxMax() {
        OptionalInt min = IntStream.rangeClosed(1, 3).min();
        OptionalInt max = IntStream.rangeClosed(1, 3).max();
        System.out.println(min);
        System.out.println(max);
    }

    public static void average() {
        OptionalDouble average = IntStream.rangeClosed(1, 4).average();
        System.out.println(average);
    }

    public static void summaryStatistics() {
        IntSummaryStatistics summaryStatistics = IntStream.rangeClosed(1, 4).summaryStatistics();
        System.out.println(summaryStatistics);
    }

    public static void asXxxStream() {
        DoubleStream doubleStream = IntStream.rangeClosed(1, 3).asDoubleStream();
        LongStream longStream = IntStream.rangeClosed(1, 3).asLongStream();

        doubleStream.forEach(System.out::println);
        longStream.forEach(System.out::println);
    }


    public static void boxed() {
        IntStream intStream = IntStream.rangeClosed(1, 3);
        Stream<Integer> boxed = intStream.boxed();

        boxed.forEach(System.out::println);
    }
}