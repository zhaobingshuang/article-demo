package com.example.heima.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.01
 */
public class ArrayListItrTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        iterator.remove();
        iterator.remove();

    }

}
