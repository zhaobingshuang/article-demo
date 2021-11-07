package com.example.mailexcel;

import com.alibaba.excel.EasyExcel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MailExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailExcelApplication.class, args);
//        excel();
    }

//    public static void excel() {
//        EasyExcel.write("E:\\" + System.currentTimeMillis() + ".xlsx", User.class).sheet("测试").doWrite(data());
//    }
//
//    public static List<User> data() {
//        List<User> list = new ArrayList<>();
//        list.add(new User(1, "小明", 18));
//        list.add(new User(2, "小红", 20));
//        list.add(new User(3, "小华", 25));
//        return list;
//    }
}