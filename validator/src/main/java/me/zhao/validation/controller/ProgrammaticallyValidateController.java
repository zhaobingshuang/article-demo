package me.zhao.validation.controller;

import me.zhao.validation.service.ProgrammaticallyValidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.zhao.validation.param.Input;
import me.zhao.validation.service.ValidatingService;


@RestController
public class ProgrammaticallyValidateController {

    private final ProgrammaticallyValidateService validateService;

    public ProgrammaticallyValidateController(ProgrammaticallyValidateService validateService) {
        this.validateService = validateService;
    }

    @GetMapping("/validateNoSpring")
    public String validateServiceInput() {
        return validateService.validateNoSpring(new Input(123, ""));
    }

    @GetMapping("/validateWithSpringValidator")
    public String validateServiceId() {
        return validateService.validateWithSpringValidator(new Input(123, ""));
    }

    @GetMapping("/validateFailFast")
    public String validateFailFast() {
        return validateService.validateFailFast(new Input(123, ""));
    }
}