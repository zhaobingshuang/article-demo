package me.zhao.validation.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class ValidatePathVariableController {

    @GetMapping("/validatePathVariable/{id}")
    public String validateRequestBody(@PathVariable @Length(min = 5, max = 10) String id) {
        return id;
    }
}
