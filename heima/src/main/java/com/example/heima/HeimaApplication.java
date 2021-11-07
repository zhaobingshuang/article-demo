package com.example.heima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@EnableAsync
@SpringBootApplication
public class HeimaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeimaApplication.class, args);
    }
}