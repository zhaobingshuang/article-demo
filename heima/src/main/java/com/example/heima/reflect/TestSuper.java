package com.example.heima.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class TestSuper {

    public static void main(String[] args) {

        try {
            Class<?> dogClass = Class.forName("com.example.heima.reflect.Dog");
            System.out.println(dogClass);
            invoke(dogClass);

            Class<?> animalClass = dogClass.getSuperclass();
            System.out.println(animalClass);
            invoke(animalClass);

            Class<?> objectClass = animalClass.getSuperclass();
            System.out.println(objectClass);
            invoke(objectClass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void invoke(Class<?> klass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = klass.getMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println(method);
            if ("doSomething".equalsIgnoreCase(method.getName())) {
                method.invoke(klass.newInstance(), null);
            }
        }
        System.out.println("--------------------------");
    }

}
