package com.example.heima.properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
//        Properties properties = new Properties(defaults());
//        properties.load(new InputStreamReader(Test.class.getResourceAsStream("/test.properties"), StandardCharsets.UTF_8));
        properties.load(Test.class.getResourceAsStream("/test.properties"));
        properties.forEach((k, v) -> System.out.println(k + ": " + v));

        String id = properties.getProperty("id");
        System.out.println("id: " + id);

        Object old1 = properties.setProperty("gender", "男");
        System.out.println("old1: " + old1);
        Object old2 = properties.setProperty("gender", "女");
        System.out.println("old2: " + old2);

        properties.list(System.out);

        System.out.println("---------------enumeration-----------------");

        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            Object o = enumeration.nextElement();
            String v = properties.getProperty((String) o);
            System.out.println(o + ": " + v);
        }

    }

    public static Properties defaults() {
        Properties properties = new Properties();
        properties.setProperty("id", "100");
        return properties;
    }

    public static void constructor() {



    }

}
