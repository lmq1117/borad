package com.sam.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Setter
@Getter
@ToString
public class ReqUser {

    @NotNull(message = "姓名不能为空")
    @Size(min = 2,max=10,message = "姓名应该在2-10个字符之间")
    private String name;

    //@Range(min = 18,max = 60,message = "年龄应在18岁到60岁之间")
    @Min(value = 18,message = "年龄范围18-60")
    @Max(value = 60,message = "年龄范围18-60")
    private Integer age;

    // /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$",message = "手机号格式不正确")
    private String phone;
    //
    //@NotBlank(message = "角色不能为空")
    //@Enum(clazz = Role.class,method = "getValue",message = "role参数错误")
    //private String role;
}
