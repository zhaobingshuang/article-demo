package com.example.heima.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class Test1 {
    public static void main(String[] args) throws IOException {
//        constructor();
//        load();
//        setProperty();
//        getProperty();
//        propertyNames();
//        store();
//        list();
//        loadFromXML();
        storeToXML();
    }







    public static void constructor() {
        Properties prop = new Properties();
        Properties propWithDefault = new Properties(defaults());
        System.out.println("id: " + prop.getProperty("id"));
        System.out.println("id: " + propWithDefault.getProperty("id"));
    }

    public static Properties defaults() {
        Properties properties = new Properties();
        properties.setProperty("id", "100");
        return properties;
    }

    public static void load() throws IOException {
        Properties prop = new Properties();
//        prop.load(Test1.class.getResourceAsStream("/test.properties"));
        prop.load(new InputStreamReader(Test1.class.getResourceAsStream("/test.properties"), "UTF-8"));

        prop.forEach((k, v)-> System.out.println(k + "=" + v));
    }

    public static void setProperty() {
        Properties prop = new Properties();
        Object old1 = prop.setProperty("id", "100");
        Object old2 = prop.setProperty("id", "200");
        System.out.println("old1: " + old1);
        System.out.println("old2: " + old2);
        System.out.println("id: " + prop.get("id"));
    }

    public static void getProperty() {
        Properties prop = new Properties();
        String id = prop.getProperty("id");
        String idWithDefault = prop.getProperty("id", "NO123");

        System.out.println("id: " + id);
        System.out.println("idWithDefault: " + idWithDefault);
    }

    public static void propertyNames() {
        Properties prop = new Properties(defaults());
        prop.setProperty("name", "tom");
        prop.setProperty("age", "18");
        // 放入一个非 String 的键
//        prop.put(new Object(), "");


        System.out.println("--stringPropertyNames--");
        Set<String> keys = prop.stringPropertyNames();
        keys.forEach(System.out::println);


        System.out.println("--propertyNames--");
        Enumeration<?> enumeration = prop.propertyNames();
        while (enumeration.hasMoreElements()) {
            Object o = enumeration.nextElement();
            System.out.println(o);
        }
    }

    public static void store() throws IOException {
        Properties prop = new Properties(defaults());
        prop.setProperty("name", "小明");
        prop.setProperty("age", "18");

        prop.store(new FileWriter("E:\\test1.properties"), "测试 store");
        prop.store(new FileOutputStream("E:\\test2.properties"), "测试 store");

        Properties prop1 = new Properties();
        prop1.load(new FileInputStream("E:\\test2.properties"));

        Properties prop2 = new Properties();
        prop2.load(new FileReader("E:\\test2.properties"));

        prop1.list(System.out);
        prop2.list(System.out);
    }

    public static void list() throws IOException {
        Properties prop = new Properties(defaults());
        prop.setProperty("name", "小明");
        prop.setProperty("age", "18");

        prop.list(System.out);

        prop.put(new Object(), "");
        prop.list(System.out);
    }

    public static void loadFromXML() throws IOException {
        Properties prop = new Properties();
        prop.loadFromXML(Test1.class.getResourceAsStream("/test.xml"));
        prop.list(System.out);
    }

    public static void storeToXML() throws IOException {
        Properties prop = new Properties(defaults());
        prop.setProperty("name", "小明");
        prop.setProperty("age", "18");

        prop.storeToXML(new FileOutputStream("E:\\test1.xml"), "测试 storeToXML");

        Properties prop1 = new Properties();
        prop1.loadFromXML(new FileInputStream("E:\\test1.xml"));

        prop1.list(System.out);
    }
}
