package org.example;

public interface Ib extends Ia {

    default boolean a(Object obj) {
        return false;
    }
}
