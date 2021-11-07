package com.example.heima.ali;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.23
 */
public class CountAtomicIntegerFieldUpdater {

    private static final AtomicIntegerFieldUpdater<Count> UPDATER =
            AtomicIntegerFieldUpdater.newUpdater(Count.class, "value");

    private final Count count;

    public CountAtomicIntegerFieldUpdater(Count count) {
        this.count = count;
    }

    public int increment() {
        return UPDATER.incrementAndGet(count);
    }

    public static void main(String[] args) {
    }
}