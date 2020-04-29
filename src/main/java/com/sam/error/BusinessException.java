package com.sam.error;

public class BusinessException extends Exception implements CommonError {
    //强关联一个CommonError
    private CommonError commonError;

    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;

    }


    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMessage() {
        return this.commonError.getErrorMessage();
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.commonError.setErrorMessage(errorMessage);
        return this;
    }
}
