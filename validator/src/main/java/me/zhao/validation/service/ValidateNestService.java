package me.zhao.validation.service;

import me.zhao.validation.param.A;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class ValidateNestService {

    public String validateNest(@Valid A a) {
        return a.toString();
    }
}
