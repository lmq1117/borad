package com.sam.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Msg {

    public ResponseEntity<Map<String, Object>> errorMsg(String msg, Map<String, Object> data) {
        return commonMsg(msg, data, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity<Map<String, Object>> errorMsg(String msg) {
        Map<String, Object> data = new HashMap<>();
        return errorMsg(msg, data);
    }


    public ResponseEntity<Map<String, Object>> successMsg(String msg, Map<String, Object> data) {
        return commonMsg(msg, data, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> successMsg(String msg) {
        Map<String, Object> data = new HashMap<>();
        return successMsg(msg, data);
    }


    private ResponseEntity<Map<String, Object>> commonMsg(String msg, Map<String, Object> data, HttpStatus status) {
        Map<String, Object> errMsg = new HashMap<>();
        errMsg.put("msg", msg);
        errMsg.put("data", data);
        return new ResponseEntity<Map<String, Object>>(errMsg, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
