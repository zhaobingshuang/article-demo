package me.zhao.validation.controller;

import me.zhao.validation.param.InputWithCustomAnnotation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidateCustomController {

    @PostMapping("/validateCustom")
    public String validateServiceInput(@Valid @RequestBody InputWithCustomAnnotation input) {
        System.out.println(input);
        return "pass";
    }
}