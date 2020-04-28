package com.sam.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    private Long id;
    @NotBlank
    private String name;
    private Integer age;
    private String email;
}
