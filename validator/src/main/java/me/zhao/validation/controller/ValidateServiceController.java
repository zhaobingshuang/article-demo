package me.zhao.validation.controller;

import me.zhao.validation.param.Input;
import me.zhao.validation.service.ValidatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ValidateServiceController {

    private final ValidatingService validatingService;

    public ValidateServiceController(ValidatingService validatingService) {
        this.validatingService = validatingService;
    }

    @GetMapping("/validateServiceInput")
    public String validateServiceInput() {
        validatingService.validateInput(new Input(1, "111.111.111.111"));
        return "pass";
    }

    @GetMapping("/validateServiceId")
    public String validateServiceId() {
        validatingService.validateId(null);
        return "pass";
    }
}
