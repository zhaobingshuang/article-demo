package me.zhao.validation.service;

import me.zhao.validation.group.InputGroup;
import me.zhao.validation.param.InputWithGroup;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@Service
@Validated(InputGroup.Insert.class)
public class GroupValidateService {

    @Validated(InputGroup.Insert.class)
    public @Null String validateInsert(@Valid InputWithGroup input) {
        return input.toString();
    }

    @Validated(InputGroup.Update.class)
    public String validateUpdate(@Valid InputWithGroup input) {
        return input.toString();
    }
}