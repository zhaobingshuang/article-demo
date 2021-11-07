package me.zhao.validation.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhao.validation.constraints.StartWith;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputWithCustomAnnotation {
    @StartWith("P")
    private String id;
}