package com.example.heima.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class MyInvocation {

    public static void main(String[] args) {
//        getClassNameTest();
//        getClassTest();
//        getInstanceTest();
        testConstruct();

//        constructGetInstance();
//        constructGetInstanceTest();



    }




    public static void getClassNameTest() {


//        MyInvocation[] myInvocation = new MyInvocation[1];

        MyInvocation myInvocation = new MyInvocation();
        Class<? extends MyInvocation> klass = myInvocation.getClass();
        Package klassPackage = klass.getPackage();

        System.out.println("class: " + klass);
        System.out.println("simpleName: " + klass.getSimpleName());
        System.out.println("name: " + klass.getName());
        System.out.println("CanonicalName: " + klass.getCanonicalName());
        System.out.println("TypeName: " + klass.getTypeName());
        System.out.println("package: " + klassPackage);
    }

    public static void getClassTest() {

        Class<?> invocation1 = null;
        Class<?> invocation2 = null;
        Class<?> invocation3 = null;

        try {
            invocation1 = Class.forName("com.example.heima.reflect.MyInvocation");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        invocation2 = MyInvocation.class;

        invocation3 = new MyInvocation().getClass();

        System.out.println(invocation1);
        System.out.println(invocation2);
        System.out.println(invocation3);
    }

    public static void getInstanceTest() {
        try {
            Class<?> klass = Class.forName("com.example.heima.reflect.MyInvocation$Student");
            Student student = (Student) klass.newInstance();

            student.setAge(9);
            student.setName("Hahs");
            System.out.println(student);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void testConstruct() {
        Class<?> klass = null;
        try {
            klass = Class.forName("com.example.heima.reflect.MyInvocation$Student");
            Constructor<?>[] constructors = klass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
                System.out.println(constructor.getDeclaringClass());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Student student = (Student) klass.newInstance();
    }


    public static void constructGetInstance() {
        try {
            Class<?> klass = Class.forName("com.example.heima.reflect.MyInvocation$Student");
            Constructor<?>[] constructors = klass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
                System.out.println(constructor.getName());
                System.out.println(constructor.getModifiers());
                System.out.println(Arrays.toString(constructor.getParameterTypes()));
                System.out.println(constructor.getParameterCount());

                System.out.println("--------------------------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void constructGetInstanceTest() {
        try {
            Class<?> klass = Class.forName("com.example.heima.reflect.MyInvocation$Student");
            Constructor<?>[] constructors = klass.getConstructors();
            Student student1 = (Student)constructors[0].newInstance(9, "Sam");
            Student student2 = (Student)constructors[1].newInstance("Sam");
            Student student3 = (Student)constructors[2].newInstance(9);
            Student student4 = (Student)constructors[3].newInstance();
            System.out.println(student1);
            System.out.println(student2);
            System.out.println(student3);
            System.out.println(student4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * xxx
     *
     * @author 赵丙双
     * @date 2021/3/31
     */
    static class Student {
        private int age;

        private String name;

        public Student() {
        }

        public Student(int age) {
            this.age = age;
        }

        public Student(String name) {
            this.name = name;
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
