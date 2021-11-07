package me.zhao.validation.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Validated
@Data
public class User {

    @NotNull(message = "ID 不能为空")
    @Digits(integer = 4, fraction = 0, message = "ID 为纯数字，最长 4 位")
    private Integer id;

    @Length(min = 1, max = 10, message = "用户名为 1 到 10 个字符")
    private String name;

    @Range(min = 18, message = "未成年人不能注册")
    private Integer age;
}
