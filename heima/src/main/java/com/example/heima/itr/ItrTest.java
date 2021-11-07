package com.example.heima.itr;

import java.util.*;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.13
 */
public class ItrTest {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        ListIterator<Integer> iterator = list.listIterator();
        System.out.println(list);
        iterator.next();
        System.out.println("nextIndex：" + iterator.nextIndex());
        System.out.println("previousIndex：" + iterator.previousIndex());
        iterator.add(0);
        System.out.println(list);
        System.out.println("nextIndex：" + iterator.nextIndex());
        System.out.println("previousIndex：" + iterator.previousIndex());
        System.out.println("next：" + iterator.next());
        System.out.println("previous：" + iterator.previous());
    }

}
