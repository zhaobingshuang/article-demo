package com.company.c3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.08
 */
public class Q3_1 {

    public static void printLots(List l, List<Integer> p) {
        Iterator lIterator = l.iterator();
        Iterator<Integer> pIterator = p.iterator();

        int i = -1;
        while (pIterator.hasNext()) {
            Integer index = pIterator.next();

            while (lIterator.hasNext()) {
                Object next = lIterator.next();
                if (index == ++i) {
                    System.out.println(next);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList("auisfkjfauidh".split(""));
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i) + " " + i);
        }

        System.out.println("====");
        List<Integer> p = Arrays.asList(new Integer[]{1, 3, 4, 6});
        printLots(l, p);
    }
}
