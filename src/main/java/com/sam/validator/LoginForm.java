package com.sam.validator;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginForm {
    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 20, message = "用户名应在2-64个字之间")
    private String name;

    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 32, message = "密码应在2-32个字符之间")
    private String password;
}
