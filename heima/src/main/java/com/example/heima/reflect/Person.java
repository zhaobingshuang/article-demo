package com.example.heima.reflect;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class Person {

    public static String type ;

    private static String subType ;

    // 名字（公开）
    public String name;

    protected String gender;

    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}