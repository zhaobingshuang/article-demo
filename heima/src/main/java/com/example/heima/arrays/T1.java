package com.example.heima.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.19
 */
public class T1 {

    public static void main(String[] args) {
//        sort();
//        sortRange();
//        parallelSort();
//        binarySearch();
//        parallelPrefix();

//        equals();
//        equals1();
//        fill();
//        copyOf();
//        copyOfRange();
//        asList();
//        asList2();
//        hashCode1();
//        hashCode2();
//        deepHashCode1();
//        deepHashCode2();
////
//        toString1();
//        toString2();
//        deepToString1();
//        deepToString2();

//        setAll();
//        parallelSetAll();
//        stream();

        int[] a1 = {1, 2};
        int[] a2 = {3, 4};
        int[] ints = IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).toArray();
        System.out.println(Arrays.toString(ints));

    }


    public static void sort() {
        int[] arr = {9, 4, 1, 8, 6, 7, 2, 3, 5};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }


    public static void sortRange() {
        int[] arr = {9, 4, 1, 8, 6, 7, 2, 3, 5};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, 3, 7);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * ForkJoinPool
     */
    public static void parallelSort() {
        int[] arr = {9, 4, 1, 8, 6, 7, 2, 3, 5};
        System.out.println(Arrays.toString(arr));
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }


    public static void binarySearch() {
        int[] arr = {9, 4, 1, 8, 6, 7, 2, 3, 5};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 4));
    }

    public static void parallelPrefix() {
        int[] arr = {2, 1, 0, 3};
        System.out.println(Arrays.toString(arr));
        Arrays.parallelPrefix(arr, Integer::sum);
        System.out.println(Arrays.toString(arr));
    }

    public static void equals() {
        int[] arr1 = {9, 4, 1, 8, 6, 7, 2, 3, 5};
        int[] arr2 = {9, 4, 1, 8, 6, 7, 2, 3, 5};
        int[] arr3 = {1, 4, 1, 8, 6, 7, 2, 3, 5};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.equals(arr1, arr3));
    }

    public static void equals1() {
        Integer[] arr1 = {9, 4};
        Integer[] arr2 = {9, 4};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));

        Integer[][] arr3 = {{9}, {4}};
        Integer[][] arr4 = {{9}, {4}};
        System.out.println(Arrays.equals(arr3, arr4));
        System.out.println(Arrays.deepEquals(arr3, arr4));
    }

    public static void fill() {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        Arrays.fill(arr1, 6);
        Arrays.fill(arr2, 1, 3, 6);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void copyOf() {
        int[] arr = {9, 4, 1, 8};
        int[] arr1 = Arrays.copyOf(arr, 3);
        int[] arr2 = Arrays.copyOf(arr, 6);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void copyOfRange() {
        int[] arr = {9, 4, 1, 8};
        int[] arr1 = Arrays.copyOfRange(arr, 1, 3);
        int[] arr2 = Arrays.copyOfRange(arr, 1, 6);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void asList() {
        Integer[] arr = {9, 4, 1, 8, 1};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        list.set(0, 4);
        System.out.println(list);
        list.replaceAll((e) -> 2);
        System.out.println(list);
        list.clear();
        list.add(1);
        System.out.println(list);
    }

    public static void asList2() {
        String[] arr = {"a", "b", "c", "a"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        list.set(1, "bbb");
        System.out.println(list);
        list.replaceAll((e) -> e + "1");
        System.out.println(list);
        list.add("d");
        list.remove("d");
        System.out.println(list);
    }



    public static void hashCode1() {
        Integer[] arr1 = {9, 4};
        System.out.println(Arrays.hashCode(arr1));
        System.out.println(Arrays.deepHashCode(arr1));

        Integer[][] arr2 = {{9}, {4}};
        System.out.println(Arrays.hashCode(arr2));
        System.out.println(Arrays.deepHashCode(arr2));
    }
//
//    public static void hashCode2() {
//        Integer[][] arr = {{9}, {4}};
//        System.out.println(Arrays.hashCode(arr));
//    }
//
//    public static void deepHashCode1() {
//        Integer[] arr = {9, 4};
//        System.out.println(Arrays.deepHashCode(arr));
//    }
//
//    public static void deepHashCode2() {
//        Integer[][] arr = {{9}, {4}};
//        System.out.println(Arrays.deepHashCode(arr));
//    }

    public static void toString1() {
        Integer[] arr1 = {9, 4};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.deepToString(arr1));

        Integer[][] arr2 = {{9}, {4}};
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.deepToString(arr2));
    }

    public static void toString2() {
        Integer[][] arr = {{9}, {4}};
        System.out.println(Arrays.toString(arr));
    }

    public static void deepToString1() {
        Integer[] arr = {9, 4};
        System.out.println(Arrays.deepToString(arr));
    }

    public static void deepToString2() {
        Integer[][] arr = {{9}, {4}};
        System.out.println(Arrays.deepToString(arr));
    }

    public static void setAll() {
        int[] arr = {9, 4, 1, 8};
        System.out.println(Arrays.toString(arr));
        Arrays.setAll(arr, (i) -> arr[i] * i);
        System.out.println(Arrays.toString(arr));
    }

    public static void parallelSetAll() {
        int[] arr = {9, 4, 1, 8};
        System.out.println(Arrays.toString(arr));
        Arrays.parallelSetAll(arr, (i) -> arr[i] * i);
        System.out.println(Arrays.toString(arr));
    }

    public static void stream() {
        Integer[] arr = {9, 4, 1, 8};
        System.out.println(Arrays.toString(arr));
        List<String> list = Arrays.stream(arr).filter(e -> e > 5).map(e -> "str: " + e).collect(Collectors.toList());
        System.out.println(list);
    }
}
