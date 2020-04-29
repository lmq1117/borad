package com.sam.controller;

import com.sam.error.BusinessException;
import com.sam.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    //定义exceptionHandler解决未被controller曾吸收的exception

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception ex) {
        BusinessException businessException = (BusinessException) ex;
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus("fail");

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("errorCode", businessException.getErrorCode());
        responseData.put("errorMessage", businessException.getErrorMessage());

        commonReturnType.setData(responseData);
        return commonReturnType;
    }

}
