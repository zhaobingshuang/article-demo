package me.zhao.validation.controller;

import me.zhao.validation.param.User;
import me.zhao.validation.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController
public class TestController {


    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String insertUser(
//            @Valid
//            @Validated
            @RequestBody User user) {
        return "添加成功: " + user;
//        return "";
//        return userService.insert(user);
    }


}