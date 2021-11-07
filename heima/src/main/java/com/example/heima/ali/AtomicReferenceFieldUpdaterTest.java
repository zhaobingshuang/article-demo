package com.example.heima.ali;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.23
 */
public class AtomicReferenceFieldUpdaterTest {

    public static void main(String[] args) {
        Count count = new Count();

        CountAtomicIntegerFieldUpdater countUpdater = new CountAtomicIntegerFieldUpdater(count);

        System.out.println(count.value);
        countUpdater.increment();
        System.out.println(count.value);
        countUpdater.increment();
        System.out.println(count.value);
    }

}
