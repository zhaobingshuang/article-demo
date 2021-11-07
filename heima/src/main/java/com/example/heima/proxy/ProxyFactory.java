package com.example.heima.proxy;

import java.lang.reflect.Proxy;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.11
 */
public class ProxyFactory {

    public static void main(String[] args) {

        A a = new A();

        AProxy aProxy = new AProxy(a);


        IA a2 = (IA) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IA.class}, aProxy);


        a2.print();

    }

}
