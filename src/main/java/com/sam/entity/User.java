package com.sam.entity;

import lombok.Data;

/*
    三层
    第一层 entity 与数据库完全一一映射 orm
    第二层 service层 不可以把entity层的映射透传给前端， service层要有一个model的概念
        领域模型：用于后端业务逻辑处理，前端只需要它需要的字段即可，并非整个领域模型本身
        model才是真正意义上 mvc中的model
 */

@Data
public class User {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer age;
    private String telephone;
    private String registerMode;
    private String thirdPartyId;
}
