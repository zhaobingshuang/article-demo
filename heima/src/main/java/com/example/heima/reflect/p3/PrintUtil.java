package com.example.heima.reflect.p3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/1
 */
public class PrintUtil {

    public static void main(String[] args) {
        Class<Double> klass = Double.class;
        printClass(klass);
        System.out.println("{");
        printConstructors(klass);
        System.out.println();
        printMethods(klass);
        System.out.println();
        printFields(klass);


        System.out.println("}");
    }

    public static void printClass(Class<?> klass) {
        int modifiers = klass.getModifiers();
        System.out.print(Modifier.toString(modifiers) + klass.getName());

        Class<?> superclass = klass.getSuperclass();
        System.out.println(" extends " + superclass.getName());
    }

    public static void printConstructors(Class<?> klass) {
        Constructor[] constructors = klass.getConstructors();
        for (Constructor constructor : constructors) {
            int modifiers = constructor.getModifiers();

            System.out.print("\t" + Modifier.toString(modifiers) + " " + constructor.getName());
            System.out.print("(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterType.getName());
            }
            System.out.print(");");
            System.out.println();
        }
    }

    public static void printMethods(Class<?> klass) {
        Method[] declaredMethods = klass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers();
            Class<?> returnType = declaredMethod.getReturnType();

            System.out.print("\t" + Modifier.toString(modifiers) + " " + returnType.getName() + " " + declaredMethod.getName());
            System.out.print("(");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterType.getName());
            }
            System.out.print(");");
            System.out.println();
        }
    }

    public static void printFields(Class<?> klass) {
        Field[] declaredFields = klass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            int modifiers = declaredField.getModifiers();
            System.out.println("\t" + Modifier.toString(modifiers) + " " + declaredField.getType().getName() + " " + declaredField.getName() + ";");
        }
    }
}
