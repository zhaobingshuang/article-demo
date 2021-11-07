package com.company.c3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 交集
 *
 * @author 赵丙双
 * @since 2021.09.08
 */
public class Q3_4 {

    public static <T extends Comparable<? super T>> List join(List<T> l1, List<T> l2) {
        Iterator<T> i1 = l1.iterator();
        Iterator<T> i2 = l2.iterator();

        List<T> list = new ArrayList<>();
        T o1 = null, o2 = null;
        if (i1.hasNext() && i2.hasNext()) {
            o1 = nextOrNull(i1);
            o2 = nextOrNull(i2);
        }

        // == null 说明所有元素都处理过了，但是 hashNext() == false 可能最后一个元素还没有处理
//        while (i1.hasNext() && i2.hasNext()) {
        while (o1 != null && o2 != null) {
            if (o1.compareTo(o2) > 0) {
                o2 = nextOrNull(i2);;
            } else if (o1.compareTo(o2) < 0) {
                o1 = nextOrNull(i1);;
            } else {
                list.add(o1);
                o1 = nextOrNull(i1);;
                o2 = nextOrNull(i2);;
            }
        }
        return list;
    }

    public static <T> T nextOrNull(Iterator<T> iterator) {
        return iterator.hasNext() ? iterator.next() : null;
    }

    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] a2 = {2, 4 ,6 ,8, 10};

        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);

        System.out.println(join(l1, l2));
    }

}
