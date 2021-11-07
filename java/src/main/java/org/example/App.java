package org.example;

import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
//        Properties properties = new Properties(defaults());
        properties.load(App.class.getResourceAsStream("/test.properties"));
        properties.forEach((k, v) -> System.out.println(k + ": " + v));

        String id = properties.getProperty("id");
        System.out.println("id: " + id);
    }

    public static Properties defaults() {
        Properties properties = new Properties();
        properties.setProperty("id", "100");
        return properties;
    }
}
