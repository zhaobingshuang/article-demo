package me.zhao.validation.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class ValidateRequestParamController {

    @GetMapping("/validateRequestParam")
    public String validateRequestBody(@RequestParam @Length(min = 5, max = 10) String id) {
        return id;
    }
}
