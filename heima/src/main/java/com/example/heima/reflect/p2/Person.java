package com.example.heima.reflect.p2;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class Person {
    // 非静态公有无参数
    public void read(){
        System.out.println("reading...");
    }

    // 非静态公有无参数有返回
    public String getName(){
        return "Sam";
    }

    // 非静态公有带参数
    public int readABookPercent(String name){
        System.out.println("read "+name);
        return 80;
    }

    // 私有有返回值
    private String getAddress(){
        return "东方路";
    }

    // 公有静态无参数无返回值
    public static void staticMethod(){
        System.out.println("static public method");
    }

    // 公有静态有参数
    public static void staticMethodWithArgs(String args){
        System.out.println("static public method:"+args);
    }

    // 私有静态方法
    private static void staticPrivateMethod(){
        System.out.println("static private method");
    }
}