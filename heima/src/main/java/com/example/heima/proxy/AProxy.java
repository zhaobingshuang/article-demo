package com.example.heima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.11
 */
public class AProxy implements InvocationHandler {

    private final A o;

    public AProxy(A o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("before");
        o.print();
        System.out.println("after");
        return null;
    }
}
