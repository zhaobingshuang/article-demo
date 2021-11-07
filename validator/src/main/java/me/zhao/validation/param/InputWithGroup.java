package me.zhao.validation.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhao.validation.constraints.StartWith;
import me.zhao.validation.group.InputGroup;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputWithGroup {

    @Null(groups = {InputGroup.Insert.class})
    @NotNull(groups = {InputGroup.Update.class, InputGroup.InsertReturn.class})
    private String id;
}