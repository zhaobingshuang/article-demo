package me.zhao.validation.service;

import me.zhao.validation.param.Input;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class ValidatingService {

    public void validateInput(@Valid Input input){
        System.out.println(input.toString());
        // do something
    }

    public void validateId(@NotNull String id){
        System.out.println(id);
        // do something
    }
}