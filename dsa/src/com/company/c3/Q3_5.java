package com.company.c3;

import java.util.*;
import java.util.ArrayList;

/**
 * 交集
 *
 * @author 赵丙双
 * @since 2021.09.08
 */
public class Q3_5 {

    public static <T extends Comparable<? super T>> List<T> union(List<T> l1, List<T> l2) {
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
                list.add(o2);
                o2 = nextOrNull(i2);
            } else if (o1.compareTo(o2) < 0) {
                list.add(o1);
                o1 = nextOrNull(i1);
            } else {
                list.add(o1);
                o1 = nextOrNull(i1);
                o2 = nextOrNull(i2);
            }
        }

        if (o1 == null) {
            list.add(o2);
            while (i2.hasNext()) {
                list.add(i2.next());
            }
        } else {
            list.add(o1);
            while (i1.hasNext()) {
                list.add(i1.next());
            }
        }
        return list;
    }

    public static <T> T nextOrNull(Iterator<T> iterator) {
        return iterator.hasNext() ? iterator.next() : null;
    }

    public static void main(String[] args) {
        Integer[] a1 = {1, 3, 5, 6, 7, 8, 12, 13};
        Integer[] a2 = {2, 4 ,6 ,8, 10, 20};

        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);

        System.out.println(union(l1, l2));

//        ArrayList<Integer> list = new ArrayList<>();
//        union(l1, l2, list);
//        System.out.println(list);
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void union(List<AnyType> L1, List<AnyType> L2,
               List<AnyType> Result)
    {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1=null, itemL2=null;
// get first item in each list
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        while ( itemL1 != null && itemL2 != null )
        {
            int compareResult = itemL1.compareTo(itemL2);
            if ( compareResult == 0 )
            {
                Result.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null;
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            } else if ( compareResult < 0 )
            {
                Result.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null;
            }
            else
            {
                Result.add(itemL2);
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            }
        }
    }
}
