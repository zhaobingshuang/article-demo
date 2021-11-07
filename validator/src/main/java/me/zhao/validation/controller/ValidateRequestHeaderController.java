package me.zhao.validation.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class ValidateRequestHeaderController {

    @GetMapping("/validateRequestHeader")
    public String validateRequestBody(@RequestHeader @Length(min = 5, max = 10) String id) {
        return id;
    }
}
