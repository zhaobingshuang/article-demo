package me.zhao.validation.controller;

import me.zhao.validation.group.InputGroup;
import me.zhao.validation.param.InputWithGroup;
import me.zhao.validation.service.GroupValidateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GroupValidateController {

    private final GroupValidateService validateService;

    public GroupValidateController(GroupValidateService validateService) {
        this.validateService = validateService;
    }

    @PostMapping("validateInsert")
    public String validateInsert(@RequestBody InputWithGroup input) {

        return validateService.validateInsert(input);
    }

    @PostMapping("validateUpdate")
    public String validateUpdate(@RequestBody InputWithGroup input) {
        return validateService.validateUpdate(input);
    }

//    @PostMapping("validateInsert")
//    public String validateInsert(@Validated(InputGroup.Insert.class) @RequestBody InputWithGroup input) {
//        return input.toString();
//    }
//
//    @Validated(InputGroup.Update.class)
//    @PostMapping("validateUpdate")
//    public String validateUpdate(@Validated(InputGroup.Update.class) @RequestBody InputWithGroup input) {
//        return input.toString();
//    }
}
