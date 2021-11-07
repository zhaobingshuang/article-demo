package com.example.heima.reflect;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class Student implements AtHome, InSchool {
    public void doHomeWork() {
        System.out.println("I am a student,I am doing homework at home");
    }

    public void attendClasses() {
        System.out.println("I am a student,I am attend class in school");
    }
}