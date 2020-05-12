package com.sam.validator;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class GetParamForm {
    @NotNull(message = "用户id不能为空")
    @Range(min = 100, message = "用户id不符合")
    private String userId;

    @NotBlank(message = "用户年龄不能为空")
    @Range(min = 18, max = 60, message = "年龄不合适")
    private String age;
}
