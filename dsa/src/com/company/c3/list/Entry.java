package com.company.c3.list;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.06
 */
public class Entry {

    public int coef;

    public int expon;

    public Entry(int coef, int expon) {
        this.coef = coef;
        this.expon = expon;
    }

    @Override
    public String toString() {
        return "(" + coef +
                ", " + expon +
                ')';
    }

    public static Entry of(int coef, int expon) {
        return new Entry(coef, expon);
    }

    public static Entry of(Entry a, Entry b) {
        return new Entry(a.coef + b.coef, a.expon);
    }
}
