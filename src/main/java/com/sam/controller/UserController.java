package com.sam.controller;

import com.sam.controller.viewobject.UserVO;
import com.sam.entity.User;
import com.sam.service.UserService;
import com.sam.service.impl.UserServiceImpl;
import com.sam.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/add")
    public Integer addUser(@Validated User user) {
        user.setId(15);
        return user.getId();
    }


    //public ResponseEntity<Map<String,Object>> login(){
    //
    //    retu
    //}

    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam(name = "id") Integer id) {
        //调用service层获取对应id的用户对象并返回给前端
        return convertFromModel(userService.getUserById(id));
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

}