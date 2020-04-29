package com.sam.error;

public enum EmBusinessError implements CommonError {

    //通用错误类型
    PARAMETER_VALIDATION_ERROR(00001,"参数不合法"),

    //比如100开头的是用户相关错误定义
    USER_NOT_EXIST(10001,"用户不存在")
    ;

    private EmBusinessError(int errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private int errorCode;
    private String errorMessage;


    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
