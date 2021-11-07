package me.zhao.validation.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class A {

    @NotNull
    @Length(min = 1)
    private String name;

    @Valid
    @NotNull
    private B b;

    @Valid
    @NotNull
    @Size(min = 1)
    private List<B> list;
}