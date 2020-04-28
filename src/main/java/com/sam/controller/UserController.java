package com.sam.controller;

import com.sam.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/validate")
public class UserController {
    @GetMapping("/add")
    public Long addUser(@Validated User user){
        user.setId(15L);
        return user.getId();
    }


    //public ResponseEntity<Map<String,Object>> login(){
    //
    //    retu
    //}

}