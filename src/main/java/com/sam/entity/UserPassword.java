package com.sam.entity;

import lombok.Data;

@Data
public class UserPassword {
    private Integer id;
    private String encryptPassword;
    private Integer userId;

}
