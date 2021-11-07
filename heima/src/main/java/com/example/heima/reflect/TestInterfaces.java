package com.example.heima.reflect;

import java.lang.reflect.Method;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class TestInterfaces {

    public static void main(String[] args) {
        try {
            Class<?> klass = Class.forName("com.example.heima.reflect.Student");
            Class<?>[] interfaces = klass.getInterfaces();

            Student student = (Student)klass.newInstance();


            for (Class<?> interfac :interfaces){
                System.out.println(interfac);
                Method[] methods = interfac.getMethods();
                Method[] declaredMethods = interfac.getDeclaredMethods();

                for (Method method : methods) {
                    System.out.println(method);

                    method.invoke(student, null);
                }

                for (Method declaredMethod : declaredMethods) {
                    System.out.println(declaredMethod);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
