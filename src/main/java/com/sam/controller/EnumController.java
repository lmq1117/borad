package com.sam.controller;

import com.sam.controller.req.ReqUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enum")
@Slf4j
@Validated
public class EnumController {
    //public String addUser(@Validated ReqUser req){
    //    System.out.println("######");
    //    System.out.println(req.toString());
    //    return "success";
    //
    //}


    //正常post请求
    @PostMapping("/add")
    public String addUser(@Validated ReqUser req){
        //@Validated ReqUser req
        log.info("添加用户成功：{}",req.toString());
        log.info("添加用户成功：{}","dsfadfs");
        return "success";
    }

    //json方式的请求 区别在于是否有 @RequestBody 注解
    @PostMapping("/add2")
    public String addUserJson(@Validated @RequestBody ReqUser req){
        //@Validated ReqUser req
        log.info("添加用户成功：{}",req.toString());
        log.info("添加用户成功：{}","dsfadfs");
        return "success";
    }
}
