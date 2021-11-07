package me.zhao.validation.controller;

import me.zhao.validation.param.A;
import me.zhao.validation.param.B;
import me.zhao.validation.service.ValidateNestService;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ValidateNestController {

    private final ValidateNestService validateService;

    public ValidateNestController(ValidateNestService validateService) {
        this.validateService = validateService;
    }

    @GetMapping("/validateNest")
    public String validateRequestBody() {
        A a = new A();
        a.setName("tom");
        B b = new B(1);
        a.setB(b);
        List<B> list = new ArrayList<>();
        B b1 = new B();
        B b2 = new B();
        list.add(b1);
        list.add(b2);
        a.setList(list);
        return validateService.validateNest(a);
    }
}