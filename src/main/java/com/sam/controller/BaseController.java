package com.sam.controller;

import com.sam.error.BusinessException;
import com.sam.error.EmBusinessError;
import com.sam.response.CommonReturnType;
import com.sam.service.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    @Autowired
    protected Msg msg;

    //定义exceptionHandler解决未被controller曾吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseData = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errorCode", businessException.getErrorCode());
            responseData.put("errorMessage", businessException.getErrorMessage());
        } else {
            responseData.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errorMessage", EmBusinessError.UNKNOWN_ERROR.getErrorMessage());
        }
        return CommonReturnType.create(responseData, "fail");
    }


    //protected void validate(){
    //
    //}

}
