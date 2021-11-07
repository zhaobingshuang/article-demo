package com.company.c3.list;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.08
 */
public class ListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        list.add(0, 12);
        list.printList();
        list.add(0, 16);
        list.add(0, 52);
        list.add(0, 12);
        list.add(0, 34);

        list.printList();

//        Iterator<Integer> reverseIterator = list.reverseIterator();
//        while (reverseIterator.hasNext()) {
//            System.out.println("next：" + reverseIterator.next());;
//            reverseIterator.remove();
//            list.printList();
//        }


        System.out.println("--------------------");

        System.out.println(list.get(3));
        System.out.println("---");
        list.add(2, 0);
        list.printList();

        list.remove(3);
        list.printList();


        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        ListIterator<Integer> listIterator = integers.listIterator(3);
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());


    }

}
