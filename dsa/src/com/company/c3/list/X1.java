package com.company.c3.list;

import com.company.c3.list.Entry;

import java.util.Arrays;

/**
 * 合并多项式 数组
 *
 * @author 赵丙双
 * @since 2021.09.06
 */
public class X1 {

    public static void main(String[] args) {
        Entry[] a1 = {
                Entry.of(26,19),
                Entry.of(-4,8),
                Entry.of(-13,6),
                Entry.of(82,0)
        };
        Entry[] a2 = {
                Entry.of(9,12),
                Entry.of(15,8),
                Entry.of(3,2)
        };
        Entry[] union = union(a1, a2);
        System.out.println(Arrays.toString(union));

    }

    public static Entry[] union(Entry[] a1, Entry[] a2) {
        int length1 = a1.length;
        int length2 = a2.length;
        Entry[] result = new Entry[Integer.sum(length1, length2)];
        int i = 0, j = 0, k = 0;
        for (; i < length1 && j < length2; k++) {
            Entry ai = a1[i];
            Entry aj = a2[j];
            if (ai.expon > aj.expon) {
                result[k] = ai;
                i++;
            } else if (ai.expon < aj.expon) {
                result[k] = aj;
                j++;
            } else {
                result[k] = Entry.of(ai, aj);
                i++;
                j++;
            }
        }

        if (i == length1) {
            for (int s = j; s < length2; s++) {
                result[k++] = a2[s];
            }
        } else {
            for (int s = i; s < length1; s++) {
                result[k++] = a1[s];
            }
        }
        return result;
    }


}
