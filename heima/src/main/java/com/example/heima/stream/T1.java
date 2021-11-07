package com.example.heima.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.29
 */
public class T1 {

    public static void main(String[] args) {
//        empty();
//        of();
//        iterate();
//        generate();
//        concat();
//        builder();
//        filter();
//        map();
//        flatMap();
//        sorted();
//        peek();
//        limit();
//        System.out.println();
//        skip();
//        forEach();

//        toArray();
//        reduceSum();
//        reduceMax();
//        reduceToList();
//        collectToList();
//        min();
//        count();
//        match();
        find();
    }

    public static void empty() {
        Stream.empty().forEach(System.out::println);
    }

    public static void of() {
        Stream.of("a").forEach(System.out::println);
        Stream.of("a", "b", "c").forEach(System.out::println);
    }

    public static void iterate() {
        // 由于是无限的流，所以需要 limit
        Stream.iterate(1, (e) -> e * 2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void generate() {
        // 由于是无限的流，所以需要 limit
        Stream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        Random random = new Random();
        Stream.generate(random::nextInt)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void concat() {
        Stream<String> stream1 = Stream.of("a");
        Stream<String> stream2 = Stream.of("b", "c");

        Stream.concat(stream1, stream2).forEach(System.out::println);
    }


    public static void builder() {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder
                .add("a")
                .add("b")
                .add("c")
                .build();
        stream.forEach(System.out::println);
    }

    public static void filter() {
        Stream.of("java", "python", "javascript")
                .filter((e) -> e.startsWith("j"))
                .forEach(System.out::println);
    }

    public static void map() {
        Stream<Integer> stream1 = Stream.of("java", "python", "javascript")
                .map(String::length);
        stream1.forEach(System.out::println);

        IntStream intStream = Stream.of("java", "python", "javascript")
                .mapToInt(String::length);
        intStream.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    static class Item {
        private String name;

        public static Item of(String name) {
            return new Item(name);
        }
    }

    @Data
    @AllArgsConstructor
    static class Order {
        private List<Item> items;

        public static Order of(Item... items) {
            return new Order(Arrays.asList(items));
        }
    }

    public static void flatMap() {
        Item apple = Item.of("Apple");
        Item banana = Item.of("Banana");
        Item peach = Item.of("Peach");
        Item lemon = Item.of("Lemon");

        Order order1 = Order.of(apple, banana);
        Order order2 = Order.of(peach, lemon);

        List<Order> orders = Arrays.asList(order1, order2);
        Stream<Item> itemStream = orders.stream().flatMap(order -> order.getItems().stream());
        itemStream.forEach(System.out::println);
    }

    public static void distinct() {
        Stream.of("a", "b", "c", "a", "b")
                .distinct()
                .forEach(System.out::println);
    }

    public static void sorted() {
        // 自然序
        Stream.of("sql", "python", "java")
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        // 字符长度
        Stream.of("sql", "python", "java")
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    public static void peek() {

        Item apple = Item.of("Apple");
        Item banana = Item.of("Banana");
        Item peach = Item.of("Peach");
        Item lemon = Item.of("Lemon");
        Stream.of(apple, banana, peach, lemon)
                .filter(e -> e.getName().length() < 6)
                // 打印
                .peek(System.out::println)
                // 修改名称
                .peek(e -> e.setName(e.getName() + "__"))
                .forEach(System.out::println);
    }

    public static void limit() {
        Stream.of("a", "b", "c", "d", "e")
                .limit(3)
                .forEach(System.out::println);
    }

    public static void skip() {
        Stream.of("a", "b", "c", "d", "e")
                .skip(3)
                .forEach(System.out::println);
    }

    public static void forEach() {
        // 串行流
        Stream.of("a", "b", "c", "d", "e")
                .forEach(e -> System.out.print(e + " "));

        System.out.println();

        Stream.of("a", "b", "c", "d", "e")
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();

        // 并行流
        Stream.of("a", "b", "c", "d", "e")
                .parallel()
                .forEach(e -> System.out.print(e + " "));

        System.out.println();

        Stream.of("a", "b", "c", "d", "e")
                .parallel()
                .forEachOrdered(e -> System.out.print(e + " "));
    }

    public static void toArray() {
        Object[] objectArray = Stream.of("a", "b", "c").toArray();

        String[] stringArray1 = Stream.of("a", "b", "c")
                .toArray(length -> {
                    System.out.println(length);
                    return new String[length];
                });

        // 上面可以简化为
        String[] stringArray2 = Stream.of("a", "b", "c").toArray(String[]::new);


        System.out.println(Arrays.toString(objectArray));
        System.out.println(Arrays.toString(stringArray1));
        System.out.println(Arrays.toString(stringArray2));
    }

    public static void reduceSum() {
        // 实现 sum
        Integer sum1 = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);

        Integer sum2 = Stream.of(1, 2, 3).reduce(0, Integer::sum);
        System.out.println(sum1);
        System.out.println(sum2);
    }

    public static void reduceMax() {
        // 实现 max
        Optional<Integer> max1 = Stream.of(1, 2, 3).reduce((a, b) -> Integer.max(a, b));
        Optional<Integer> max2 = Stream.of(1, 2, 3).reduce(Integer::max);

        System.out.println(max1);
        System.out.println(max2);
    }

    public static void reduceToList() {
        // 实现 toList
        List<Integer> result = Stream.of(1, 2, 3)
                .reduce(
                        new ArrayList<>(),
                        (list, e) -> {list.add(e); return list;},
                        (list1, list2) -> {list1.addAll(list2); return list1;}
                );
        System.out.println(result);
    }

    public static void  collectToList() {
        // 实现 toList
        List<Integer> list1 = Stream.of(1, 2, 3)
                . collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );

        List<Integer> list2 = Stream.of(1, 2, 3)
                .collect(Collectors.toList());

        System.out.println(list1);
        System.out.println(list2);
    }

    public static void min() {
        // 自然序
        Optional<String> min = Stream.of("sql", "python", "java")
                .min(Comparator.comparingInt(String::length));

        System.out.println(min);
    }

    public static void count() {
        long count = Stream.of("java", "python", "javascript")
                .filter((e) -> e.startsWith("j"))
                .count();

        System.out.println(count);
    }

    private static void match() {
        boolean anyMatch = Stream.of(1, 2, 3)
                .anyMatch(e -> e > 2);

        boolean allMatch = Stream.of(1, 2, 3)
                .allMatch(e -> e > 0);

        boolean noneMatch = Stream.of(1, 2, 3)
                .noneMatch(e -> e > 0);

        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);
    }

    private static void find() {
        // 串行流
        Optional<Integer> first1 = Stream.of(1, 2, 3)
                .findFirst();

        Optional<Integer> any1 = Stream.of(1, 2, 3)
                .findAny();

        // 并行流
        Optional<Integer> first2 = Stream.of(1, 2, 3)
                .parallel()
                .findFirst();

        Optional<Integer> any2 = Stream.of(1, 2, 3)
                .parallel()
                .findAny();

        System.out.println(first1);
        System.out.println(first2);
        System.out.println(any1);
        System.out.println(any2);
    }
}