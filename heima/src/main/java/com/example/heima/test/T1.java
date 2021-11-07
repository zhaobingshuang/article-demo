package com.example.heima.test;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.24
 */
public class T1 {

//    Comparable<Super>

    static class Super implements Comparable<Super> {
        @Override
        public int compareTo(Super o) {
            return 0;
        }
    }

//    Comparable<Super>

    static class Sub extends Super{}


    public static void main(String[] args) {
        ArrayList<Super> list1 = new ArrayList<>();
        ArrayList<Sub> list2 = new ArrayList<>();

        binarySearch1(list1, null);
        binarySearch1(list2, null);

//        Comparable<Super>
        binarySearch2(list1, null);

//        Comparable<Super>
//        binarySearch2(list2, null);


    }

//    public static <T> int binarySearch1(List<? extends Comparable<? super T>> list, T key) {
//        return 0;
//    }

    public static <T extends Comparable<? super T>> int binarySearch1(List<T> list, T key) {
        return 0;
    }

    public static <T extends Comparable<T>> int binarySearch2(List<T> list, T key) {
        return 0;
    }
}
