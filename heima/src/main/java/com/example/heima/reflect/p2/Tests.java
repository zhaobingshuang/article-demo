package com.example.heima.reflect.p2;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class Tests {

    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------------------");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
            if ("read".equalsIgnoreCase(declaredMethod.getName())) {
                System.out.println(declaredMethod.invoke(person));
                System.out.println("===================");
            }

            if ("getName".equalsIgnoreCase(declaredMethod.getName())) {
                System.out.println(declaredMethod.invoke(person));
                System.out.println("===================");
            }

            if ("readABookPercent".equalsIgnoreCase(declaredMethod.getName())) {
                System.out.println(declaredMethod.invoke(person, "Sam"));
                System.out.println(declaredMethod.getReturnType());
                System.out.println(Arrays.toString(declaredMethod.getParameterTypes()));
                System.out.println("===================");
            }

            if ("getAddress".equalsIgnoreCase(declaredMethod.getName())) {
                declaredMethod.setAccessible(true);
                System.out.println(declaredMethod.invoke(person));
                System.out.println("===================");
            }
        }

        System.out.println("--------------------");
        Method readABookPercent = personClass.getDeclaredMethod("readABookPercent", String.class);
        System.out.println(readABookPercent.invoke(person, "唐诗三百首"));

    }

}
