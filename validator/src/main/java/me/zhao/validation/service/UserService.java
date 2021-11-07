package me.zhao.validation.service;

import me.zhao.validation.param.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Service
public class UserService {

//    @Validated
    public String insert(@Valid User user) {
        System.out.println("添加成功: " + user);
        return "添加成功: " + user;
    }

}