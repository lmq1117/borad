package com.sam.enums;

import lombok.val;

public enum Role {
    ADMIN(1,"ADMIN"),
    DEVELOP(2,"DEVELOP"),
    TEST(3,"TEST");

    private int value;
    private String desc;

    Role(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

}
