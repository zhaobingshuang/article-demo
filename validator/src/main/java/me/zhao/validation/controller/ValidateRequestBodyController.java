package me.zhao.validation.controller;

import me.zhao.validation.param.Input;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ValidateRequestBodyController {

    @PostMapping("/validateRequestBody")
    public String validateRequestBody(
            // 使用 @Valid 也可以
            @Validated @RequestBody Input input) {
        return input.toString();
    }
}
