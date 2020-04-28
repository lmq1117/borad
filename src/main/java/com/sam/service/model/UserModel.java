package com.sam.service.model;

import lombok.Data;

//java 领域模型
@Data
public class UserModel {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer age;
    private String telephone;
    private String registerMode;
    private String thirdPartyId;

    private String encryptPassword;

}
